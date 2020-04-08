import Db.DbProperties;
import Db.DbService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner in = new Scanner(System.in);
        DbProperties dbProperties = new DbProperties();
        try (Connection connection = DriverManager.getConnection(dbProperties.getUrl(), dbProperties.getUser(), dbProperties.getPassword())) {
            DbService.initDB(connection);
            while (true) {
                System.out.print("1. Add new flat\n2. Delete flat\n3. Find by district\n4. Find by address\n5. Find by area\n" +
                        "6. Find by room quantity\n7. Find by price\n8. View all\n9. Exit\n>> ");
                int command = in.nextInt();
                switch (command) {
                    case 1: {
                        Scanner iin = new Scanner(System.in);
                        DbService.addFlat(connection, iin);
                    }
                    break;
                    case 2: {
                        Scanner iin = new Scanner(System.in);
                        DbService.deleteFlat(connection, iin);
                    }
                    break;
                    case 3: {
                        Scanner iin = new Scanner(System.in);
                        DbService.findByDistrict(connection, iin);
                    }
                    break;
                    case 4: {
                        Scanner iin = new Scanner(System.in);
                        DbService.findByAddress(connection, iin);
                    }
                    break;
                    case 5: {
                        Scanner iin = new Scanner(System.in);
                        DbService.findByArea(connection, iin);
                    }
                    break;
                    case 6: {
                        Scanner iin = new Scanner(System.in);
                        DbService.findByRoomNumber(connection, iin);
                    }
                    break;
                    case 7: {
                        Scanner iin = new Scanner(System.in);
                        DbService.findByPrice(connection, iin);
                    }
                    break;
                    case 8: {
                        DbService.viewAllFlats(connection);
                    }
                    break;
                    case 9: {
                        System.exit(0);
                    }
                    default:
                        System.out.println("Wrong Command");
                }
            }
        }
    }
}