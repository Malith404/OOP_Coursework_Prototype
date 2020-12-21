import javax.swing.*;

public class exception_handling03 {
    public static void main(String[] args) {

        ImageIcon imageIconOne;

        try {
            imageIconOne = new ImageIcon(exception_handling03.class.getResource("one.png"));
        } catch (NullPointerException e) {
            System.out.println("Image one not found");
        }
    }
}
