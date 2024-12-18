import java.util.Scanner;
public class FinalExam {
    static Scanner sc = new Scanner(System.in);
    static String[] bookTitles = new String[100];
    static String[] bookISBNs = new String[100];
    static boolean[] isAvailable = new boolean[100];
    static int numberOfBooks = 0;

    public static void initializeBooks() {
        bookTitles[numberOfBooks] = "Harry Potter";
        bookISBNs[numberOfBooks] = "978-3-16-148410-0";
        isAvailable[numberOfBooks] = true;
        numberOfBooks++;

        bookTitles[numberOfBooks] = "Lord of The Ring";
        bookISBNs[numberOfBooks] = "978-1-843-56710-2";
        isAvailable[numberOfBooks] = true;
        numberOfBooks++;

        bookTitles[numberOfBooks] = "The Alchemist";
        bookISBNs[numberOfBooks] = "978-0-06-231500-7";
        isAvailable[numberOfBooks] = true;
        numberOfBooks++;

        bookTitles[numberOfBooks] = "Sherlock Holmes";
        bookISBNs[numberOfBooks] = "978-1-566-19310-3";
        isAvailable[numberOfBooks] = true;
        numberOfBooks++;
    }

    public static void displayBooks() {
        if (numberOfBooks == 0) {
            System.out.println("There is no books yet.");
        } else {
            System.out.println("=================================== All Books ===================================");
            System.out.printf("%-6s %-25s %-25s %-15s%n", "Index","Titles", "ISBNs", "Availability");
            System.out.println("-----------------------------------------------------------------------------------");
            for (int i = 0; i < numberOfBooks; i++) {
                String availability = isAvailable[i] ? "Available" : "Borrowed";
                System.out.printf("%-6s %-25s %-25s %-15s%n", (i+1), bookTitles[i], bookISBNs[i], availability);
            }
        }
    }

    public static void borrowBooks() {
        System.out.println("======================== BORROW BOOK =======================");
        while (true) {
            System.out.print("Select the index of the book you want to borrow: ");
            int index = sc.nextInt();
            sc.nextLine();

            if (index < 1 || index > numberOfBooks) {
                System.out.println("Invalid index. Please select a valid book index.");
                continue;
            }
    
            if (isAvailable[index - 1]) {
                isAvailable[index - 1] = false;
                System.out.println("You have successfully borrowed: " + bookTitles[index - 1]);
                break;
            } else {
                System.out.println("The book '" + bookTitles[index - 1] + "' is already borrowed.");
                continue;
            }
        }

    }

    public static void returnBooks() {
        System.out.println("======================== RETURN BOOK =======================");
        while (true) {
            System.out.print("Select the index of the book you want to return: ");
            int index = sc.nextInt();
            sc.nextLine();

            if (index < 1 || index > numberOfBooks) {
                System.out.println("Invalid index. Please select a valid book index.");
                continue;
            }
    
            if (!isAvailable[index - 1]) {
                isAvailable[index - 1] = true;
                System.out.println("You have successfully returned: " + bookTitles[index - 1]);
                break;
            } else {
                System.out.println("The book '" + bookTitles[index - 1] + "' is not borrowed yet.");
                continue;
            } 
        }

    }

    public static void addBook() {
        System.out.println("======================== ADD NEW BOOK =======================");
        if (numberOfBooks >= bookTitles.length) {
            System.out.println("Cannot add more books. The library is full.");
            return;
        }

        System.out.print("Enter the title of the new book: ");
        String title = sc.nextLine();
        System.out.print("Enter the ISBN of the new book: ");
        String isbn = sc.nextLine();

        bookTitles[numberOfBooks] = title;
        bookISBNs[numberOfBooks] = isbn;
        isAvailable[numberOfBooks] = true;
        numberOfBooks++;

        System.out.println("You have successfully added the book: " + title);
    }

    public static void mainMenu(){
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Show All Books");
        System.out.println("2. Borrow Books");
        System.out.println("3. Return Books");
        System.out.println("4. Add New Book");
        System.out.println("5. Exit");
        System.out.print("Select the menu: ");
        int pilihan = sc.nextInt();
        sc.nextLine();

        switch (pilihan) {
            case 1:
                displayBooks();
                break;
            case 2:
                borrowBooks();
                break;
            case 3:
                returnBooks();
                break;
            case 4:
                addBook();
                break;
            case 5:
                System.out.println("Exit the program. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid selection. Try again.");
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Library Management System with ISBN");
        initializeBooks();
        while (true) {
            mainMenu();
        }
    }
}