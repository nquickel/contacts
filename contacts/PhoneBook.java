package contacts;
import java.util.List;
import java.util.ArrayList;

public class PhoneBook {
    List<Contact> contacts;

    public PhoneBook(Contact contact) {
        contacts = new ArrayList<>();
        contacts.add(contact);
        System.out.println("A Phone Book with a single record created!");
    }

    public PhoneBook(String name, String surname, String phoneNumber) {
        contacts = new ArrayList<>();
        addContact(name, surname, phoneNumber);
        System.out.println("A Phone Book with a single record created!");
    }

    public void addContact(String name, String surName, String phoneNumber) {
        contacts.add(new Contact(name, surName, phoneNumber));
        System.out.println("A record created!");
    }
}