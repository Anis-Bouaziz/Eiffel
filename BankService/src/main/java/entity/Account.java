package entity;

public class Account {

	protected Long IBAN;
	protected String BIC;
	protected int cvv2;
	protected String owner;
	protected String country;
	protected double balance;
	protected String currency;
	public Account(Long iBAN, String bIC,int cvv2, String owner, String country, double balance,String currency) {
		super();
		this.IBAN = iBAN;
		this.BIC = bIC;
		this.cvv2=cvv2;
		this.owner = owner;
		this.country = country;
		this.balance = balance;
		this.currency=currency;
		
	}
	public Long getIBAN() {
		return IBAN;
	}
	public void setIBAN(Long iBAN) {
		IBAN = iBAN;
	}
	public String getBIC() {
		return BIC;
	}
	public void setBIC(String bIC) {
		BIC = bIC;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int getCvv2() {
		return cvv2;
	}
	public void setCvv2(int cvv2) {
		this.cvv2 = cvv2;
	}
	
}
