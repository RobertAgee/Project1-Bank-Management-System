package dao;

import pojo.BankPojo;
import pojo.TransactionPojo;

public interface BankDao {
	BankPojo[] getAllBanks();
	
	BankPojo addBank(BankPojo bankPojo);
	
	BankPojo updateBank(BankPojo bankPojo);
	
	void deleteBank(int bankId);

	BankPojo getABank(int bankId);
	
	BankPojo getABank(int bankId, String bankPassword);
	
	TransactionPojo transferBank(TransactionPojo newTransaction);
	
	TransactionPojo[] getHistoryBank();
	
	TransactionPojo[] historyBank(int fromBankId);
	
	TransactionPojo[] allHistoryBank();
}