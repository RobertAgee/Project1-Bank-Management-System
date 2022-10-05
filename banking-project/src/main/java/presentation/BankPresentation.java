package presentation;
import java.util.Scanner;

import pojo.*;
import pojo.BankPojo;
import service.BankService;
import service.BankServiceImpl;



public class BankPresentation {

	public static void main(String[] args) {
		BankService bankService = new BankServiceImpl(); 
		Scanner scan = new Scanner(System.in);
		char continueApp = 'y';
		while (continueApp == 'y' || continueApp == 'Y') {

			System.out.println("*************************************************");
			System.out.println("\t\tWELCOME TO BMO BANK");
			System.out.println("*************************************************");
			System.out.println("LOGIN MENU");
			System.out.println("*************************************************");
			System.out.println("1. Login as an Employee.");
			System.out.println("2. Login as a Customer.");
			System.out.println("3. Exit.");
			System.out.println("*************************************************");
			System.out.println("Please enter an option : ");
			int logOption = scan.nextInt();
			switch (logOption) {
			case 1:
				
				System.out.println("Please enter username : ");
				String userName = scan.next();
				System.out.println("Please enter password : ");
				String passWord = scan.next();
				
				if(userName.equals("admin") && passWord.equals("root")) {
					while(logOption == 1) {
				System.out.println("*************************************************");
				System.out.println("\t\tEMPLOYEE MENU");
				System.out.println("*************************************************");
				System.out.println("1. Create New Account.");
				System.out.println("2. Delete Account.");
				System.out.println("3. List All Accounts.");
				System.out.println("4. List All Transactions.");
				System.out.println("5. Logout and Exit.");
				System.out.println("*************************************************");
				System.out.println("Please enter an option : ");
				
				int empOption = scan.nextInt();
				System.out.println("*************************************************");
				
				switch (empOption) {
				case 1:
					System.out.println("Set Account Password: ");
					scan.nextLine();
					String bankPassword = scan.nextLine();
					
					System.out.println("Enter Account Owner: ");
					String bankOwner = scan.nextLine();
					
					System.out.println("Enter Account Type: ");
					System.out.println("C - Checking or S - Savings ");
					String bankType = "";
					while(bankType == "") {
					char accConfirm = scan.next().charAt(0);	
					if(accConfirm == 'c' || accConfirm == 'C') {
						bankType = "CHECKING";
					} else if(accConfirm == 's' || accConfirm == 'S') {
						bankType = "SAVINGS ";
						}
					}
					System.out.println("Enter Starting Balance: ");
					int bankBalance = scan.nextInt();
					
					
					BankPojo newBank = new BankPojo();
					newBank.setBankPassword(bankPassword);
					newBank.setBankOwner(bankOwner);
					newBank.setBankType(bankType);
					newBank.setBankBalance(bankBalance);
					System.out.println("=============================");
					System.out.println("Account OWNER : " + newBank.getBankOwner());
					System.out.println("Account TYPE : " + newBank.getBankType());
					System.out.println("Account BALANCE : $" + newBank.getBankBalance());
					System.out.println("=============================");
					System.out.println("Are you sure that you want to add the account? (y/n) :");
					char addConfirm = scan.next().charAt(0);
					if(addConfirm == 'y') {
						bankService.addBank(newBank);
						System.out.println("Account Added!!");
					} else { System.out.println("Account Not Added!!"); }
					
					break;
										
				case 2:
					System.out.println("Please enter the Account ID to be removed: ");
					int inputBankId = scan.nextInt();
					BankPojo returnBankPojo = bankService.getABank(inputBankId);
					if(returnBankPojo == null) {
						System.out.println("Account with ID " + inputBankId + " does not exist!!");
					} else {
						System.out.println("=============================");
						System.out.println("Account ID : " + returnBankPojo.getBankId());
						System.out.println("Account OWNER : " + returnBankPojo.getBankOwner());
						System.out.println("Account TYPE : " + returnBankPojo.getBankType());
						System.out.println("Account BALANCE : $" + returnBankPojo.getBankBalance());
						System.out.println("=============================");
					}
					System.out.println("Are you sure that you want to delete the account? (y/n) :");
					char deleteConfirm = scan.next().charAt(0);
					if(deleteConfirm == 'y') {
						bankService.deleteBank(inputBankId);
						System.out.println("Account Removed!!");
					}
					break;
				case 3:
					BankPojo[] fetchedAccount = bankService.getAllBanks();
					System.out.println("=============================================================================");
					System.out.println("ID\tOWNER\t\t\tTYPE\t\tACCOUNT BALANCE");
					System.out.println("=============================================================================");
					for(int i=0;i<fetchedAccount.length;i++) {
						if(fetchedAccount[i] != null) {
							System.out.println(fetchedAccount[i].getBankId() + "\t" + fetchedAccount[i].getBankOwner() + "\t\t" + fetchedAccount[i].getBankType() + "\t\t$" + fetchedAccount[i].getBankBalance());
						}
					}
					System.out.println("=============================================================================");
					break;
				
				case 4:
					TransactionPojo[] fetchedAllHistory = bankService.allHistoryBank();
					System.out.println("=============================================================================");
					System.out.println("SENDING ACCOUNT\t\tRECEIVING ACCOUNT\t\tAMOUNT SENT");
					System.out.println("=============================================================================");
					for(int i=0;i<fetchedAllHistory.length;i++) {
						if(fetchedAllHistory[i] != null) {
							System.out.println(fetchedAllHistory[i].getFromBankId() + "\t\t\t" + fetchedAllHistory[i].getToBankId() + "\t\t\t\t$" + fetchedAllHistory[i].getToBankSend());
						}
					}
					System.out.println("=============================================================================");
					break;
					
				case 5:
					System.out.println("*************************************************");
					System.out.println("\tTHANK YOU FOR USING BMO BANK!!");
					System.out.println("*************************************************");
					System.exit(0);
					
					break;
				default:
					System.out.println("Please enter a valid option!!");
				}
					}
				} else {
					
					System.out.println("*************************************************");
					System.out.println("CREDENTIALS FAILED TERMINATING CONNECTION");
					System.out.println("*************************************************");
					System.out.println("\tTHANK YOU FOR USING BMO BANK!!");
					System.out.println("*************************************************");
					System.exit(0);
				}
				
			case 2:
				BankPojo returnedBankPojo = null;
				while(returnedBankPojo == null) {
				System.out.println("Please enter the Account ID: ");
				int fetchBankId = scan.nextInt();
				System.out.println("Please enter the Account Password: ");
				String fetchBankPassword = scan.next();
				
				returnedBankPojo = bankService.getABank(fetchBankId, fetchBankPassword);
				while(logOption == 2) {
				if(returnedBankPojo == null) {
					System.out.println("Account/Password is incorrect!");
				} else {
				
				System.out.println("\t\tCUSTOMER MENU");
				System.out.println("*************************************************");
				System.out.println("1. View Account Details.");
				System.out.println("2. Transfer Money.");
				System.out.println("3. View Transaction History.");
				System.out.println("4. Logout and Exit.");
				System.out.println("*************************************************");
				System.out.println("Please enter an option : ");
				int custOption = scan.nextInt();
				System.out.println("*************************************************");
				switch(custOption) {
				case 1: 
					BankPojo fetchedBankPojo = bankService.getABank(fetchBankId);
						System.out.println("=============================");
						System.out.println("Account ID : " + fetchedBankPojo.getBankId());
						System.out.println("Account OWNER : " + fetchedBankPojo.getBankOwner());
						System.out.println("Account TYPE : " + fetchedBankPojo.getBankType());
						System.out.println("Account BALANCE : $" + fetchedBankPojo.getBankBalance());
						System.out.println("=============================");
						break;
				case 2:
					BankPojo fromBankPojo = bankService.getABank(fetchBankId);
					System.out.println("Please enter the Receiver's Account ID:");
					int toBankId = scan.nextInt();
					BankPojo toBankPojo = bankService.getABank(toBankId);
					if(toBankPojo == null) {
						System.out.println("Account with ID " + toBankId + " does not exist!!");
					} else if (fetchBankId == toBankId) {
						System.out.println("Cannot transfer to self!!");
					} else {
						
					
					System.out.println("Your Current Account Balance : " + fromBankPojo.getBankBalance());
					System.out.println("Please enter the Amount to send:");
					int toBankSend = scan.nextInt();
					while(toBankSend < 0 || toBankSend > fromBankPojo.getBankBalance()) {
						System.out.println("Please enter a valid Amount to send:");
						toBankSend = scan.nextInt();
					}
					
					int oldFromBalance = fromBankPojo.getBankBalance();
					int newFromBalance = oldFromBalance - toBankSend;
					fromBankPojo.setBankBalance(newFromBalance);
					
					int oldToBalance = toBankPojo.getBankBalance();
					int newToBalance = oldToBalance + toBankSend;
					toBankPojo.setBankBalance(newToBalance);
					
					TransactionPojo newTransaction = new TransactionPojo();
					newTransaction.setFromBankId(fetchBankId);
					newTransaction.setToBankId(toBankId);
					newTransaction.setToBankSend(toBankSend);
					System.out.println("Are you sure you want to transfer to this account? (y/n) :");
					char transferConfirm = scan.next().charAt(0);
					if(transferConfirm == 'y') {
						bankService.updateBank(fromBankPojo);
						bankService.updateBank(toBankPojo);
						bankService.transferBank(newTransaction);
						System.out.println("*************************************************");
						System.out.println("Bank Transfer Completed Successfully!!");
					} else{
						System.out.println("Bank Transfer Cancelled!!");
						}
					}
					break;
				case 3:
					TransactionPojo[] fetchedHistory = bankService.historyBank(fetchBankId);
					System.out.println("=============================================================================");
					System.out.println("SENDING ACCOUNT\t\tRECEIVING ACCOUNT\t\tAMOUNT SENT");
					System.out.println("=============================================================================");
					for(int i=0;i<fetchedHistory.length;i++) {
						if(fetchedHistory[i] != null) {
							System.out.println(fetchedHistory[i].getFromBankId() + "\t\t\t" + fetchedHistory[i].getToBankId() + "\t\t\t\t$" + fetchedHistory[i].getToBankSend());
						}
					}
					System.out.println("=============================================================================");
					break;
				case 4:
					System.out.println("*************************************************");
					System.out.println("\tTHANK YOU FOR USING BMO BANK!!");
					System.out.println("*************************************************");
					System.exit(0);
					break;
				default:
					break;
				}
				}
				}
				break;
				}
			case 3:
				System.out.println("*************************************************");
				System.out.println("\tTHANK YOU FOR USING BMO BANK!!");
				System.out.println("*************************************************");
				System.exit(0);
				break;
			default:
				System.out.println("Please enter a valid option!!");
			
			}
		}
		scan.close();
		}
}



