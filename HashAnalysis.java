package assign09;

import java.util.Random;

/**
 * Analyzes the number of collisions incurred while doing operations 
 * on a hash table of strings for several different hash functions.  
 * Linear probing is used to resolve collisions.
 * 
 * @author Erin Parker
 * @version October 26, 2020
 */
//public class HashAnalysis {
//
//	public static void main(String[] args) {
//		
//		// perform the experiment by running 100 times
//		final int NUM_RUNS = 100;
//
//		// generate random strings
//		Random rng = new Random();
//		String[] randStrings = new String[NUM_RUNS];
//		
//		for(int k = 0; k < randStrings.length; k++) 
//			randStrings[k] = generateRandString(rng);
		
		// for every hash function choice: BAD, BETTER, BEST, JAVA ...
//		for(HashTable.HashOption choice : HashTable.HashOption.values()) {
//
//			// create and populate the hash table
//			HashTable strTable = new HashTable(200);
//			strTable.setHashFunction(choice);
//			for(String s : randStrings)
//				strTable.add(s);
//			
//			System.out.println("Results for " + choice.name() + 
//					" hash function (hash table capacity = " + 
//					strTable.capacity() + ")");
//
//			// successful hash table searches
//			strTable.resetCollisions();
//			for(int i = 0; i < randStrings.length; i++)
//				strTable.contains(randStrings[i]);
//
//			System.out.println("  Collisions during " + 
//					randStrings.length + " successful searches: " + 
//					strTable.collisions() +	" (average of " + 
//					strTable.collisions() / (double) randStrings.length + 
//					" per search)");
//
//			// random and likely unsuccessful hash table searches
//			strTable.resetCollisions();
//			for(int i = 0; i < NUM_RUNS; i++) {
//				strTable.contains(generateRandString(rng));
//			}
//
//			System.out.println("  Collisions during " + randStrings.length + " random searches: " + strTable.collisions() + 
//					" (average of " + strTable.collisions() / (double) randStrings.length + " per search)\n");
//		}
//	}
//	
//	/**
//	 * Generate a random string of 1 to 5 lower-case letters.
//	 * 
//	 * @param rng - a random number generator
//	 * @return a random string
//	 */
//	private static String generateRandString(Random rng) {
//		// length range: 1 to 5
//		char[] arr = new char[rng.nextInt(5) + 1];  
//		
//		for(int i = 0; i < arr.length; i++)
//			// letter range: 'a' to 'z'
//			arr[i] = (char)((int)'a' + rng.nextInt(26));  
//		
//		return new String(arr);
//	}
//}