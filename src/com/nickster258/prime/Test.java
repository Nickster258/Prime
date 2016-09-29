package com.nickster258.prime;

import java.math.BigInteger;

public class Test {
	public static void main (String[] args) {
		
		// Hey, it works.
		Prime prime = new Prime(2);
		System.out.println(prime);
		
		// Basic primes
		prime = new Prime(11);
		System.out.println(prime.getNextPrime());
		System.out.println(prime.getNextPrime(4));
		
		// Larger, arbitrary primes
		prime = new Prime(new BigInteger("1299827"));
		System.out.println(prime.getNextPrime());
		System.out.println(prime.getNextPrime(5));
		
		// This is supposed to fail
		prime = new Prime(6);
	}
}
