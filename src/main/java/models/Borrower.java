package models;

import org.apache.commons.collections.ArrayStack;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name="borrowers")
public class Borrower {

    private int id;
    private String name;
    private ArrayList<Book> itemsBorrowed;
    private Library library;

    public Borrower(){

    }

    public Borrower(int id, String name, Library library) {
        this.id = id;
        this.name = name;
        this.itemsBorrowed = new ArrayList<>();
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

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name="book_id", nullable=false)
    public ArrayList<Book> getItemsBorrowed() {
        return itemsBorrowed;
    }

    public void setItemsBorrowed(ArrayList<Book> itemsBorrowed) {
        this.itemsBorrowed = itemsBorrowed;
    }

    @ManyToOne
    @JoinColumn(name="library_id", nullable=false)
    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public void addItemsBorrowed(Book book){
        this.itemsBorrowed.add(book);
    }
}
