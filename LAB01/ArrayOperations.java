package LAB01;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = keyboard.nextInt();
        
        int[] myArray = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            myArray[i] = keyboard.nextInt();
        }

        System.out.println("Original array: " + Arrays.toString(myArray));

        Arrays.sort(myArray);
        System.out.println("Sorted array: " + Arrays.toString(myArray));

        int sum = 0;
        for (int num : myArray) {
            sum += num;
        }

        double average = (double) sum / myArray.length;

        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);

        keyboard.close();
    }
}