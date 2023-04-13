import java.util.*;
import java.math.*;

public class RecursiveQuestion {

  /**
   * Converts a string representing an integer to an integer.
   *
   * @param f the string to be converted to an integer
   * @return the integer representation of the given string
   * @throws IllegalArgumentException if the input string is not a non-negative
   *                                  integer
   */
  public static int toInt(String f) {
    if (f.length() == 1) {
      return f.charAt(0) - '0';
    } else {
      return (f.charAt(0) - '0') * (int) Math.pow(10, (f.length() - 1)) + toInt(f.substring(1));
    }
  }

  /**
   * Calculates the value of the Ackermann function for the given arguments.
   *
   * @param x the first argument
   * @param y the second argument
   * @return the value of the Ackermann function for the given arguments
   * 
   */
  public static int Ackermann(int x, int y) {
    if (x == 0) {
      return 2 * y;
    } else if (y == 0) {
      return 0;
    } else if (y == 1) {
      return 2;
    } else {
      return Ackermann(x - 1, Ackermann(x, y - 1));
    }
  }

  /**
   * 
   * Solves the Tower of Hanoi problem for the given number of disks
   * 
   * @param n     the number of disks to be moved
   * @param from  the peg from which to move the disks
   * @param spare the spare peg to use during the moves
   * @param to    the peg to which the disks should be moved
   *
   */
  public static void towerOfHanoi(int n, char from, char spare, char to) {
    if (n == 0) {
      return;
    } else {
      towerOfHanoi(n - 1, from, to, spare);
      System.out.println("Move disk " + n + " from " + from + " to " + to);
      towerOfHanoi(n - 1, spare, to, from);
    }

  }

  /**
   * 
   * Prints all permutations of the given integer array up to a certain prefix
   * length.
   * 
   * @param values  the integer array to permute
   * @param preflen the length of the prefix up to which to permute the array
   */
  public static void permutations(int[] values, int preflen) {
    if (values.length == preflen) {
      for (int i = 0; i < values.length; i++) {
        System.out.print(values[i] + " ");
      }
      System.out.println();
      return;
    } else {
      for (int f = preflen; f < values.length; f++) {
        int temp = values[preflen];
        values[preflen] = values[f];
        values[f] = temp;

        permutations(values, preflen + 1);

        temp = values[preflen];
        values[preflen] = values[f];
        values[f] = temp;
      }
    }
  }

  /**
   * 
   * Calculates the sum of the harmonic series up to the given number of terms.
   * 
   * @param n the number of terms to sum
   * @return the sum of the harmonic series up to n terms
   * @throws IllegalArgumentException if n is negative
   */
  public static double sumover(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1.0 / n;
    } else {
      return (1.0 / n) + sumover(n - 1);
    }
  }

  /**
   * 
   * Calculates the power of a given number x to the exponent n.
   * 
   * @param x the base number
   * @param n the exponent
   * @return the result of x raised to the power of n
   * @throws IllegalArgumentException if x is zero and n is less than or equal to
   *                                  zero
   */
  public static double powr(double x, int n) {
    if (x == 0 && n <= 0)
      throw new IllegalArgumentException("x is zero and n=" + n);
    if (x == 0) {
      return 0;
    }
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      return 1 / powr(x, -n);
    }
    double t = powr(x, n / 2);
    if (n % 2 == 0) {
      return t * t;
    } else {
      double result = x * t * t;
      if (x < 0 && n % 2 == 1) {
        result = -result;
      }
      return result;
    }
  }

  public static void main(String[] args) {
    System.out.println("Ackermann tests :");

    // Test case 1: x = 0, y = 5
    int result = Ackermann(0, 5);
    int expected = 10;
    System.out.println(result == expected); // Output: true

    // Test case 2: x = 1, y = 0
    result = Ackermann(1, 0);
    expected = 0;
    System.out.println(result == expected); // Output: true

    // Test case 3: x = 2, y = 1
    result = Ackermann(2, 1);
    expected = 2;
    System.out.println(result == expected); // Output: true
    // Test case 2: x = 2, y = 0
    int result2 = Ackermann(2, 0);
    int expected2 = 0;
    System.out.println(result2 == expected2); // Output: true

    // Test case 3: x = 3, y = 1
    int result3 = Ackermann(3, 1);
    int expected3 = 2;
    System.out.println(result3 == expected3); // Output: true
    // Test case 4: x = 3, y = 3
    int result4 = Ackermann(3, 3);

    System.out.println(result4); // Output: true
    System.out.println(Ackermann(4, 2));
    System.out.println("-------------------------");
    System.out.println(toInt("1222222"));
    System.out.println(toInt("311"));
    System.out.println(toInt("2023"));
    System.out.println(toInt("1984"));
    String s = "12345";
    result = toInt(s);
    expected = 12345;
    System.out.println(result == expected); // Output: true

    System.out.println("-------------------------");
    System.out.println("Test tower function with 3 disks");
    System.out.println();
    towerOfHanoi(3, 'A', 'B', 'C');
    System.out.println();
    System.out.println("Test tower function with 4 disks");
    System.out.println();
    towerOfHanoi(4, 'A', 'B', 'C');
    System.out.println("-------------------------");

    System.out.println("Test permutation  function with 1 element array:");
    int[] val0 = { 1 };
    permutations(val0, 0);
    System.out.println();

    System.out.println("Test permutation  function with 2 element array:");
    int[] val3 = { 1, 2 };
    permutations(val3, 0);
    System.out.println();

    System.out.println("Test permutation  function with 3 element array:");
    int[] val = { 1, 2, 3 };
    permutations(val, 0);
    System.out.println();

    System.out.println("Test permutation  function with 5 element array:");
    int[] val2 = { 1, 2, 3, 4, 5 };
    permutations(val2, 0);
    System.out.println();

    System.out.println("uncoment next line to see test with 10 elements");
    // int[] val4 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    int[] val4 = new int[100];
    for (int I = 0; I < 100; I++)
      val4[I] = I;

    permutations(val4, 0);
    System.out.println("-------------------------");
    System.out.println("Sum over Tests:");
    System.out.println(sumover(3));
    System.out.println(sumover(2));
    System.out.println(sumover(1));
    System.out.println(sumover(4));

    System.out.println("-------------------------");
    System.out.println("Power Tests:");
    System.out.println(powr(2, 4));
    System.out.println(powr(3, 3));
    System.out.println(powr(2, -3));

  }
}