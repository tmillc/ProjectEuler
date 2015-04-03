/*
 * 
 * Display the n'th prime.
 *
 */


import java.util.Scanner; // for user input

public class Problem7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfPrimes;  // how many primes we would like
        int currentPrime = 2; // starting with 2
        int counter = 0;  // ordinality of the prime, starting with 0th (first)
        
        System.out.print("Which prime would you like to find? ");
        numberOfPrimes = input.nextInt();
        int[] primeArray = new int[numberOfPrimes]; // an array of ints, size being how many they would like
       
        while (counter < numberOfPrimes) {  // loop ends when we've reached how many primes we want
            if (isPrime(currentPrime, primeArray, counter) == true) {
                System.out.println(currentPrime + " is prime.");
                primeArray[counter] = currentPrime; // set our n'th array spot with the prime we've found
                counter++; // now we will find the n+1'th primeu
            }
            currentPrime++;
        }
    }
    
    // considers our candidate for primeness by testing if it's divisible by previous primes
    public static boolean isPrime(int primeCandidate, int[] primeArray, int counter) {
        boolean primeness = true;
        
            for (int i = 0; i < counter; i++) { // test if candidate is a multiple of previous primes
                if (primeCandidate % primeArray[i] == 0) {
                    primeness = false;    // if it's a multiple of any previous primes, it's not prime
                    i=counter; // cuts our time in half by leaving the loop after candidate is found to be composite
                }
            }     
        return primeness;   // otherwise it is prime
    }
    
}
