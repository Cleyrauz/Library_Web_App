package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="libraries")
public class Library {

    private List<Book> books;
    private List<Borrower> borrowers;
    private String name;
    private int id;

    public Library(){

    }

    public Library(String name) {
        this.books = new ArrayList<Book>();
        this.borrowers = new ArrayList<Borrower>();
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "library", fetch = FetchType.LAZY)
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @OneToMany(mappedBy = "library", fetch = FetchType.LAZY)
    public List<Borrower> getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(List<Borrower> borrowers) {
        this.borrowers = borrowers;
    }

    public void addBook(Book book){
        this.books.add(book);
    }

    public void addBorrower(Borrower borrower){
        this.borrowers.add(borrower);
    }
}


