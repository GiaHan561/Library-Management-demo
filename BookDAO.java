package com.mycompany.mavenproject1.dao;

import com.mycompany.mavenproject1.model.Book;
import com.mycompany.mavenproject1.database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO {

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();

        String sql = "SELECT * FROM BOOK";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                Book book = new Book(
                    rs.getInt("BookID"),
                    rs.getString("Title"),
                    rs.getString("Author"),
                    rs.getString("Publisher"),
                    rs.getInt("PublishYear"),
                    rs.getInt("Quantity")
                );

                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }
    public boolean addBook(Book book) {

        String sql = "INSERT INTO BOOK "
                + "(BookID, Title, Author, Publisher, PublishYear, Quantity) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, book.getBookID());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setString(4, book.getPublisher());
            ps.setInt(5, book.getPublishYear());
            ps.setInt(6, book.getQuantity());

            int result = ps.executeUpdate();

            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
}
    public boolean deleteBook(int bookID) {

        String sql = "DELETE FROM BOOK WHERE BookID = ?";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, bookID);

            int result = ps.executeUpdate();

            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}