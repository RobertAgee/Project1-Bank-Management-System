package pojo;

public class BankPojo {

	private int bankId;
	private String bankPassword;
	private String bankOwner;
	private String bankType;
	private int bankBalance;
	
	public BankPojo() {
		super();
	}
	
	public BankPojo(int bankId, String bankPassword, String bankOwner, String bankType, int bankBalance) {
		super();
		this.bankId = bankId;
		this.bankPassword = bankPassword;
		this.bankOwner = bankOwner;
		this.bankType = bankType;
		this.bankBalance = bankBalance;

	}
	
	public int getBankId() {
		return bankId;
	}
	
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	
	public String getBankPassword() {
		return bankPassword;
	}
	
	public void setBankPassword(String bankPassword) {
		this.bankPassword = bankPassword;
	}
	public String getBankOwner() {
		return bankOwner;
	}
	
	public void setBankOwner(String bankOwner) {
		this.bankOwner = bankOwner;
	}
	
	public String getBankType() {
		return bankType;
	}
	
	public void setBankType(String bankType) {
		this.bankType = bankType;
	}
	
	public int getBankBalance() {
		return bankBalance;
	}
	
	public void setBankBalance(int bankBalance) {
		this.bankBalance = bankBalance;
	}
	
	@Override
	public String toString() {
		return "BankPojo [bankId=" + bankId + ", bankPassword=" + bankPassword + ", bankOwner=" + bankOwner + ", bankType="
				+ bankType + ", bankBalance=" + bankBalance + "]";
	}
	
}
