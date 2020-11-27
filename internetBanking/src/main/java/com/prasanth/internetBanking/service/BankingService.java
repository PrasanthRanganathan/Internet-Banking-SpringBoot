package com.prasanth.internetBanking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prasanth.internetBanking.dao.BankingDao;
import com.prasanth.internetBanking.dto.ApplyLoan;
import com.prasanth.internetBanking.dto.ForgotPassword;
import com.prasanth.internetBanking.dto.SignIn;
import com.prasanth.internetBanking.dto.Statement;

@Service
public class BankingService {

	@Autowired
	private BankingDao bankingDao;
	
	@Transactional
	public String signIn(SignIn signIn) {
		return bankingDao.signIn(signIn);
	}

	@Transactional
	public String reset(ForgotPassword password) {
		return bankingDao.reset(password);
	}

	@Transactional
	public String resetPassword(String password, int id) {
		return bankingDao.resetPassword(password, id);
	}

	@Transactional
	@SuppressWarnings("rawtypes")
	public List getStatement(String accountNumber) {
		return bankingDao.getStatement(accountNumber);
	}

	@Transactional
	public String moneyTransfer(Statement statement,int id) {
		return bankingDao.moneyTransfer(statement,id);
	}

	@Transactional
	public String mobileRecharge(Statement statment, int id) {
		return bankingDao.mobileRecharge(statment,id);
	}

	@Transactional
	public String cardBlock(String card, int id) {
		return bankingDao.cardBlock(card,id);
	}

	@Transactional
	public String changePin(int id, String pin, String card) {
		return bankingDao.changePin(id, pin, card);
	}

	@Transactional
	public String setLimit(int limit, int id) {
		return bankingDao.setPin(limit, id);
	}

	@Transactional
	public String loanApplication(ApplyLoan loan) {
		return bankingDao.loanApplication(loan);
	}

	@Transactional
	public ApplyLoan loanStatus(int id) {
		return bankingDao.loanStatus(id);
	}
}
