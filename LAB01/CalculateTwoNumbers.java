import javax.swing.JOptionPane;

public class CalculateTwoNumbers {
    public static void main(String[] args) {
        String strNum1, strNum2;
        String strNotification = "Results:\n";

        strNum1 = JOptionPane.showInputDialog(null, 
            "Please input the first number: ", "Input", 
            JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1); 

        strNum2 = JOptionPane.showInputDialog(null, 
            "Please input the second number: ", "Input", 
            JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2); 

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;

        strNotification += "Sum: " + sum + "\n";
        strNotification += "Difference: " + difference + "\n";
        strNotification += "Product: " + product + "\n";

        if (num2 != 0) {
            double quotient = num1 / num2;
            strNotification += "Quotient: " + quotient;
        } else {
            strNotification += "Quotient: Cannot divide by zero!";
        }

        JOptionPane.showMessageDialog(null, strNotification, 
            "Calculation Results", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0); 
    }
}