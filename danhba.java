import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class DanhBa {
    private List<Contact> contacts;

    public DanhBa() {
        contacts = new ArrayList<>();
    }

    public void addContact(String name, String email, List<String> phoneNumbers) {
        Contact newContact = new Contact(name, email, phoneNumbers);
        contacts.add(newContact);
    }

    public void editContact(String name, String email, String newPhoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name) && contact.getEmail().equals(email)) {
                contact.setPhoneNumbers(newPhoneNumber);
                break;
            }
        }
    }
    
    public void renameContact(String name, String email, String newName) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name) && contact.getEmail().equals(email)) {
                contact.rename(newName);
                break;
            }
        }
    }

    public List<Contact> searchByPhoneNumber(String phoneNumber) {
        List<Contact> foundContacts = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getPhoneNumbers().contains(phoneNumber)) {
                foundContacts.add(contact);
            }
        }
        return foundContacts;
    }
    
    public void sortContactsByName() {
        contacts.sort((contact1, contact2) -> contact1.getName().compareTo(contact2.getName()));
    }

    public void printContacts() {
        System.out.println("List contacts:");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public static void main(String[] args) {
        DanhBa danhBa = new DanhBa();

        List<String> johnPhoneNumbers = new ArrayList<>();
        johnPhoneNumbers.add("123456789");
        danhBa.addContact("John", "john@example.com", johnPhoneNumbers);

        List<String> janePhoneNumbers = new ArrayList<>();
        janePhoneNumbers.add("987654321");
        danhBa.addContact("Jane", "jane@example.com", janePhoneNumbers);

        List<String> adamPhoneNumbers = new ArrayList<>();
        adamPhoneNumbers.add("999888777");
        danhBa.addContact("Adam", "adam@example.com", adamPhoneNumbers);
            
        danhBa.editContact("John", "john@example.com", "123123123");
        danhBa.renameContact("Adam", "adam@example.com", "Eva");
                
        List<Contact> foundContacts = danhBa.searchByPhoneNumber("123456789");
        if (!foundContacts.isEmpty()) {
            System.out.println("Contact number 123456789:");
            System.out.println(foundContacts);
        } else {
            System.out.println("No contact with number 123456789");
        }

        danhBa.sortContactsByName();
        System.out.println("Sorted list: ");
        danhBa.printContacts();
    }
}

class Contact {
    private String name;
    private String email;
    private List<String> phoneNumbers;

    public Contact(String name, String email, List<String> phoneNumbers) {
        this.name = name;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String newPhoneNumber) {
        this.phoneNumbers.add(newPhoneNumber);
    }
    
    public void rename(String newName) {
        this.name = newName;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Email: " + email + ", Numberi: " + phoneNumbers;
    }
}
