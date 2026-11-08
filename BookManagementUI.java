package com.mycompany.mavenproject1;

import javax.swing.*;
import java.awt.*;
import com.mycompany.mavenproject1.dao.BookDAO;
import com.mycompany.mavenproject1.model.Book;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class BookManagementUI extends JFrame {

    private JTable bookTable;
    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;
    private DefaultTableModel tableModel;
    private BookDAO bookDAO;

    private void showAddBookDialog() {

        JTextField txtBookID = new JTextField();
        JTextField txtTitle = new JTextField();
        JTextField txtAuthor = new JTextField();
        JTextField txtPublisher = new JTextField();
        JTextField txtYear = new JTextField();
        JTextField txtQuantity = new JTextField();

        JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5));

        panel.add(new JLabel("Book ID:"));
        panel.add(txtBookID);

        panel.add(new JLabel("Title:"));
        panel.add(txtTitle);

        panel.add(new JLabel("Author:"));
        panel.add(txtAuthor);

        panel.add(new JLabel("Publisher:"));
        panel.add(txtPublisher);

        panel.add(new JLabel("Publish Year:"));
        panel.add(txtYear);

        panel.add(new JLabel("Quantity:"));
        panel.add(txtQuantity);

        int result = JOptionPane.showConfirmDialog(
                this,
                panel,
                "Add New Book",
                JOptionPane.OK_CANCEL_OPTION
        );

        if (result == JOptionPane.OK_OPTION) {

            try {
                Book book = new Book(
                        Integer.parseInt(txtBookID.getText()),
                        txtTitle.getText(),
                        txtAuthor.getText(),
                        txtPublisher.getText(),
                        Integer.parseInt(txtYear.getText()),
                        Integer.parseInt(txtQuantity.getText())
                );

                if (bookDAO.addBook(book)) {
                    JOptionPane.showMessageDialog(this, "Add book successfully!");
                    loadBooks();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to add book!");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Book ID, Year and Quantity must be integers!");
            }
        }
    }
    
    private void deleteSelectedBook() {

        int selectedRow = bookTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a book to delete!");
            return;
        }

        int bookID = (int) tableModel.getValueAt(selectedRow, 0);

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete this book?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {

            if (bookDAO.deleteBook(bookID)) {
                JOptionPane.showMessageDialog(this, "Delete successfully!");
                loadBooks();
            } else {
                JOptionPane.showMessageDialog(this, "Delete failed!");
            }
        }
    }
    
    private void editSelectedBook() {

        int selectedRow = bookTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a book to edit!");
            return;
        }

        int bookID = (int) tableModel.getValueAt(selectedRow, 0);
        String title = tableModel.getValueAt(selectedRow, 1).toString();
        String Author = tableModel.getValueAt(selectedRow, 2).toString();
        String Publisher = tableModel.getValueAt(selectedRow, 3).toString();
        int year = (int) tableModel.getValueAt(selectedRow, 4);
        int Quantity = (int) tableModel.getValueAt(selectedRow, 5);

        JOptionPane.showMessageDialog(this,
                "Selected book: " + title + "\nBook ID: " + bookID);
    }
    
    public BookManagementUI() {

        setTitle("Digital Library Management");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        JLabel titleLabel = new JLabel("QUAN LY SACH");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(titleLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        btnAdd = new JButton("Them sach");
        btnEdit = new JButton("Sua");
        btnDelete = new JButton("Xoa");
        
        btnAdd.addActionListener(e -> showAddBookDialog());
        btnDelete.addActionListener(e -> deleteSelectedBook());
        btnEdit.addActionListener(e -> editSelectedBook());

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnEdit);
        buttonPanel.add(btnDelete);

        String[] columns = {
            "Book ID", "Title", "Author",
            "Publisher", "Year", "Quantity"
        };

        tableModel = new DefaultTableModel(columns, 0);

        bookTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(bookTable);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        loadBooks();
    }

    private void loadBooks() {

        tableModel.setRowCount(0);

        bookDAO = new BookDAO();

        ArrayList<Book> books = bookDAO.getAllBooks();

        for (Book book : books) {

            Object[] row = {
                book.getBookID(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getPublishYear(),
                book.getQuantity()
            };

            tableModel.addRow(row);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BookManagementUI().setVisible(true);
        });
    }
}
