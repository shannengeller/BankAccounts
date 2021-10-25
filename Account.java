package assg4_Gellers16;
//Shannen Geller

public class Account {
	
	private String acctNo;
	private double balance;
	
	/*
	 * receieves a string parameter and sets that as the acctNo
	 * sets inital balance to 0 
	 * @param acctNo
	 */
	
	public Account(String acctNo) {
		this.acctNo = acctNo;
		this.balance = 0;
		
	}
	
	/*
	 * recieves two parameters, one string value and one double value
	 * if statement to make sure the balance isnt zero, if not negative saves value
	 * else it prints error message
	 * @param acctNo
	 * @param balance
	 */
	
	public Account(String acctNo, double balance) {
		
		this.acctNo = acctNo;
		// checking to make sure balance is greater than 0
		if( balance < 0) {
			System.out.println("Balance is negative. Cannot have a negative balance.");
			this.balance = 0;
		}
		// else leave balance as is
		else {
			this.balance = balance;
		}
	}
	/*
	 * get method for account number
	 * @return acctNo
	 */
	public String getAcctNo() {
		return acctNo;
		
	}
	/*
	 * get method for balance
	 * @return balance
	 */
	public double getBalance() {
		return balance;
	}
	/*
	 * set method for balance
	 * @param balance
	 */
	public void setBalance(double balance) {

		this.balance = balance;
	}
	
	/*
	 * @param amount
	 *  if amount is less then 0, can't deposit a negative number
	 *  if balance is greater than 0, sets balance equal to param
	 *  @return -1 - so it doesnt return anything ORRRRRRRR
	 *  @return amt
	 */
	public double deposit(double amt) {
		
		if(amt < 0) {
			System.out.println("Cannot deposit a negative amount.");
			return -1;
		}
		else {
			this.balance = this.balance + amt;
			return amt;
		}
		
	}
	/*
	 * checking to see if two accounts are equal to eachother
	 * @param object
	 * @return either true or false depending on input
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		// if statement to check to see if they are both objects aka accounts
		if(this == obj) {
			return true;
		}
		// checking to see if it actually exists
		if(obj == null) {
			return false;
		}
		// if statement to compare classes that are static
		if(getClass() != obj.getClass()) {
			return false;
		}
		Account other = (Account) obj;
		// checking to see if acctNo exists 
		if(acctNo == null) {
			// making sure other account doesnt exist either so returns false and they are not equal
			if(other.acctNo != null) {
				return false;
			}
		}
		// checking to see if both account numbers are equal to eachother and they are not so returns false
		else if(!acctNo.equals(other.acctNo)) {
			return false;
		}
		return false;
	}
	/*
	 * 
	 * converting to a string to return
	 * @return String
	 */
	@Override
	public String toString() {
		return "Account number: " + acctNo + "\nCurrent balance: " + balance;
	}
	
	/*
	 * displaying info to user
	 * 
	 */
	
	public void displayInfo() {
		System.out.println("Account Number: " + this.acctNo);
		System.out.println("Current Balance: " + this.balance + "\n ");
	}
	
	/*
	 * withdrawing amount from bank account
	 * @param value
	 * 
	 */
	public boolean withdraw(double value) {
		
		// if balance > value then balance isnt higher then the value being withdrawn
		if(balance < value) {
			System.out.println("Balance isn't higher then the value being withdrawn.");
			return false;
		}
		// if value to make sure value getting taken out is above 0, therefore it does the transaction
		if(value > 0) {
			balance = balance - value;
			return true;
		}
		//if value is < 0, doesnt do a withdrawl 
		else if(value < 0){
			System.out.println("Amount is negative.");
			return false;
		}
		return false;	
		
	}
	
	/*
	 * @param account
	 * @param amtTrans
	 * transferring from one account to another
	 */
	public void transfer(Account acct, double amtTrans) {
		// if amount is greater than 0, withdraw from ths account then deposit to other!
		if(amtTrans > 0) {
			if(this.withdraw(amtTrans)) {
				acct.deposit(amtTrans);
			}
		}
	}
	
	

}
