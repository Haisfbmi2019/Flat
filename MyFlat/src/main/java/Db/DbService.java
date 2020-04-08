package Db;

import java.sql.*;
import java.util.Scanner;

public class DbService {

    public static void initDB(Connection connection) throws SQLException {
        try (Statement st = connection.createStatement()) {
            st.execute("DROP TABLE IF EXISTS Flats");
            st.execute("CREATE TABLE Flats (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, district VARCHAR(30) NOT NULL," +
                    " address VARCHAR(30) NOT NULL, area DOUBLE NOT NULL , roomNumber INT NOT NULL, price INT NOT NULL )");
        }
    }

    public static void addFlat(Connection connection, Scanner sc) throws SQLException {
        System.out.print("Enter district: ");
        String district = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        System.out.print("Enter area: ");
        double area = sc.nextDouble();
        System.out.print("Enter room number: ");
        int roomNumber = sc.nextInt();
        System.out.println("Enter price: ");
        int price = sc.nextInt();
        System.out.println();
        try (PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO Flats (district, address, area, roomNumber, price) VALUES(?, ?, ?, ?, ?)")) {
            ps.setString(1, district);
            ps.setString(2, address);
            ps.setDouble(3, area);
            ps.setInt(4, roomNumber);
            ps.setInt(5, price);
            ps.executeUpdate();
        }
    }

    public static void deleteFlat(Connection connection, Scanner sc) throws SQLException {
        System.out.print("Enter address: ");
        String address = sc.nextLine();

        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM Flats WHERE address = ?")) {
            ps.setString(1, address);
            ps.executeUpdate();
        }
    }

    public  static  void viewAllFlats(Connection connection) throws SQLException{
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM Flats")) {
            try (ResultSet rs = ps.executeQuery()) {
                ResultSetMetaData md = rs.getMetaData();

                for (int i = 1; i <= md.getColumnCount(); i++)
                    System.out.print(md.getColumnName(i) + "\t\t");
                System.out.println();

                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        System.out.print(rs.getString(i) + "\t\t");
                    }
                    System.out.println();
                }
            }
        }
    }

    public static void findByDistrict(Connection connection, Scanner sc)throws SQLException{
        System.out.println("Enter district: ");
        String district = sc.nextLine();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM Flats WHERE district = ?")) {
            resultSet(district, ps);
        }
    }

    public static void findByAddress(Connection connection, Scanner sc)throws SQLException{
        System.out.println("Enter address: ");
        String address = sc.nextLine();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM Flats WHERE address = ?")) {
            resultSet(address, ps);
        }
    }
    public static void findByArea(Connection connection, Scanner sc)throws SQLException{
        System.out.println("Enter area: ");
        String area = sc.nextLine();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM Flats WHERE area = ?")) {
            resultSet(area, ps);
        }
    }

    public static void findByRoomNumber(Connection connection, Scanner sc)throws SQLException{
        System.out.println("Enter room quantity: ");
        String roomNumber = sc.nextLine();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM Flats WHERE roomNumber = ?")) {
            resultSet(roomNumber, ps);
        }
    }

    private static void resultSet(String roomNumber, PreparedStatement ps) throws SQLException {
        ps.setString(1, roomNumber);
        try (ResultSet rs = ps.executeQuery()) {
            ResultSetMetaData md = rs.getMetaData();
            for (int column = 1; column <= md.getColumnCount(); column++) {
                System.out.println(md.getColumnName(column) + "\t\t");
            }

            System.out.println();
            while (rs.next()) {
                for (int column = 1; column <= md.getColumnCount(); column++) {
                    System.out.println(rs.getString(column) + "\t\t");
                }
                System.out.println();
            }
        }
    }

    public static void findByPrice(Connection connection, Scanner sc)throws SQLException{
        System.out.println("Enter price: ");
        String price = sc.nextLine();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM Flats WHERE price = ?")) {
            resultSet(price, ps);
        }
    }

}
