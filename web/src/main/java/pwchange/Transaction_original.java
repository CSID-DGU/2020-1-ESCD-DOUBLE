package pwchange;

public class Transaction_original {

	String sender;
	String receiver;
	double amount;
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Transaction_original(String sender, String receiver, double amount) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.amount = amount;
	}
	 public String getInfo() {
		 return sender+"가 "+receiver+"에게"+amount+"개의 코인을 보냈다";
	 }
	
}
