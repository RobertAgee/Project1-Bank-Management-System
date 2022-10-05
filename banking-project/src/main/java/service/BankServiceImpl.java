package service;

import dao.*;
import pojo.*;

public class BankServiceImpl implements BankService{

	BankDao bankDao; 
		
	public BankServiceImpl() {
		bankDao = new BankDaoJdbcImpl();
	}

	@Override
	public BankPojo[] getAllBanks() {
		return bankDao.getAllBanks();
	}

	@Override
	public BankPojo addBank(BankPojo bankPojo) {
		return bankDao.addBank(bankPojo);
	}

	@Override
	public BankPojo updateBank(BankPojo bankPojo) {
		return bankDao.updateBank(bankPojo);
	}

	@Override
	public void deleteBank(int bankId) {
		bankDao.deleteBank(bankId);
	}
	@Override
	public BankPojo getABank(int bankId) {
		return bankDao.getABank(bankId);
	}
	@Override
	public BankPojo getABank(int bankId, String bankPassword) {
		return bankDao.getABank(bankId, bankPassword);
	}


	@Override
	public TransactionPojo transferBank(TransactionPojo newTransaction) {
		return bankDao.transferBank(newTransaction);
	}

	@Override
	public TransactionPojo[] historyBank(int fromBankId) {
		return bankDao.historyBank(fromBankId);
	}

	@Override
	public TransactionPojo[] allHistoryBank() {
		return bankDao.allHistoryBank();

	}


}
