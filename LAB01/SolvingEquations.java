package LAB01;
import javax.swing.JOptionPane;

public class SolvingEquations {
    public static void main(String[] args) {
        String[] options = {"Phương trình bậc nhất 1 ẩn", "Hệ phương trình bậc nhất 2 ẩn", "Phương trình bậc hai 1 ẩn"};
        int choice = JOptionPane.showOptionDialog(null, "Chọn loại phương trình muốn giải:", 
                "Giải phương trình", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            solveLinearEquation();
        } else if (choice == 1) {
            solveLinearSystem();
        } else if (choice == 2) {
            solveQuadraticEquation();
        }
        System.exit(0);
    }

    private static void solveLinearEquation() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Nhập hệ số a (a != 0):"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Nhập hệ số b:"));

        if (a == 0) {
            if (b == 0) {
                JOptionPane.showMessageDialog(null, "Phương trình có vô số nghiệm.");
            } else {
                JOptionPane.showMessageDialog(null, "Phương trình vô nghiệm.");
            }
        } else {
            double x = -b / a;
            JOptionPane.showMessageDialog(null, "Nghiệm của phương trình là: x = " + x);
        }
    }

    private static void solveLinearSystem() {
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a11:"));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a12:"));
        double b1  = Double.parseDouble(JOptionPane.showInputDialog("Nhập b1:"));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a21:"));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a22:"));
        double b2  = Double.parseDouble(JOptionPane.showInputDialog("Nhập b2:"));

        double D  = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            double x1 = D1 / D;
            double x2 = D2 / D;
            JOptionPane.showMessageDialog(null, "Hệ có nghiệm duy nhất: x1 = " + x1 + ", x2 = " + x2);
        } else {
            if (D1 == 0 && D2 == 0) {
                JOptionPane.showMessageDialog(null, "Hệ có vô số nghiệm.");
            } else {
                JOptionPane.showMessageDialog(null, "Hệ vô nghiệm.");
            }
        }
    }

    private static void solveQuadraticEquation() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Nhập a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Nhập b:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Nhập c:"));

        if (a == 0) {
            if (b == 0) {
                JOptionPane.showMessageDialog(null, c == 0 ? "Vô số nghiệm" : "Vô nghiệm");
            } else {
                JOptionPane.showMessageDialog(null, "Nghiệm x = " + (-c / b));
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                JOptionPane.showMessageDialog(null, "Phương trình có 2 nghiệm phân biệt:\nx1 = " + x1 + "\nx2 = " + x2);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                JOptionPane.showMessageDialog(null, "Phương trình có nghiệm kép: x = " + x);
            } else {
                JOptionPane.showMessageDialog(null, "Phương trình vô nghiệm thực.");
            }
        }
    }
}