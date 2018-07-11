package models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="books")
public class Book {

    private int id;
    private String title;
    private String author;
    private boolean onLoan;
    private ArrayList<Borrower> currentBorrower;
    private Library library;

    public Book(){

    }

    public Book(String title, String author, boolean onLoan, Library libray) {
        this.title = title;
        this.author = author;
        this.onLoan = onLoan;
        this.currentBorrower = new ArrayList<>();
        this.library = library;
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

    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name="onLoan")
    public boolean isOnLoan() {
        return onLoan;
    }

    public void setOnLoan(boolean onLoan) {
        this.onLoan = onLoan;
    }

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    public ArrayList<Borrower> getCurrentBorrower() {
        return currentBorrower;
    }

    public void setCurrentBorrower(ArrayList<Borrower> currentBorrower) {
        this.currentBorrower = currentBorrower;
    }

    @ManyToOne
    @JoinColumn(name="library_id", nullable=false)
    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public void addCurrentBorrower(Borrower borrower){
        this.currentBorrower.add(borrower);
    }
}
