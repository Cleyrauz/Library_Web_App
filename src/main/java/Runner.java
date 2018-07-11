import db.DBHelper;
import models.Book;
import models.Borrower;
import models.Library;

public class Runner {

    public static void main(String[] args) {

        Library library = new Library("Public library");
        DBHelper.save(library);

        Book book1 = new Book("1984", "George Orwell", true, library);
        Book book2 = new Book("100 anios de Soledad", "Gabriel Garcia", false, library);
        Book book3 = new Book("Wonder", "J. Palacios", true, library);
        DBHelper.save(book1);
        DBHelper.save(book2);
        DBHelper.save(book3);

        Borrower borrower1 = new Borrower("Cleyra Uzcategui", library);
        DBHelper.save(borrower1);
        Borrower borrower2 = new Borrower("Jose Manuel Uzcategui", library);
        DBHelper.save(borrower2);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBorrower(borrower1);
        library.addBorrower(borrower2);

        book1.setCurrentBorrower(borrower1);
        book3.setCurrentBorrower(borrower2);
    }
}
