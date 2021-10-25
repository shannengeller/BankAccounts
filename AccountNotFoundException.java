package assg4_Gellers16;
//shannen Geller

import java.util.*;
import java.io.*;

public class AccountNotFoundException extends Throwable{
	
	
	public AccountNotFoundException() {
		super("Account not found!");
	}

	public AccountNotFoundException(String acctNo) {
		super(acctNo);
		
	}

}
