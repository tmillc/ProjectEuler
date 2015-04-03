/*
  A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
    a^2 + b^2 = c^2.
    
    There is exactly one Pyth triplet for which a+b+c = 1000. Find product abc.
 */

// TODO: As a recursion, we are checking numbers > 1000 so doing more branching than we need to
// We stop the loop if the sum > 1000 but still do the transformations

import java.util.Arrays;

public class problem09 {
    public static void main(String[] args) {
        int[] triple = { 3, 4, 5 };
        boolean foundIt = false;
        
        checkTriple(triple);
        System.out.println("Didn't find anything, trying t1...");
        checkTriple(transform1(triple));
        System.out.println("Didn't find anything, trying t2...");
        checkTriple(transform2(triple));
        System.out.println("Didn't find anything, trying t3...");
        checkTriple(transform3(triple));
    }
    
    public static int[] transform1(int[] triple) {
        int[] newtriple = { 
            triple[0] - 2*triple[1] + 2*triple[2],
            2*triple[0] - triple[1] + 2*triple[2],
            2*triple[0] - 2*triple[1] + 3*triple[2]
        };
        
        return newtriple;
    }
    
    public static int[] transform2(int[] triple) {
        int[] newtriple = {
            triple[0] + 2*triple[1] + 2*triple[2],
            2*triple[0] + triple[1] + 2*triple[2],
            2*triple[0] + 2*triple[1] + 3*triple[2]
        };

        return newtriple;
    }
    
     public static int[] transform3(int[] triple) {
        int[] newtriple = { 
            -triple[0] + 2*triple[1] + 2*triple[2], 
            -2*triple[0] + triple[1] + 2*triple[2],
            -2*triple[0] + 2*triple[1] + 3*triple[2]
        };

        return newtriple;
    }
    
     public static boolean doesTripleSumTo1000(int[] triple) {
         int sum = triple[0]+triple[1]+triple[2];
         if (sum == 1000) {
             System.out.println(triple[0]*triple[1]*triple[2]); // if it sums to 1000, we want the product
             
             // let's throw in which triple did it, too
             System.out.println(Arrays.toString(triple));
             return true;
         }
         else {
             return false;
         }
     }
     
    public static boolean checkTriple(int[] triple) {
        boolean found = false;
        int[] newtriple = Arrays.copyOf(triple, triple.length);
        int coef = 1;
        //System.out.println("Incoming triple is: " + Arrays.toString(triple));
        
        while (newtriple[0]+newtriple[1]+newtriple[2] <= 1000) {
            if (newtriple[0] + newtriple[1] + newtriple[2] == 1000) {
                found = true;
                //System.out.println(Arrays.toString(newtriple));
                coef++;
            }
            else {
                //System.out.println("The coefficient is currently: " + coef);
                
                newtriple[0] = triple[0]*coef;
                newtriple[1] = triple[1]*coef;
                newtriple[2] = triple[2]*coef;
                
                //System.out.println("and the new triple is: " + Arrays.toString(newtriple));
               // System.out.println(Arrays.toString(triple) + " should STILL be (3,4,5).");
                coef++;
            }
        }/*
        if (found == false) {
            newtriple = transform1(triple);
            found = checkTriple(newtriple);
            System.out.println("Here we are, in transform1");
        }
        
        if (found == false) {
            newtriple = transform2(triple);
            found = checkTriple(newtriple);
        }
        
        if (found == false) {
            newtriple = transform3(triple);
            found = checkTriple(newtriple);
        }*/
        
        return found;
    }
}
