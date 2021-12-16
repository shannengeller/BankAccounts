# BankAccounts
A program that creates checking or savings accounts, can do numerous different functions between them. 

Read a list of accounts from an input data file and store them into two arrays, one for checking 
accounts (the array element type for the array is CheckingAccount) and one for saving accounts 
(the array element type for the array is SavingsAccount).

In the input file, there is one line per account with the following format: 
account_type  acctNo  balance overdraft or interestRate  
The account_type will be C or S, C for Checking and S for Savings. Columns in the input file 
are separated by white space characters (such as space, TAB, etc.).


AccountSearchApplication.java is the program with the main method. It first read a list of 
accounts from the input file and store the data in two separate arrays, one for checking accounts, 
and one for savings account. It then asks user to enter the information for search and display the 
search results. It will also handle exceptions.  
