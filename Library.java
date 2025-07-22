
class Book {

    protected String title;
    protected String author;
    protected int pages;
    protected boolean isAvailable;


    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.isAvailable = true; // default
    }


    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is not available.");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println(title + " has been returned.");
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);
        System.out.println("Available: " + isAvailable);
    }


    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPages() { return pages; }
    public boolean isAvailable() { return isAvailable; }
}


class Textbook extends Book {
    private String subject;
    private int edition;


    public Textbook(String title, String author, int pages, String subject, int edition) {
        super(title, author, pages); // Call parent constructor
        this.subject = subject;
        this.edition = edition;
    }


    @Override
    public void displayInfo() {
        super.displayInfo(); // call parent
        System.out.println("Subject: " + subject);
        System.out.println("Edition: " + edition);
    }


    public String getSubject() { return subject; }
    public int getEdition() { return edition; }
}


public class Library {
    public static void main(String[] args) {

        Book book1 = new Book("1984", "George Orwell", 328);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 281);

        Textbook textbook = new Textbook("Physics Fundamentals", "Resnick", 1024, "Physics", 5);
        book1.borrowBook();
        book1.borrowBook();

        book1.returnBook();
        book1.borrowBook();

        // Display info
        System.out.println("\nBook 1 Info:");
        book1.displayInfo();

        System.out.println("\nBook 2 Info:");
        book2.displayInfo();

        System.out.println("\nTextbook Info:");
        textbook.displayInfo();
    }
}
