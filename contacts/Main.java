package contacts;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();

        String action;
        boolean run = true;

        do {
            System.out.println("Enter action (add, remove, edit, count, list, exit):");
            action = scanner.nextLine();
            switch (action) {
                case "add":
                    phoneBook.addContact();
                    break;
                case "remove":
                    phoneBook.removeContact();
                    break;
                case "edit":
                    phoneBook.editContact();
                    break;
                case "count":
                    phoneBook.countContacts();
                    break;
                case "info":
                    phoneBook.displayContactInfo();
                    break;
                case "exit":
                    run = false;
                    break;
                default:
                    break;
            }
            System.out.print("\n");
        } while (run);
    }
}
