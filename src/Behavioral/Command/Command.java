package Behavioral.Command;

import java.util.ArrayList;
import java.util.List;

class Book {
    private String bookId;
    private String title;
    private boolean isAvailable = true;

    public Book(String bookId, String title) {
        this.bookId = bookId;
        this.title = title;
    }

    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
}

class LibraryUser {
    private String userId;
    private String name;
    private List<Book> borrowedBooks = new ArrayList<>();

    public LibraryUser(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public boolean hasBorrowed(Book book) {
        return borrowedBooks.contains(book);
    }

    public String getName() {
        return name;
    }
}

interface LibraryCommand {
    void execute();
}

class Library {
    public void borrowBook(LibraryUser user, Book book) {
            if (book.isAvailable()) {
            book.setAvailable(false);
            user.borrowBook(book);
            System.out.println(user.getName() + " đã mượn sách: " + book.getTitle());
        } else {
            System.out.println("Sách " + book.getTitle() + " hiện không có sẵn.");
        }
    }

    public void returnBook(LibraryUser user, Book book) {
        if (user.hasBorrowed(book)) {
            book.setAvailable(true);
            user.returnBook(book);
            System.out.println(user.getName() + " đã trả sách: " + book.getTitle());
        } else {
            System.out.println(user.getName() + " không có sách này để trả.");
        }
    }

    public void renewBook(LibraryUser user, Book book) {
        if (user.hasBorrowed(book)) {
            System.out.println(user.getName() + " đã gia hạn sách: " + book.getTitle());
        } else {
            System.out.println(user.getName() + " không có sách này để gia hạn.");
        }
    }
}

class BorrowBookCommand implements LibraryCommand {
    private Library library;
    private LibraryUser user;
    private Book book;

    public BorrowBookCommand(Library library, LibraryUser user, Book book) {
        this.library = library;
        this.user = user;
        this.book = book;
    }

    @Override
    public void execute() {
        library.borrowBook(user, book);
    }
}

class ReturnBookCommand implements LibraryCommand {
    private Library library;
    private LibraryUser user;
    private Book book;

    public ReturnBookCommand(Library library, LibraryUser user, Book book) {
        this.library = library;
        this.user = user;
        this.book = book;
    }

    @Override
    public void execute() {
        library.returnBook(user, book);
    }
}

class RenewBookCommand implements LibraryCommand {
    private Library library;
    private LibraryUser user;
    private Book book;

    public RenewBookCommand(Library library, LibraryUser user, Book book) {
        this.library = library;
        this.user = user;
        this.book = book;
    }

    @Override
    public void execute() {
        library.renewBook(user, book);
    }
}

class LibraryInvoker {
    private List<LibraryCommand> commands = new ArrayList<>();

    public void addCommand(LibraryCommand command) {
        commands.add(command);
    }

    public void executeCommands() {
        for (LibraryCommand command : commands) {
            command.execute();
        }
        commands.clear();
    }
}

public class Command {
    public static void main(String[] args) {
        Library library = new Library();
        LibraryUser user = new LibraryUser("U01", "An");
        Book book1 = new Book("B01", "Lập trình Java");
        Book book2 = new Book("B02", "Cấu trúc dữ liệu");

        LibraryInvoker invoker = new LibraryInvoker();

        invoker.addCommand(new BorrowBookCommand(library, user, book1));
        invoker.addCommand(new BorrowBookCommand(library, user, book2));
        invoker.addCommand(new RenewBookCommand(library, user, book1));
        invoker.addCommand(new ReturnBookCommand(library, user, book1));
        invoker.addCommand(new ReturnBookCommand(library, user, book2));

        invoker.executeCommands();
    }
}
