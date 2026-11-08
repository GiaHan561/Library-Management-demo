package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.model.Book;
import com.mycompany.mavenproject1.dao.BookDAO;
import java.util.ArrayList;

public class DigitalLibrary {

    public static void main(String[] args) {

        BookDAO dao = new BookDAO();

        ArrayList<Book> books = dao.getAllBooks();

        for (Book book : books) {
            System.out.println(book);
        }
    }
}