package lesson3.objectdemo;

public class Main {

	public static void main(String[] args) {
		//Main m = new Main();
		Customer cust = new Customer("Bob");
		cust.createNewAccount();
		cust.makeDeposit(5000);
		cust.makeWithDrawal(1250);
		String id = cust.readCheckingAccountId();
		double bal = cust.checkBalance();
		System.out.printf("%s's Account ID: %s%n%s's balance: %.2f", 
				cust.getName(), cust.readCheckingAccountId(), 
				   cust.getName(), cust.checkBalance());

	}

}
