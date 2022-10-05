package pojo;

public class TransactionPojo {

	private int fromBankId;
	private int toBankId;
	private int toBankSend;
	
	public TransactionPojo() {
		super();
	}

	public TransactionPojo(int fromBankId, int toBankId, int toBankSend) {
		super();
		this.fromBankId = fromBankId;
		this.toBankId = toBankId;
		this.toBankSend = toBankSend;
		
	}
	
	public TransactionPojo(int fromBankId) {
		super();
		this.fromBankId = fromBankId;
	}
	
	public int getFromBankId() {
		return fromBankId;
	}

	public void setFromBankId(int fromBankId) {
		this.fromBankId = fromBankId;
	}

	public int getToBankId() {
		return toBankId;
	}

	public void setToBankId(int toBankId) {
		this.toBankId = toBankId;
	}

	public int getToBankSend() {
		return toBankSend;
	}

	public void setToBankSend(int toBankSend) {
		this.toBankSend = toBankSend;
	}

	
}
