package com.prasanth.internetBanking.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prasanth.internetBanking.dto.Account;
import com.prasanth.internetBanking.dto.ApplyLoan;
import com.prasanth.internetBanking.dto.Cards;
import com.prasanth.internetBanking.dto.ChangePin;
import com.prasanth.internetBanking.dto.ForgotPassword;
import com.prasanth.internetBanking.dto.ResetPassword;
import com.prasanth.internetBanking.dto.SignIn;
import com.prasanth.internetBanking.dto.Statement;

@Repository
public class BankingDao {
	
	@Autowired
	private EntityManager entityManager;

	public String signIn(SignIn signIn) {

		try {
			String id = signIn.getId();
			String password = signIn.getPassword();

			Session session = entityManager.unwrap(Session.class);
			SignIn resultList = session.get(SignIn.class, id);
			Account account = session.get(Account.class, id);

			String id2 = resultList.getId();
			String password2 = resultList.getPassword();

			if (id.equals(id2) && password.equals(password2)) {
				String accountNumber = account.getAccount();
				String balance = account.getBalance();
				String name = account.getName();
				return "true" + "-" + name + "-" + balance + "-" + accountNumber;
			}
			return "false";
		}catch (NullPointerException e) {
			e.printStackTrace();
			return "false";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public String reset(ForgotPassword password) {
		try {
			String id = password.getId();
			String number = password.getNumber();
			ForgotPassword forgotPassword = entityManager.unwrap(Session.class).get(ForgotPassword.class, id);
			String id2 = forgotPassword.getId();
			String number2 = forgotPassword.getNumber();
			if (id.equals(id2) && number.equals(number2)) {
				return "true";
			}
			return "false";
		}catch (NullPointerException e) {
			e.printStackTrace();
			return "false";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public String resetPassword(String password, int id) {

		try {
			ResetPassword resetPassword = new ResetPassword();
			resetPassword.setId(id);
			resetPassword.setPassword(password);
			Session session = entityManager.unwrap(Session.class);
			int i = session.createSQLQuery("update login set password=? where id=?").setParameter(1, password).setParameter(2, id)
					.executeUpdate();
			if (i>0) {
				return "true";
			}else {
				return "false";
			}
		}catch (NullPointerException e) {
			e.printStackTrace();
			return "false";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public List<String> getStatement(String accountNumber) {

		List<String> list2 = new ArrayList<String>();
		try {

			List<Statement> list = entityManager.unwrap(Session.class).createQuery("from Statement where remitteraccount=:account",Statement.class).setParameter("account", accountNumber).getResultList();
			
			Iterator<Statement> iterator = list.iterator();
			while (iterator.hasNext()) {
				 Statement statement = iterator.next();
				if (statement.getRemitteraccount().equals(accountNumber)) {
					list2.add(statement.getRemitteraccount());
					list2.add(statement.getBeneficiaryaccount());
					list2.add(statement.getName());
					list2.add(statement.getPaymentmode());
					list2.add("&#x20b9 "+statement.getAmount());
					list2.add(statement.getRemarks());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list2;
	}

	public String moneyTransfer(Statement statement, int id) {

		try {
			Session session = entityManager.unwrap(Session.class);

			Account account = session.get(Account.class, id);
			Double balance = Double.parseDouble(account.getBalance());
			Double transferAmount=0.0;
			
			try {
				transferAmount= Double.parseDouble(statement.getAmount());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			if ((transferAmount) < (balance)) {

				String updatedBalance = Double.toString((balance) - transferAmount);

				account.setBalance(updatedBalance);
				session.update(account);

				String beneficiaryaccount = statement.getBeneficiaryaccount();
				String beneficiaryname = statement.getName();

				Object object=null;
				try {
					object = session
							.createSQLQuery("select id from account where account=:account and name=:beneficiaryname")
							.setParameter("account", beneficiaryaccount).setParameter("beneficiaryname", beneficiaryname)
							.getSingleResult();
				}catch (Exception e) {
					e.printStackTrace();
				}
				if (object != null) {

					int beneficiaryId = Integer.parseInt(object.toString());
					Account account2 = session.get(Account.class, beneficiaryId);
					Double beneficiarybalance =Double.parseDouble(account2.getBalance());
					String beneficiaryUpdatedBalance = Double
							.toString(beneficiarybalance + transferAmount);

					account2.setBalance(beneficiaryUpdatedBalance);
					session.save(statement);
					session.update(account2);

					return updatedBalance;

				} else {
					return "beneficiaryAccountIncorrect";
				}

			} else {
				return "insufficientBalance";
			}
		}catch(NumberFormatException e) {
			e.printStackTrace();
			return "insufficientBalance";
		}
		catch (NullPointerException e) {
			e.printStackTrace();
			return "beneficiaryAccountIncorrect";
		} 
		catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public String mobileRecharge(Statement statment, int id) {
		try {
			statment.setRemarks("online recharge");
			Session session = entityManager.unwrap(Session.class);
			Account account = session.get(Account.class, id);
			
			Double balance =Double.parseDouble(account.getBalance());
			Double amount =Double.parseDouble(statment.getAmount());
			if (amount<balance) {
				String updatedBalance=Double.toString(balance-amount);
				account.setBalance(updatedBalance);
				session.update(account);
				session.save(statment);
				return updatedBalance;
			}
			return "insufficientBalance";
		}catch (NullPointerException e) {
			e.printStackTrace();
			return "insufficientBalance";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public String cardBlock(String card, int id) {
		try {
			Session session = entityManager.unwrap(Session.class);
			Cards cards = session.get(Cards.class,id);
			String creditcard = cards.getCreditcard();
			String debitcard = cards.getDebitcard();
			
			if (card.equals("Credit Card")) {
				if (creditcard.equals("active")) {
					cards.setCreditcard("block");
					session.update(cards);
					return "blockCardSuccess";
				}
				else {
					return "alreadyBlocked";
				}
			}
			else if (card.equals("Debit Card")) {
				if (debitcard.equals("active")) {
					cards.setDebitcard("block");
					session.update(cards);
					return "blockCardSuccess";
				}
				else {
					return "alreadyBlocked";
				}
			}
			return "false";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public String changePin(int id, String pin, String card) {
		try {
			Session session = entityManager.unwrap(Session.class);
			ChangePin changePin = session.get(ChangePin.class, id);
			if (card.equals("Credit Card")) {
				changePin.setCreditCardPin(pin);
				session.update(changePin);
				return "true";
			}else if(card.equals("Debit Card")) {
				changePin.setDebitCardPin(pin);
				session.update(changePin);
				return "true";
			}
			return "false";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}

	public String setPin(int limit,int id) {
		try {
			Session session = entityManager.unwrap(Session.class);
			String query="update login  set withdrawnlimit=:limit where id=:id";
			int i = session.createSQLQuery(query).setParameter("limit", limit).setParameter("id", id).executeUpdate();
			if (i>0) {
				return "true";
			}
			return "false";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}

	public String loanApplication(ApplyLoan loan) {
		try {
			loan.setStatus("under process");
			loan.setRemarks("under process");
			Session session = entityManager.unwrap(Session.class);
			session.saveOrUpdate(loan);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	}

	public ApplyLoan loanStatus(int id) {
		try {
			return entityManager.unwrap(Session.class).get(ApplyLoan.class, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
