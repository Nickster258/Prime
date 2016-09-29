package com.nickster258.prime;

import java.math.BigInteger;
import java.util.Arrays;

public class Prime {
	
	BigInteger prime;
	
	// Make new Prime
	public Prime () {
		this.prime = new BigInteger("2");
	}
	
	// Make new Prime with BigInteger
	public Prime (BigInteger i) throws IllegalArgumentException {
		if (Arrays.asList(Constants.PRIMES).contains(i)) {
			this.prime = i;
		} else if (isPrime(i)) {
			this.prime = i;
		} else {
			throw new IllegalArgumentException("Value isn't a prime!");
		}
	}
	
	// Make new Prime with Integer
	public Prime (int i) throws IllegalArgumentException {
		BigInteger val = BigInteger.valueOf(i);
		if (Arrays.asList(Constants.PRIMES).contains(i)) {
			this.prime = val;
		} else if (isPrime(val)) {
			this.prime = val;
		} else {
			throw new IllegalArgumentException("Value isn't a prime!");
		}
	}
	
	// toString return
	@Override
	public String toString () {
		return this.prime.toString();
	}
	
	// BigInteger return
	public BigInteger getPrime() {
		return this.prime;
	}
	
	// Fetch next prime
	public BigInteger getNextPrime() {
		if (Arrays.asList(Constants.PRIMES).contains(prime.intValue())) {
			int i = Arrays.asList(Constants.PRIMES).indexOf(prime.intValue());
			if (i<999) {
				return BigInteger.valueOf(Constants.PRIMES[i+1]);
			} else {
				return BigInteger.ZERO;
			}
		} else {
			for (BigInteger i = prime.add(Constants.ONE); ; i = i.add(Constants.ONE)) {
				if (isPrime(i)) {
					return i;
				}
			}
		}
	}
	
	//Fetch prime where n is X primes greater than set prime
	public BigInteger getNextPrime(int n) throws IllegalArgumentException {
		if (n<=0) {
			throw new IllegalArgumentException("Value can't be neither 0 nor negative!");
		} else if (Arrays.asList(Constants.PRIMES).contains(prime.intValue())) {
			int i = Arrays.asList(Constants.PRIMES).indexOf(prime.intValue());
			if (i<(999-n)) {
				return BigInteger.valueOf(Constants.PRIMES[i+n]);
			} else {
				return BigInteger.ZERO;
			}
		} else {
			int found = 0;
			for (BigInteger i = prime.add(Constants.ONE); ; i = i.add(Constants.ONE)) {
				if (isPrime(i)) {
					found+=1;
					if (found==n) {
						return i;
					}
				}
			}
		}
	}

	// Simple prime test
	public static boolean isPrime(BigInteger n) {
		if (n.equals(Constants.ONE)) {
			return false;
		} else if ((n.mod(Constants.TWO))==Constants.ZERO) {
			if (n.equals(Constants.TWO)) {
				return true;
			}
			return false;
		} else if (n.equals(Constants.THREE)) {
			return true;
		} else {
			for (BigInteger i = Constants.THREE; i.compareTo(n.divide(Constants.THREE).add(Constants.ONE)) == -1; i = i.add(Constants.TWO)){
				if (n.mod(i)==Constants.ZERO) {
					return false;
				}
			}
		}
		return true;
	}
}
