// Main.java
import java.util.Scanner;
import services.WarehouseService;
import services.WarehouseServiceImpl;
import users.Admin;
import users.GeneralUser;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WarehouseService warehouseService = new WarehouseServiceImpl();

        System.out.println("Selamat datang!");
        System.out.println("Silakan login sebagai admin atau general user");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        // Tambahkan logika untuk menetapkan password yang diinginkan
        String password = "";
        if (username.equals("admin")) {
            System.out.print("Password: ");
            password = scanner.nextLine();
        } else if (username.equals("user")) {
            System.out.print("Password: ");
            password = scanner.nextLine();
        } else {
            System.out.println("Username tidak valid.");
            scanner.close();
            return;
        }

        // Memeriksa apakah login sebagai admin atau general user
        if (isAdmin(username, password)) {
            Admin admin = new Admin(username, password, warehouseService);
            admin.login();
            admin.adminMenu();
        } else if (isGeneralUser(username, password)) {
            GeneralUser generalUser = new GeneralUser(username, password, warehouseService);
            generalUser.login();
            generalUser.generalUserMenu(); // Memanggil metode generalUserMenu
        } else {
            System.out.println("Username atau password salah.");
        }

        scanner.close();
    }

    // Method untuk memeriksa apakah login sebagai admin
    private static boolean isAdmin(String username, String password) {
        // Logika untuk memeriksa apakah username dan password cocok dengan data admin yang valid
        return username.equals("admin") && password.equals("admin123");
    }

    // Method untuk memeriksa apakah login sebagai general user
    private static boolean isGeneralUser(String username, String password) {
        // Logika untuk memeriksa apakah username dan password cocok dengan data general user yang valid
        return username.equals("user") && password.equals("user123");
    }
}
