package assg4_Gellers16;
//Shannen geller

public class CheckingAccount extends Account {
	
	private double overdraft;
	private static double overFee;
	
	/*
	 * receieves a string parameter and sets that as the acctNo
	 * sets inital balance to 0 
	 * sets inital overdraft fee to 0
	 */
	
	public CheckingAccount(String number) {
		super(number);
		this.overdraft = 0.0;
		
	}
	
	/*
	 * recieves 3 parameters
	 * sets all parameters to coordinationg variables
	 * 
	 */
	
	public CheckingAccount(String acct, double bal, double over) {
		
		// tried to do an if statement to check if the bal > 0 but super must be called before anything else
		// passing acctNo and balance to the super Accont class
		super(acct, bal);
	
		this.overdraft = over;
	}
	/*
	 * getting overdraft amountt
	 * @return overdraft amt
	 */
	public double getOverdraft() {
		
		return overdraft;
	}
	
	/*
	 * setting overdraft amount 
	 * @param overDraft
	 * @return amount of overdraft
	 */
	public double setOverdraftFee(double overD){
		
		overdraft = overD;
		return overdraft;
		
	}
	
	/*
	 * getting overdraft fee
	 * @return overDraft fee
	 */
	public static double getFee() {
		return overFee;
		
	}
	
	/*
	 * setting fee 
	 * @param fee
	 * setting fee equal to overFee
	 */
	public static void setFee(double fee) {
		overFee = fee;
		
	}
	/*
	 * @return String with overdraft amount added to super class toString() method
	 */
	@Override
	public String toString() {
		return super.toString() + "\nOverdraft amount: " + overdraft;
	}
	/*
	 * @param amount
	 * withdrawling amount from an account, and has checking methods to make sure there is enough in the account
	 * also checking the amount is greater than 0.
	 */
	@Override
	public boolean withdraw(double amt) {
		//check to make sure amt is greater than 0
		if(amt > 0) {
			// checking to see if account is greater then the amount trying to be withdrawn
			if(getBalance() >= amt) {
				return super.withdraw(amt);
			}
			// getting balance then withdrawing amount + fee 
			// returning newBalance after calculations
			else if(getBalance() + this.overdraft - overFee - amt >= 0){
				double newBal = getBalance() - (amt + overFee);
				setBalance(newBal);
				return true;
			}
			// not enough money, returns false, nothing saved
			else {
				System.out.println("Not enough in account to withdraw " + amt);
				return false;
			}
		}
		//everything else just send to false
		else {
			return false;
		}
	}
	/*
	 * displaying checking account info
	 */
	@Override
	public void displayInfo() {
		System.out.println(this.toString());
	}
	/*
	 * @param account
	 * @param amtTrans
	 * transferring from one account to the other
	 */
	@Override
	public void transfer(Account acct, double amtTrans) {
		// if amount is greater than 0, withdraw from ths account then deposit to other!
		if(amtTrans > 0) {
			if(this.withdraw(amtTrans)) {
				acct.deposit(amtTrans);
			}
		}
	}
	// searching method
	// for statement to go through each account
	// if statement to check to see if acctNo matches any of the acctNo's in the array
	// returns print statements with all that information, then the index of where it was
	
	public static int checkingAccountSearch(CheckingAccount[] checkingAccountArray, int checkCount, String acctNo) throws AccountNotFoundException {
		for(int i = 0; i < checkCount; i++) {
			if (acctNo.equals(checkingAccountArray[i].getAcctNo())) {
				System.out.println("Account Number: " + checkingAccountArray[i].getAcctNo());
				System.out.println("Current Balance: $" + checkingAccountArray[i].getBalance());
				System.out.println("OverDraft Amount: $" + checkingAccountArray[i].getOverdraft());
				
				return i;
			}
			
			// throwing exception if account not found :)
			else {
				throw new AccountNotFoundException();
			}
		}
		throw new AccountNotFoundException("Account number not found!" + acctNo);
	}
}
