****************************************************************************
Eiffel Corp Java RMI and WebService Project:
*****************************************************************************
The repo contains 6 projects
* First part  (RMI) :

	1- EiffelCorp : Java RMI project that manages Employees and Customers. 

	2- IfShare : Java RMI project that manages Products .

	3- EiffelCorpScenario : A Java project that  calls the RMI objects and populates them with data to be used for the webservice.


* Second part  (WebService) :

	1- BankService: A webservice that checks if a certain user has enough funds to buy products during checkout.
	
	2- IfService : a webservice that offers for sale products that have been sold at least once within Eiffel Corp. The webservice allows users to view product prices, check availability, add products to a shopping cart and purchase them.
	
	3-IfClient : a dynamic web application that offers a graphical interface for the IfService customer, allowing him to build a cart, validate it and pay.
*****************************************************************************


**Steps**: 
    1- Download/clone the repo
    2- run EiffelCorp 
    3- run Ifshare
    4- run EiffelCorpScenario
    5-run IfClient on the server.
    
**First URL:**  - http://localhost:8080/IfClient/productsList

