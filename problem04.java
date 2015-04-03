/* 	
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
	Find the largest palindrome made from the product of two 3-digit numbers.
	
*/

public class Prob4 {
	public static void main(String args[]) {
		long startTime = System.currentTimeMillis(); // For analyzing execution time
		int palindrome = 999999;
		
		while (isProductOfThree(palindrome) == false) { // test the current palindrome
		System.out.println("Oh too bad, " + palindrome + " is not a product of two 3-digit numbers."); // oops, it failed. Next!
			palindrome = nextPalindrome(palindrome);		// decrement to the next palindrome using our nextPalindrome() method
		}
		System.out.println(palindrome + " is a palindrome and a product of two 3-digit numbers! Hip hip hooray!"); // Success!
		
		// Displaying our execution time	
		long elapsedTimeMillis = System.currentTimeMillis() - startTime;
		System.out.println("\n\nProgram execution time: " + elapsedTimeMillis);
	}
	
	public static int nextPalindrome(int num) {
		num = num - 1000;   // 999999 becomes 998999
		
		char[] numArray = String.valueOf(num).toCharArray(); // convoluted way to turn our int into a char array
		
		numArray[5] = numArray[0];
		numArray[4] = numArray[1];
		numArray[3] = numArray[2];
		
		num = Integer.parseInt(String.valueOf(numArray)); // turns our char array back into an int
		// System.out.println("The next palindrome is: " + num);
		return num;
	}
	
	public static boolean isProductOfThree(int num) { // tests whether the input int is a product of two 3-digit numbers
		boolean foundOne = false; 		// assume false until we find out it's true, or run out of possibilities
		// System.out.println("Testing " + num + " to see if it's the product of two 3-digit numbers.");
			for (int i = 101; i <= 999; i++) {
				// System.out.println("Is " + i + " a factor of " + num + "?");
				if (num%i == 0 && (num/i)/100 < 10) { // if wefound a 3-digit factor, AND the other factor is also three digits
					// System.out.println(num + " = " + i + "x" + (num/i) + ".");
					foundOne = true;
				}
			}
		return foundOne;
	}
}
