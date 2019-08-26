package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		//Read in number of costumers
		int count = scan.nextInt();
		
		//Loop through the number of costumers
		for (int i = 0; i < count; i++)
		{
			//Define variables
			int numItemsPurchased;
			String input;
			char nameInitial;
			String lastName;
			double total = 0;
			
			//Store first name initial.
			input = scan.next();
			nameInitial = input.charAt(0);
			
			//Store last name of customer
			lastName = scan.next();
			
			//Record number of items purchased
			numItemsPurchased = scan.nextInt();
			
			//Initiate a loop to store information for each item purchased
			for (int j = 0; j < numItemsPurchased; j++)
			{
				//Define variables
				int qtyPurchased;
				String productName;
				double pricePerItem;
				
				//Store quantity purchased
				qtyPurchased = scan.nextInt();
				
				//Store product name
				productName = scan.next();
				
				//Store price per item
				pricePerItem = scan.nextDouble();
				
				//Submit information to calculate total.
				total += qtyPurchased * pricePerItem;
				
			}
			//Use helper function to display output
			displayCustomerInfo(nameInitial, lastName, total);
		}
		
		
		
	}
	
	/*displayCustomerInfo
	 * Prints first name, last name, and total spent in 
	 * F. LAST: TOTAL format.
	 * 
	 * Input: first letter of name, full last name, and total amount spent.
	 * 
	 * Output: F. LAST: TOTAL format.
	 */
	static void displayCustomerInfo(char initial, String last, double spent)
	{
		System.out.print(initial + ". ");
		System.out.print(last + ": ");
		System.out.printf("%.2f", spent);
		System.out.println("");
	}
}
