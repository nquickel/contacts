package contacts;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        String name;
        String surname;
        String phoneNumber;

        String action;
        boolean run = true;

        System.out.println("Enter action (add, remove, edit, count, list, exit):");
        do {
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
                case "list":
                    phoneBook.listContacts();
                    break;
                case "exit":
                    run = false;
                    break;
                default:
                    break;
            }
        } while (run);
    }
}
