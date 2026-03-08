package edu.unisabana.dyas.samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AlterTable {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:bd.sqlite3");
            Statement stmt = conn.createStatement();
            // Add id column to VI_ITEMRENTADO
            stmt.execute("ALTER TABLE VI_ITEMRENTADO ADD COLUMN id INTEGER PRIMARY KEY AUTOINCREMENT");
            // Update the id with rowid or something
            stmt.execute("UPDATE VI_ITEMRENTADO SET id = rowid");
            conn.close();
            System.out.println("Table altered successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}