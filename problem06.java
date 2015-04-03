/* 
	The sum of the squares of the first ten natural numbers is,
		1^2 + 2^2 + ... + 10^2 = 385
	The square of the sum of the first ten natural numbers is,
		(1 + 2 + ... + 10)^2 = 55^2 = 3025
	Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
	Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
*/

public class problem06 {
	public static void main(String args[]) {	
	double difference = squareOfSum() - sumOfSquares();
	
	System.out.println(difference);
	}
	
	public static double sumOfSquares() {
		double sum=0;
		
		for (double i=1; i<=100; i++) {
			sum += i*i;
		}
		return sum;
	}
	
	public static double squareOfSum() {
		double square=0;
		
		for (double i=1; i<=100; i++) {
			square += i;
		}
		return square*square;
	}
}
