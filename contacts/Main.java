package contacts;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        PhoneBook phoneBook;
        String name;
        String surname;
        String phoneNumber;

        System.out.println("Enter the name of the person:");
        name = stdin.nextLine();
        System.out.println("Enter the surname of the person:");
        surname = stdin.nextLine();
        System.out.println("Enter the number:");
        phoneNumber = stdin.nextLine();

        phoneBook = new PhoneBook(name, surname, phoneNumber);
    }
}
