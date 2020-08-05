package contacts;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
    List<Contact> contacts = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public static final String RECORD_ADDED = "The record added.";
    public static final String RECORD_UPDATED = "The record updated!";
    public static final String RECORD_REMOVED = "The record removed!";

    public void addContact() {
        String type;

        System.out.print("Enter the type (person, organization): ");
        type = scanner.nextLine();

        if (type.equalsIgnoreCase("person")) {
            addPerson();
        } else if (type.equalsIgnoreCase("organization")) {
            addOrganization();
        } else {
            System.out.println("Unknown type");
        }

    }

    private void addPerson() {
        String name;
        String surname;
        String birthDate;
        String gender;
        String phoneNumber;

        System.out.print("Enter the name: ");
        name = scanner.nextLine();
        System.out.print("Enter the surname: ");
        surname = scanner.nextLine();
        System.out.print("Enter the birth date: ");
        birthDate = scanner.nextLine();
        System.out.print("Enter the gender (M, F): ");
        gender = scanner.nextLine();
        System.out.print("Enter the phone number: ");
        phoneNumber = scanner.nextLine();
        contacts.add(new Person(name, surname, birthDate, gender, phoneNumber));
        System.out.println("The record added.");
    }

    private void addOrganization() {
        String name;
        String address;
        String phoneNumber;

        System.out.print("Enter the organization name: ");
        name = scanner.nextLine();
        System.out.print("Enter the address: ");
        address = scanner.nextLine();
        System.out.print("Enter the number: ");
        phoneNumber = scanner.nextLine();
        contacts.add(new Organization(name, address, phoneNumber));
        System.out.println("The record added.");
    }

    public void countContacts() {
        System.out.println("The Phone Book has " + contacts.size() + " records.");
    }

    public void editContact() {
        int recordNum;
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
            if (contact instanceof Person) {
                Person person = (Person) contact;
                editPerson(person);
            } else {
                Organization org = (Organization) contact;
                editOrganization(org);
            }

            System.out.println("The record updated!");
        }
    }

    private void editPerson(Person person) {

        System.out.print("Select a field (name, surname, birth, gender, number): ");
        String field = scanner.nextLine();

        switch (field) {
            case "name":
                System.out.print("Enter the name: ");
                person.setName(scanner.nextLine());
                break;
            case "surname":
                System.out.print("Enter the surname: ");
                person.setSurname(scanner.nextLine());
                break;
            case "birth":
                System.out.print("Enter the birth date: ");
                person.setBirthDate(scanner.nextLine());
            case "gender":
                System.out.print("Enter the gender: ");
                person.setGender(scanner.nextLine());
                break;
            case "number":
                System.out.print("Enter number: ");
                person.setPhoneNumber(scanner.nextLine());
                break;
            default:
                System.out.println("Unknown field.");
                return;
        }
    }

    private void editOrganization(Organization org) {
        System.out.print("Select a field (name, address, number): ");
        String field = scanner.nextLine();

        switch (field) {
            case "name":
                System.out.print("Enter the name: ");
                org.setName(scanner.nextLine());
                break;
            case "address":
                System.out.print("Enter the address: ");
                org.setAddress(scanner.nextLine());
                break;
            case "number":
                System.out.print("Enter number: ");
                org.setPhoneNumber(scanner.nextLine());
                break;
            default:
                System.out.println("Unknown field.");
                return;
        }
    }

    public void removeContact() {
        int recordNum;

        if (contacts.size() == 0) {
            System.out.println("No records to remove!");
            return;
        }
        listContacts();
        System.out.print("Select a record: " );
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
            if (contact instanceof Person) {
                Person person = (Person) contact;
                System.out.printf("%d. %s %s\n", i + 1, person.getName(), person.getSurname());
            } else if (contact instanceof Organization) {
                Organization org = (Organization) contact;
                System.out.printf("%d. %s\n", i + 1, org.getName());
            }
        }
    }

    public void displayContactInfo() {
        Contact contact;
        int recordNum;

        listContacts();
        System.out.print("Select a record: " );
        recordNum = Integer.parseInt(scanner.nextLine());
        if (contactExists(recordNum)) {
            contact = contacts.get(recordNum - 1);
            if (contact instanceof Person) {
                Person person = (Person) contact;
                System.out.println(person);
            } else {
                Organization org = (Organization) contact;
                System.out.println(org);
            }
        } else {
            System.out.println("Unknown record number.");
        }
    }

    private boolean contactExists(int recordNum) {
        return (recordNum > 0 && recordNum <= contacts.size());
    }

}