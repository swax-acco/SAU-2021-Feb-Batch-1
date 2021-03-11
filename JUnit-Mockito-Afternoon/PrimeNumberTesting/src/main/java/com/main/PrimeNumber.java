package com.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrimeNumber {
	static Logger log = LogManager.getLogger(PrimeNumber.class);
	CheckPrimeService service;
	
	//For Mockito 
	public PrimeNumber(CheckPrimeService service)
    {
        this.service = service;
    }
	
	//For Mockito 
	public boolean getPrimeStatusByNumber(int n) {
		boolean val = service.getPrimeStatus(n);
		return val;
	}
	
	//For JUnit Testing
	static boolean checkPrime(int n) {
		if(n == 1 || n % 2 == 0) {
			return false; 
		}
		
		for(int i = 3; i <= Math.sqrt(n); i += 2) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		for(int i = 1; i <= 100; i++) {
			//For Logging
			log.debug(i +  " is " + (checkPrime(i) ? " ": "not ") + "a prime number" );
			try {
				if(checkPrime(i)) {
					throw new PrimeNumberException("Prime Number: " + i );
				}
			}catch(PrimeNumberException e){
				System.out.println(e);
			}
		}
	} 
}
