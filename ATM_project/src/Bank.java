
import java.util.ArrayList;
import java.util.Random;

public class Bank {
	
	private String name;
	
	private ArrayList<User> users;
	
	private ArrayList<Account> accounts;
	
	/***
	 * Create a new Bank object with empty lists of users and accounts
	 * @param bank
	 */
	public Bank(String bank) {
		
		this.name = name;
		this.users = new ArrayList<User>();
		this.accounts = new ArrayList<Account>();
		
	}
	
	
	/**
	 * Generate a new universally unique ID for a user.
	 * @return the uuid
	 */
	public String getNewUserUUID() {
		
		// inits
		String uuid;
		Random rng = new Random();
		int len = 6;
		boolean nonUnique;
		
		// continuing looping until we get a unique ID
		do {
			
			//generate number
			uuid = "";
			for(int c = 0; c < len; c++) {
				uuid += ((Integer)rng.nextInt(10)).toString();
			}
			
			// check to make sure it's unique
			nonUnique = false;
			for(User u: this.users) {
				if(uuid.compareTo(u.getUUID()) == 0) {
					nonUnique = true;
					break;
				}
			}
			
		}while(nonUnique);
			
		
		return uuid;
	}
	
	/**
	 * Generate a new universally unique ID for an account
	 * @return the uuid
	 * */
	public String getNewAccountUUID() {
		// inits
		String uuid;
		Random rng = new Random();
		int len = 10;
		boolean nonUnique;
		
		// continuing looping until we get a unique ID
		do {
			
			//generate number
			uuid = "";
			for(int c = 0; c < len; c++) {
				uuid += ((Integer)rng.nextInt(10)).toString();
			}
			
			// check to make sure it's unique
			nonUnique = false;
			for(Account a: this.accounts) {
				if(uuid.compareTo(a.getUUID()) == 0) {
					nonUnique = true;
					break;
				}
			}
			
		}while(nonUnique);
			
		
		return uuid;
		
		
	}
	/**
	 * Add an account
	 * @param anAcct 	the account to add
	 * */
	public void addAccount(Account anAcct) {
		this.accounts.add(anAcct);
	}
	
	public User addUser(String firstName, String lastName, String pin) {
		
		// create an new User object	
		User newUser = new User(firstName, lastName, pin, this);
		this.users.add(newUser);
		
		// create a savings accounts for the user
		Account newAccount = new Account("Savings", newUser, this);
		newUser.addAccount(newAccount);
		this.addAccount(newAccount);
		
		return newUser;
	}
	
	/**
	 * Get the User object associated with a particular userID and pin, if they are valid
	 * @param userID	the UUID of the user to log in
	 * @param pin		the pin of the user
	 * @return			the User object, if the login is successful, or null, if it is not
	 */
	public User userLogin(String userID, String pin) {
		
		//search through list of users
		for(User u : this.users) {
			
			// check user ID is
			if(u.getUUID().compareTo(userID) == 0 && u.validatePin(pin)) {
				return u;
			}
		}
		
		// if we haven't found the user or have an incorrect pin
		return null;
		
	}
	
	/**
	 * Get the bank of the Bank
	 * @return the name of the bank
	 */
	public String getName() {
		return this.name;
	}
	

}
