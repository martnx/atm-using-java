import java.util.ArrayList;

public class Account {
	
	//The name of the account
	private String name;
	
	//The account ID number.
	private String uuid;
	
	//The user object that owns this account.
	private User holder;
	
	//The list of transactions for this account.
	private ArrayList<Transaction> transaction;
	
	/**
	 * Create a new Account
	 * @param name		the name of the account
	 * @param holder	the User object holds this account
	 * @param theBank	the bank that issues the account
	 * **/
	public Account(String name, User holder, Bank theBank) {
		
		// set the account name and holder
		this.name = name;
		this.holder = holder;
		
		// get new account UUID
		this.uuid = theBank.getNewAccountUUID();
		
		// init transactions
		this.transaction = new ArrayList<Transaction>();
		

		
	}
	/**
	 * Get the account ID
	 * @return the UUID
	 * */
	public String getUUID() {
		return this.uuid;
	}

}
