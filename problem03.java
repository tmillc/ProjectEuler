/* 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */

public class problem03 {
	public static void main(String args[]) {
		int test = 300;
		long num = 600851475143L;  // L designates it as a long
		int root = (int)Math.floor(Math.sqrt(num)); // casting
		
		// System.out.println(root);
		
		for (long i = 1; i < num/2; i++) {
			if (num%i == 0) {// if it's a factor of num
				System.out.print(i + " is a factor of " + num + ". ");
				if (isPrime(i) == true) {// if it's prime
					System.out.println("And it's prime!");
				}
			}
		} 
	}
	
	public static boolean isPrime(long num) {
		boolean prime = true;
		int numroot =(int)Math.floor(Math.sqrt(num));
		System.out.println("Testing " + num +" for primeness up to sqrt(" + num + ")");
		for (int j=2; j<numroot; j++) {
			if (num%j == 0) {
				prime = false;
				//System.out.println(num + " isn't prime");
			}
		}
		return prime;
	}
	
}
