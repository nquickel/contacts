package contacts;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
    List<Contact> contacts = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addContact() {
        String name;
        String surname;
        String phoneNumber;

        System.out.println("Enter the name:");
        name = scanner.nextLine();
        System.out.println("Enter the surname:");
        surname = scanner.nextLine();
        System.out.println("Enter the phone number:");
        phoneNumber = scanner.nextLine();
        contacts.add(new Contact(name, surname, phoneNumber));
        System.out.println("The record added.");
    }

    public void countContacts() {
        System.out.println("The Phone Book has " + contacts.size() + " records.");
    }

    public void editContact() {
        int recordNum;
        String field;
        Contact contact;

        if (contacts.size() == 0) {
            System.out.println("No records to edit!");
            return;
        }
        listContacts();
        System.out.print("Select a record:" );
        recordNum = Integer.parseInt(scanner.nextLine());
        if (contactExists(recordNum)) {
            contact = contacts.get(recordNum - 1);
            System.out.print("Select a field (name, surname, number): ");
            field = scanner.nextLine();

            switch (field) {
                case "name":
                    System.out.print("Enter name: ");
                    contact.setName(scanner.nextLine());
                    break;
                case "surname":
                    System.out.print("Enter surname: ");
                    contact.setSurname(scanner.nextLine());
                    break;
                case "number":
                    System.out.print("Enter number: ");
                    contact.setPhoneNumber(scanner.nextLine());
                    break;
                default:
                    System.out.println("Unknown field.");
                    return;
            }
            System.out.println("The record updated!");
        }
    }

    public void removeContact() {
        int recordNum;

        if (contacts.size() == 0) {
            System.out.println("No records to remove!");
            return;
        }
        listContacts();
        System.out.print("Select a record:" );
        recordNum = Integer.parseInt(scanner.nextLine());
        if (contactExists(recordNum)) {
            contacts.remove(recordNum - 1);
            System.out.println("The record removed!");
        } else {
            System.out.println("Unknown record number.");
        }
    }

    public void listContacts() {
        Contact contact;
        if (contacts.size() == 0) {
            System.out.println("No records to list!");
            return;
        }
        for (int i = 0; i < contacts.size(); i++) {
            contact = contacts.get(i);
            System.out.printf("%d. %s %s, %s\n", i + 1, contact.getName(), contact.getSurname(), contact.getPhoneNumber());
        }
    }

    private boolean contactExists(int recordNum) {
        return (recordNum > 0 && recordNum <= contacts.size());
    }

}