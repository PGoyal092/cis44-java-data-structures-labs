import java.util.Objects;
import java.util.Scanner;

public class Calculator {
    public static Double calculate(Double num1, Double num2, String operator){
        Double output=0.0;
        if (Objects.equals(operator, "+")) {
            output = num1 + num2;
        }
        if (Objects.equals(operator, "-")) {
            output = num1 - num2;
        }
        if (Objects.equals(operator, "/")) {
            output = num1 / num2;
        }
        if (Objects.equals(operator, "*")) {
            output = num1 * num2;
        }
        return output;
    }
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        Character choice = 'Y';
        do {
            System.out.println("Enter input: ");
            Double num1 = myObj.nextDouble();
            myObj.nextLine();
            System.out.println("Enter operator: ");
            String operator = myObj.nextLine().trim();
            System.out.println("Enter input: ");
            Double num2 = myObj.nextDouble();
            Double output = calculate(num1, num2, operator);

            System.out.println("Result: "+output);
            System.out.println("Do you want to continue (Y/N): ");
            choice = myObj.next().charAt(0);
        } while(choice=='Y');
    }
}