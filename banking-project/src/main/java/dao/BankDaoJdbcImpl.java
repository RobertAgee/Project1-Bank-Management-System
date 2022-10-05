package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pojo.BankPojo;
import pojo.TransactionPojo;

public class BankDaoJdbcImpl implements BankDao{

	@Override
	public BankPojo[] getAllBanks() {
		Connection connection = DBUtil.makeConnection();
		BankPojo[] fetchedBanks = null;
		try {
			Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String query = "SELECT * FROM bank_details";
			ResultSet rs = stmt.executeQuery(query);

			int counter = 0;
			while(rs.next()) {
				counter++;
			}
			fetchedBanks = new BankPojo[counter];
			
			int i = 0;
			rs.beforeFirst();
			while(rs.next()) {
				fetchedBanks[i] = new BankPojo();
				fetchedBanks[i].setBankId(rs.getInt(1));
				fetchedBanks[i].setBankPassword(rs.getString(2));
				fetchedBanks[i].setBankOwner(rs.getString(3));
				fetchedBanks[i].setBankType(rs.getString(4));
				fetchedBanks[i].setBankBalance(rs.getInt(5));
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fetchedBanks;
	}

	@Override
	public BankPojo addBank(BankPojo bankPojo) {
		Connection connection = DBUtil.makeConnection(); // step 1 and 2 is done in this
		
		String query = "INSERT INTO bank_details(bank_password, bank_owner, bank_type, bank_balance) VALUES(?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, bankPojo.getBankPassword());
			pstmt.setString(2, bankPojo.getBankOwner());
			pstmt.setString(3, bankPojo.getBankType());
			pstmt.setInt(4, bankPojo.getBankBalance());
						
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bankPojo;
	}

	@Override
	public BankPojo updateBank(BankPojo bankPojo) {
Connection connection = DBUtil.makeConnection(); 
		
		String query = "UPDATE bank_details SET bank_balance=? WHERE bank_id=?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1, bankPojo.getBankBalance());
			pstmt.setInt(2, bankPojo.getBankId());
						
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bankPojo;
	}

	@Override
	public void deleteBank(int bankId) {
		Connection connection = DBUtil.makeConnection();
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			String query = "DELETE FROM bank_details WHERE bank_id=" + bankId;
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public BankPojo getABank(int bankId) {
		Connection connection = DBUtil.makeConnection();
		Statement stmt = null;
		BankPojo bankPojo = null;
		try {
			stmt = connection.createStatement();
			String query = "SELECT * FROM bank_details WHERE bank_id=" + bankId;
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next()) {
				bankPojo = new BankPojo();
				bankPojo.setBankId(rs.getInt(1));
				bankPojo.setBankPassword(rs.getString(2));
				bankPojo.setBankOwner(rs.getString(3));
				bankPojo.setBankType(rs.getString(4));
				bankPojo.setBankBalance(rs.getInt(5));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bankPojo;
	}
	@Override
	public BankPojo getABank(int bankId, String bankPassword) {
		Connection connection = DBUtil.makeConnection();
		Statement stmt = null;
		BankPojo bankPojo = null;
		try {
			stmt = connection.createStatement();
			String query = "SELECT * FROM bank_details WHERE bank_id=" + bankId + " AND bank_password= '" + bankPassword +"'";
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next()) {
				bankPojo = new BankPojo();
				bankPojo.setBankId(rs.getInt(1));
				bankPojo.setBankPassword(rs.getString(2));
				bankPojo.setBankOwner(rs.getString(3));
				bankPojo.setBankType(rs.getString(4));
				bankPojo.setBankBalance(rs.getInt(5));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bankPojo;
	}
	@Override
	public TransactionPojo[] historyBank(int fromBankId) {
		Connection connection = DBUtil.makeConnection();
		TransactionPojo[] fetchedBanks = null;
		try {
			Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String query = "SELECT * FROM transaction_details WHERE to_bank_id = " + fromBankId + " OR from_bank_id = " + fromBankId;
			ResultSet rs = stmt.executeQuery(query);

			int counter = 0;
			while(rs.next()) {
				counter++;
			}
			fetchedBanks = new TransactionPojo[counter];
			
			int i = 0;
			rs.beforeFirst();
			while(rs.next()) {
				fetchedBanks[i] = new TransactionPojo();
				fetchedBanks[i].setFromBankId(rs.getInt(1));
				fetchedBanks[i].setToBankId(rs.getInt(2));
				fetchedBanks[i].setToBankSend(rs.getInt(3));
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fetchedBanks;
	}
	
	@Override
	public TransactionPojo transferBank(TransactionPojo transactionPojo) {
		Connection connection = DBUtil.makeConnection();
		
			String query = "INSERT INTO transaction_details(from_bank_id, to_bank_id, bank_amount) VALUES(?, ?, ?)";
			try {
				PreparedStatement pstmt = connection.prepareStatement(query);
				
				pstmt.setInt(1, transactionPojo.getFromBankId());
				pstmt.setInt(2, transactionPojo.getToBankId());
				pstmt.setInt(3, transactionPojo.getToBankSend());
							
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return transactionPojo;
	}


	@Override
	public TransactionPojo[] getHistoryBank() {
		return null;
	}

	@Override
	public TransactionPojo[] allHistoryBank() {
		Connection connection = DBUtil.makeConnection();
		TransactionPojo[] fetchedHistoryBanks = null;
		try {
			Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String query = "SELECT * FROM transaction_details";
			ResultSet rs = stmt.executeQuery(query);

			int counter = 0;
			while(rs.next()) {
				counter++;
			}
			fetchedHistoryBanks = new TransactionPojo[counter];
			
			int i = 0;
			rs.beforeFirst();
			while(rs.next()) {
				fetchedHistoryBanks[i] = new TransactionPojo();
				fetchedHistoryBanks[i].setFromBankId(rs.getInt(1));
				fetchedHistoryBanks[i].setToBankId(rs.getInt(2));
				fetchedHistoryBanks[i].setToBankSend(rs.getInt(3));
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fetchedHistoryBanks;
	}
	}


