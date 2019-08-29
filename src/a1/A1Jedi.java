package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		// Record number of items in store.
		int count = scan.nextInt();

		// Create two arrays to store names and count
		String[] productNames = new String[count];
		int[] productCount = new int[count];
		int[] customerCount = new int[count];

		// Store names and consume prices
		for (int i = 0; i < count; i++) {
			productNames[i] = scan.next();
			scan.nextDouble();
		}

		// Store number of customers
		int numCustomers = scan.nextInt();

		// Loop through the number of customers
		for (int i = 0; i < numCustomers; i++) {

			// consume full name
			scan.next();
			scan.next();

			// Record number of items purchased
			int numItemsPurchased = scan.nextInt();
			
			//Temp array
			String[] notPurchasedBefore = productNames.clone();

			// Initiate a loop to store information for each item purchased
			for (int j = 0; j < numItemsPurchased; j++) {
				// Define variables
				int qtyPurchased;
				String itemName;

				// Store quantity purchased
				qtyPurchased = scan.nextInt();

				// Store product name
				itemName = scan.next();

				// Use helper function to obtain index number.
				int itemIndex = getItemIndex(productNames, itemName);

				// Use second helper function to increase item count
				productCount[itemIndex] += qtyPurchased;

				// Increment number of customers
				// purchasing given item only once per customer.
				if (isUnique(notPurchasedBefore, itemName)) {
					customerCount[itemIndex] += 1;
				}

			}
		}
		scan.close();

		// Print and display information
		displayOutput(customerCount, productNames, productCount);

	}

	/*
	 * updateCount takes in an array of names (String) and an array of counts (int),
	 * a String and and a quantity. It increases the quantity of the String by the
	 * quantity given.
	 * 
	 * input: an array of String values, an array of Double values, A String and a
	 * an integer.
	 * 
	 * output: None. Void function. A double value.
	 * 
	 * Precondition: Both arrays must not be null and must contain one value. The
	 * input String must be within the String array.
	 */
	static int getItemIndex(String[] productList, String productName) {

		int index = -1;

		// Locate the index number for the product given.
		for (int i = 0; i < productList.length; i++) {
			if (productName.equals(productList[i])) {
				index = i;
			}
		}
		return index;
	}
	
	/*
	 * isUnique takes in an array of Strings and a String. It searches for the String in the array, if it is
	 * not there, it adds it and returns true.
	 * 
	 * input: String array with items previously purchased by the customer.
	 * item purchased by customer.
	 * 
	 * output: true if the item hasn't been purchased before by this client.
	 * false if the item has been previously purchased by client.
	 */
	 static boolean isUnique(String[] previouslyPurchased, String newItem) {
		 for (int i = 0; i < previouslyPurchased.length; i++) {
			 if (previouslyPurchased[i].equals(newItem)) {
				previouslyPurchased[i] = " "; 
			 	return true;
		 }
			}
		 return false;
	 } 

	/*
	 * displayOutput takes in an array of product names and an array of counters and
	 * prints
	 */
	static void displayOutput(int[] customerCounter, String[] itemList, int[] count) {
		for (int i = 0; i < itemList.length; i++) {
			if (count[i] == 0) {
				System.out.println("No customers bought " + itemList[i]);
			} else {
				System.out.println(customerCounter[i] + " customers bought " + count[i] + " " + itemList[i]);
			}
		}
	}

}
