package webService;
import service.bankService;
public class BankWebServiceImpl {
	
	bankService bankService;
public BankWebServiceImpl() {
		
			bankService=service.bankService.GetInstance();
			bankService.addAccount((long)1234, "REVOLUT", 123, "anis", "France", 1000, "EUR");
		
	}
	

	public boolean performPurchace(Long IBAN,int cvv2,double price) {
	
		return bankService.performPurchace(IBAN, cvv2, price);
		
		
	}
}
