package service;

import pojo.*;

public interface BankService {
	BankPojo[] getAllBanks();
	
	BankPojo addBank(BankPojo bankPojo);
	
	BankPojo updateBank(BankPojo bankPojo);
	
	void deleteBank(int bankId);
	
	BankPojo getABank(int bankId);

	BankPojo getABank(int bankId, String bankPassword);
	
	TransactionPojo transferBank(TransactionPojo newTransaction);

	TransactionPojo[] historyBank(int fromBankId);

	TransactionPojo[] allHistoryBank();

}
