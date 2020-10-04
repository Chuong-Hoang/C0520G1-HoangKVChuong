package vn.codegym.book.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String author;
    private int quantity;
    private StringBuilder codeList = new StringBuilder("");

    public Book() {
    }

    public Book(String title, String author, int quantity, StringBuilder codeList) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.codeList = codeList;
    }

    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String name) {
        this.author = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public StringBuilder getCodeList() {
        return codeList;
    }

    public void setCodeList(StringBuilder borrowedCode) {
        this.codeList = borrowedCode;
    }
}
