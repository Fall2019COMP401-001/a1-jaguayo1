package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		// Define variables
		String customerName;
		String minCustomer = "";
		String maxCustomer = "";
		double minValue = -1;
		double maxValue = -1;
		double grandTotal = 0;

		// Record number of items in store.
		int count = scan.nextInt();

		// Create two arrays to store names and prices
		String[] productNames = new String[count];
		double[] productPrices = new double[count];

		// Store names and prices in array
		for (int i = 0; i < count; i++) {
			productNames[i] = scan.next();
			productPrices[i] = scan.nextDouble();
		}

		// Store number of customers
		int numCustomers = scan.nextInt();

		// Loop through the number of customers
		for (int i = 0; i < numCustomers; i++) {
			// Define variables
			int numItemsPurchased;
			double customerTotal = 0;

			// Store full name
			customerName = scan.next() + " " + scan.next();

			// Record number of items purchased
			numItemsPurchased = scan.nextInt();

			// Initiate a loop to store information for each item purchased
			for (int j = 0; j < numItemsPurchased; j++) {
				// Define variables
				int qtyPurchased;
				String itemName;

				// Store quantity purchased
				qtyPurchased = scan.nextInt();

				// Store product name
				itemName = scan.next();

				// Use helper function to retrieve item price.
				double itemPrice = getPrice(productNames, productPrices, itemName);

				// A second helper functions finds total item price and adds it to running
				// customer total.
				customerTotal += calculateItemTotal(qtyPurchased, itemPrice);
			}

			// Keep track of the total amount spent in the store to find average later.
			grandTotal += customerTotal;

			// Set initial min and max value
			if (i == 0) {
				maxValue = customerTotal;
				minValue = customerTotal;
				maxCustomer = customerName;
				minCustomer = customerName;
			}

			// Determine if there is a new max value
			if (customerTotal > maxValue) {
				maxValue = customerTotal;
				maxCustomer = customerName;
			} else if (customerTotal < minValue) {
				minValue = customerTotal;
				minCustomer = customerName;
			}
		}
		scan.close();

		// Calculate average
		double average = grandTotal / numCustomers;

		// Print and display information
		//Biggest:
		System.out.print("Biggest: " + maxCustomer + " ");
		System.out.printf("%.2f", maxValue);
		System.out.print("\n");
		
		//Smallest:
		System.out.print("Smallest: " + minCustomer + " ");
		System.out.printf("%.2f", minValue);
		System.out.print("\n");

		//Average
		System.out.printf("Average: %.2f", average);
		System.out.print("\n");
	}

	/*
	 * getPrice takes in an array of names and an array of prices. It finds the
	 * price of the item by matching indexes.
	 * 
	 * input: an Array of String values, an array of Double values, A String to
	 * price search
	 * 
	 * output: The price associated with the String. A double value. Returns -1 if
	 * the item is not in the array.
	 * 
	 * Precondition: Both arrays must not be null and must contain one value
	 */
	static double getPrice(String[] productList, double[] retailPrices, String productName) {

		int index = -1;
		double price;

		// Locate the index number for the product given.
		for (int i = 0; i < productList.length; i++) {
			if (productName.equals(productList[i])) {
				index = i;
			}
		}

		// Locate the corresponding price and return it.
		price = retailPrices[index];
		return price;
	}

	/*
	 * calculateItemTotal multiplies quantity by price per and returns the total
	 * amount for the item
	 * 
	 * input: quantity purchased and price per item
	 * 
	 * output: Total charge for the item.
	 */
	static double calculateItemTotal(int qty, double price) {
		double itemTotal = qty * price;
		return itemTotal;
	}
}