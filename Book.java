
package com.mycompany.mavenproject1.model;
public class Book{
    private int BookID;
    private String Title;
    private String Author;
    private String Publisher;
    private int PublishYear;
    private int Quantity;
    
    public Book(int BookID, String Title, String Author, String Publisher, int PublishYear, int Quantity){
        this.BookID = BookID;
        this.Author = Author;
        this.PublishYear = PublishYear;
        this.Publisher = Publisher;
        this.Quantity = Quantity;
        this.Title = Title;
    }
    
    public int getBookID(){
        return BookID;
    }
    public void setBookID(int BookID){
        this.BookID=BookID;
    }
    
    public String getTitle(){
        return Title;
    }
    public void setTitle(String Tile){
        this.Title = Title;
    }
    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String Publisher) {
        this.Publisher = Publisher;
    }

    public int getPublishYear() {
        return PublishYear;
    }

    public void setPublishYear(int PublishYear) {
        this.PublishYear = PublishYear;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
}
    @Override
    public String toString() {
        return "Book ID: " + BookID
                + ", Title: " + Title
                + ", Author: " + Author
                + ", Publisher: " + Publisher
                + ", Year: " + PublishYear
                + ", Quantity: " + Quantity;
    }
}


