package service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import entity.Account;

public class bankService {
	List<Account> accounts ; 
	private bankService() 
    {
		
		accounts = new CopyOnWriteArrayList<Account>();
		
    }
     
    private static bankService instance=null; 
    
    public static bankService GetInstance() 
    { 
        if (instance == null) 
        { 
        	instance = new bankService(); 
        } 
        return instance; 
    }
    
    public boolean addAccount(Long IBAN, String BIC, int cvv2,String owner, String country, double balance,String currency) {
    	
    	return accounts.add(new Account(IBAN,BIC,cvv2,owner,country,balance,currency));
    }
    public Account getByIBAN(Long iban) {
    	for (Account a:accounts) {
    		if (a.getIBAN().equals(iban)) {
    			return a;
    		}
    	}
    	return null;
    }
    public boolean removeAccount(Long IBAN) {
    	return accounts.remove(this.getByIBAN(IBAN));
    }
    
    public boolean performPurchace(Long IBAN,int cvv2,double price) {
    	Account a=this.getByIBAN(IBAN);
    	
    	if (a!=null) {
    	
    		if (price>a.getBalance()) {return false;}
        	else {
        		if (a.getCvv2()==cvv2) {a.setBalance(a.getBalance()-price);
        		return true;}
        		return false;
        		
        	}
    		
    	}
    	else return false;
    	
    	
    }
}
