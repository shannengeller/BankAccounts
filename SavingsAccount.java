package assg4_Gellers16;
//Shannen geller

public class SavingsAccount extends Account {
	
	private double interestRate;
	
	/*
	 * receieves a string parameter and sets that as the acctNo 
	 * @param acctNo
	 */
	public SavingsAccount(String acctNo){
		super(acctNo); // calling default class with acct param
	}
	
	/*
	 * receieves 3 parameters and sets that as the acctNo, balance and interest Rate 
	 * @param acct
	 * @param bal
	 * @param intrate
	 * calling super class to pass them
	 */
	
	public SavingsAccount(String acct, double bal, double intrate) {
		super(acct, bal);
		interestRate = intrate;
	}
	/*
	 * @return interestRate
	*/
	public double getInterestRate() {
		return interestRate;
	}
	/*
	 * setting interestRate
	 * @param intRate
	*/
	public void setInterestRate(double intRate) {
		interestRate = intRate;
		
	}
	/*
	 * setting a variable newBal equal to balance * interestRate and then calling super class to calculate the new balance
	 * and then setting balance in super class
	*/
	public void addInterest() {
		double newBal = ((1 + interestRate) * getBalance());
		super.setBalance(newBal);
	}
	/*
	 * Override class
	 * converting to a string and returning it
	 * @return String
	 */
	@Override
	public String toString() {
		
		return "Account number: " + super.getAcctNo() + "\nCurrent balance: " + super.getBalance() + "\nInterest rate: " + interestRate ;
	}
	/*
	 * displaying all the info to the screen
	 * Override method
	 */
	@Override
	public void displayInfo() {
		System.out.println(this.toString());
	}
	
	// searching method
	// for statement to go through each account
	// if statement to check to see if acctNo matches any of the acctNo's in the array
	// returns print statements with all that information, then the index of where it was
	
	public static int savingsAccountSearch(SavingsAccount[] savingsAccountArray, int savsCount, String acctNo) throws AccountNotFoundException {
		for(int i = 0; i < savsCount; i++) {
			if (acctNo.equals(savingsAccountArray[i].getAcctNo())) {
				System.out.println("Account Number: " + savingsAccountArray[i].getAcctNo());
				System.out.println("Current Balance: $" + savingsAccountArray[i].getBalance());
				System.out.println("Interest Rate: " + savingsAccountArray[i].getInterestRate());
				
				return i;
			}
			// throwing exception if not found
			else {
				throw new AccountNotFoundException();
			}
		}
		throw new AccountNotFoundException("Account number not found!" + acctNo);	
	}
}
