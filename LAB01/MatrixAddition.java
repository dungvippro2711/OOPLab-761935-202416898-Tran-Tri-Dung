package LAB01;
import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = keyboard.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = keyboard.nextInt();

        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];
        int[][] sumMatrix = new int[rows][cols];

        System.out.println("Enter elements of the first matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix1[i][j] = keyboard.nextInt();
            }
        }

        System.out.println("Enter elements of the second matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix2[i][j] = keyboard.nextInt();
            }
        }

        System.out.println("Sum of the matrices:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
                System.out.print(sumMatrix[i][j] + "\t");
            }
            System.out.println();
        }

        keyboard.close();
    }
}