package model;

import java.sql.*;
import java.util.ArrayList;

public class ContactDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/contactbook";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL Driver not found!", e);
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static int addContact(ContactModel contact) throws SQLException {
        String sql = "INSERT INTO contacts (name, phone, email, address) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            setContactParameters(pstmt, contact);
            pstmt.executeUpdate();
            
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                return rs.next() ? rs.getInt(1) : -1;
            }
        }
    }

    public static boolean deleteContact(int id) {
        String sql = "DELETE FROM contacts WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateContact(ContactModel contact) throws SQLException {
        String sql = "UPDATE contacts SET name=?, phone=?, email=?, address=? WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            setContactParameters(pstmt, contact);
            pstmt.setInt(5, contact.getId());
            return pstmt.executeUpdate() > 0;
        }
    }

    public static ArrayList<ContactModel> getAllContacts() {
        ArrayList<ContactModel> contacts = new ArrayList<>();
        String sql = "SELECT * FROM contacts";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                contacts.add(new ContactModel(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("address")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    public static ContactModel getContactById(int id) {
        String sql = "SELECT * FROM contacts WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() ? new ContactModel(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("address")
                ) : null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void setContactParameters(PreparedStatement pstmt, ContactModel contact) throws SQLException {
        pstmt.setString(1, contact.getName());
        pstmt.setString(2, contact.getPhone());
        pstmt.setString(3, contact.getEmail());
        pstmt.setString(4, contact.getAddress());
    }
}