package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		// Record number of items in store.
		int count = scan.nextInt();

		// Create arrays to store item names, quantities sold,
		// number of customers purchasing item.
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
			
			// Create an array, to keep track of
			// purchase history.
			boolean[] customerBoughtBefore = new boolean[count];

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
				if (!customerBoughtBefore[itemIndex]) {
					customerCount[itemIndex] += 1;
					customerBoughtBefore[itemIndex] = true;
				}

			}
		}
		scan.close();

		// Print and display information
		displayOutput(customerCount, productNames, productCount);

	}

	/*
	 * getItemIndex takes in an array of Strings and String. It searches the array
	 * for the string and returns the index where its found.
	 * 
	 * input: an array of String values and a String.
	 * 
	 * output: The index where the String is located (int).
	 * 
	 * Precondition: Array must not be null and must contain at least one value. The
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
