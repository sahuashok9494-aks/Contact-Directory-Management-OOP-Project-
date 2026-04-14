import java.util.Scanner;

class Contact {
    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}

class Directory {
    private Contact[] contacts;
    private int count;

    public Directory(int size) {
        contacts = new Contact[size];
        count = 0;
    }

    public void addContact(String name, String phone) {
        if (count == contacts.length) {
            System.out.println("Directory is full!");
            return;
        }
        contacts[count++] = new Contact(name, phone);
        System.out.println("✅ Contact added successfully");
    }

    public void searchContact(String name) {
        for (int i = 0; i < count; i++) {
            if (contacts[i].getName().equalsIgnoreCase(name)) {
                System.out.println("📞 Name: " + contacts[i].getName());
                System.out.println("📱 Phone: " + contacts[i].getPhone());
                return;
            }
        }
        System.out.println("❌ Contact not found");
    }

    public void deleteContact(String name) {
        for (int i = 0; i < count; i++) {
            if (contacts[i].getName().equalsIgnoreCase(name)) {

                // shift elements
                for (int j = i; j < count - 1; j++) {
                    contacts[j] = contacts[j + 1];
                }

                contacts[count - 1] = null;
                count--;

                System.out.println("🗑 Contact deleted successfully");
                return;
            }
        }
        System.out.println("❌ Contact not found");
    }

    public void displayAll() {
        if (count == 0) {
            System.out.println("⚠ No contacts available");
            return;
        }

        System.out.println("\n📒 Contact List:");
        for (int i = 0; i < count; i++) {
            System.out.println("Name: " + contacts[i].getName());
            System.out.println("Phone: " + contacts[i].getPhone());
            System.out.println("-------------------");
        }
    }
}

public class project {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum number of contacts: ");
        int size = sc.nextInt();
        sc.nextLine(); // clear buffer

        Directory directory = new Directory(size);

        int choice;

        do {
            System.out.println("\n===== CONTACT DIRECTORY =====");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    directory.addContact(name, phone);
                    break;

                case 2:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();
                    directory.searchContact(searchName);
                    break;

                case 3:
                    System.out.print("Enter name to delete: ");
                    String deleteName = sc.nextLine();
                    directory.deleteContact(deleteName);
                    break;

                case 4:
                    directory.displayAll();
                    break;

                case 5:
                    System.out.println("👋 Exiting program...");
                    break;

                default:
                    System.out.println("⚠ Invalid choice");
            }

        } while (choice != 5);

        sc.close();
    }
}