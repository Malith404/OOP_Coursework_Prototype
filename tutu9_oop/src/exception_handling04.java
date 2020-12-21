import java.util.InputMismatchException;
import java.util.Scanner;

public class exception_handling04 {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);

            int value = 0;
            System.out.println("Please enter an integer");
            value = input.nextInt();

            System.out.println("Value: " + value);

        } catch (InputMismatchException inputMismatchException) {
            System.out.println("ENTER a Integer Value...You have entered a string value");
        }
    }
}
