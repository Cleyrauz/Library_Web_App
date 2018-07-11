package models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="libraries")
public class Library {

    private ArrayList<Book> books;
    private ArrayList<Borrower> borrowers;
    private String name;
    private int id;

    public Library(){

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
    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    @OneToMany(mappedBy = "library", fetch = FetchType.LAZY)
    public ArrayList<Borrower> getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(ArrayList<Borrower> borrowers) {
        this.borrowers = borrowers;
    }

    public void addBook(Book book){
        this.books.add(book);
    }

    public void addBorrower(Borrower borrower){
        this.borrowers.add(borrower);
    }
}
