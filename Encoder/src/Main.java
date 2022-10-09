import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        Encoder myEncoder = new Encoder();
        while(true) {
            System.out.println("Enter String to be encoded: ");
            String plainString = sc.nextLine();
            plainString = plainString.strip();
            String encodedText = myEncoder.encode(plainString);
            System.out.println(encodedText);
            System.out.println("Decoded of Encoded string is: ");
            String decodedText = myEncoder.decode(encodedText);
            System.out.println(decodedText);
        }

    }
}
