package com.prasanth.internetBanking.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prasanth.internetBanking.dto.ApplyLoan;
import com.prasanth.internetBanking.dto.ForgotPassword;
import com.prasanth.internetBanking.dto.SignIn;
import com.prasanth.internetBanking.dto.Statement;
import com.prasanth.internetBanking.service.BankingService;

@Controller
public class BankingController {

	@Autowired
	private BankingService bankingService;

	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("SignIn", new SignIn());
		return "index";
	}

	@RequestMapping("indexPage")
	public String indexPage(Model model,HttpSession session) {
		model.addAttribute("SignIn", new SignIn());
		session.invalidate();
		return "index";
	}

	@RequestMapping("login")
	public String signIn(@ModelAttribute("SignIn") SignIn signIn, HttpSession session) {
		String password = signIn.getPassword();

		session.setAttribute("password", password);

		String id = signIn.getId();
		String string = bankingService.signIn(signIn);
		if (string.contains("true")) {
			String[] data = string.split("-");
			String name = data[1];
			String balance = data[2];
			String accountNumber = data[3];

			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("balance", balance);
			session.setAttribute("accountNumber", accountNumber);
			return "welcome";
		}
		if (string.contains("false")) {
			return "indexFail";
		}
		return "errorPage";
	}

	@RequestMapping("forgotpassword")
	public String forgotpassword(Model model) {
		model.addAttribute("forgotpass", new ForgotPassword());
		return "forgotpassword";
	}

	@RequestMapping("forgotpasswordFail")
	public String forgotpasswordFail(Model model) {
		model.addAttribute("forgotpass", new ForgotPassword());
		return "forgotpasswordFail";
	}

	@RequestMapping("reset")
	public String reset(@ModelAttribute("forgotpass") ForgotPassword password, HttpSession session) {
		String string = bankingService.reset(password);

		if (string.equals("true")) {
			String id = password.getId();
			session.setAttribute("id", id);
			return "resetPassword";
		}
		if (string.equals("false")) {
			return "forgotpasswordFail";
		}
		return "errorPage";
	}

	@RequestMapping("changePassword")
	public String resetPassword(@RequestParam String password, HttpSession session) {

		Object object = session.getAttribute("id");
		int id = Integer.parseInt(object.toString());
		String string = bankingService.resetPassword(password, id);

		if (string.equals("true")) {
			return "passwordResetSuccess";
		}
		if (string.equals("false")) {
			return "passwordResetFail";
		}
		return "errorPage";
	}

	@RequestMapping("viewStatement")
	public String statement(HttpSession session) {
		try {
			Object object = session.getAttribute("accountNumber");
			String accountNumber = object.toString();
			@SuppressWarnings("unchecked")
			List<String> statement = bankingService.getStatement(accountNumber);

			session.setAttribute("statement", statement);
		}catch(NullPointerException e) {
			e.printStackTrace();
			return "errorPage";
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "statement";
	}

	@RequestMapping("welcome")
	public String welcome() {
		return "welcome";
	}

	@RequestMapping("moneyTransfer")
	public String money(Model model) {
		model.addAttribute("moneyTrans", new Statement());
		return "moneyTransfer";
	}

	@RequestMapping("transfer")
	public String transfer(@ModelAttribute("moneyTrans") Statement statement, HttpSession session) {
		Object object = session.getAttribute("accountNumber");
		String account = object.toString();
		statement.setRemitteraccount(account);
		Object object2 = session.getAttribute("id");
		int id = Integer.parseInt(object2.toString());
		String string = bankingService.moneyTransfer(statement, id);
		 if (string.contains("beneficiaryAccountIncorrect")) {
			return "accountIncorrect";
		}else if (string.contains("insufficientBalance")) {
			return "insufficientBalance";
		}
		else if (string.contains("error")) {
			return "errorPage";
		}
		session.setAttribute("balance", string);
		return "moneyTransferSuccess";
	}

	@RequestMapping("recharge")
	public String recharge(Model model) {
		model.addAttribute("moneyTrans", new Statement());
		return "recharge";
	}

	@RequestMapping("mobileRecharge")
	public String mobileRecharge(@ModelAttribute("moneyTrans") Statement statment, HttpSession session) {
		String name = session.getAttribute("name").toString();
		String remitterAccount = session.getAttribute("accountNumber").toString();
		statment.setRemitteraccount(remitterAccount);
		statment.setBeneficiaryaccount(name + " recharge");
		statment.setName(name);

		String password = session.getAttribute("password").toString();
		String conformPassword = statment.getRemarks();

		if (password.equals(conformPassword)) {
			int id = Integer.parseInt(session.getAttribute("id").toString());
			String string = bankingService.mobileRecharge(statment, id);
			if (string.equals("insufficientBalance")) {
				return "insufficientBalance";
			} else {
				session.setAttribute("balance", string);
				return "rechargeSuccess";
			}
		}
		return "rechargeFailure";
	}

	@RequestMapping("cards")
	public String cards() {
		return "cards";
	}

	@RequestMapping("blockCard")
	public String blockCard() {
		return "blockCard";
	}

	@RequestMapping("cardBlock")
	public String blockCard(@RequestParam String card, @RequestParam String password, HttpSession session) {
		int id = Integer.parseInt(session.getAttribute("id").toString());
		String string = bankingService.cardBlock(card, id);

		String userPassword = session.getAttribute("password").toString();
		if (userPassword.equals(password)) {

			if (string.equals("blockCardSuccess")) {
				return "blockCardSuccess";
			} else if (string.equals("alreadyBlocked")) {
				return "alreadyBlocked";
			}
		}else {
			return "passwordIncorrect";
		}
		return "somthingWrong";
	}
	
	@RequestMapping("changePin")
	public String changePin() {
		return "changePin";
	}
	
	@RequestMapping("changePinNumber")
	public String changePinNumber(@RequestParam String card,@RequestParam String pin, HttpSession session) {
		int id = Integer.parseInt(session.getAttribute("id").toString());
		String string=bankingService.changePin(id,pin,card);
		
		if (string.equals("true")) {
			return "changePinSuccess";
		}
		return "somthingWrong";
	}
	
	@RequestMapping("setLimit")
	public String setLimit() {
		return "setLimit";
	}
	
	@RequestMapping("setCardLimit")
	public String setCardLimit(@RequestParam int limit, HttpSession session) {
		int id = Integer.parseInt(session.getAttribute("id").toString());
		String string=bankingService.setLimit(limit, id);
		if (string.equals("true")) {
			return "setLimitSuccess";
		}
		return "somthingWrong";
	}
	
	@RequestMapping("loans")
	public String loan() {
		return "loans";
	}
	
	@RequestMapping("applyLoan")
	public String applyLoan(Model model) {
		model.addAttribute("loan", new ApplyLoan());
		return "applyLoan";
	}
	
	
	@RequestMapping("loanApplication")
	public String loanApplication(@ModelAttribute("loan") ApplyLoan loan,HttpSession session) {
		int id = Integer.parseInt(session.getAttribute("id").toString());
		loan.setId(id);
		
		String string = bankingService.loanApplication(loan);
		if (string.equals("true")) {
			return "applyLoanSuccess";
		}
		return "somthingWrong";
	}
	
	@RequestMapping("loanStatus")
	public String loanStatue(HttpSession session) {
		try {
			int id = Integer.parseInt(session.getAttribute("id").toString());
			ApplyLoan loanStatus = bankingService.loanStatus(id);
			session.setAttribute("status", loanStatus.getRemarks());
			return "loanStatus";
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("status","You have not applied for loan previously");
			return "loanStatus";
		}
	}
	
	@RequestMapping("errorPage")
	public String errorPage() {
		return "errorPage";
	}
	
}