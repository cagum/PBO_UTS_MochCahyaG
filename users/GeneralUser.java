// GeneralUser.java
package users;

import java.util.Scanner;
import services.WarehouseService;

public class GeneralUser extends User {
    private WarehouseService warehouseService;

    public GeneralUser(String username, String password, WarehouseService warehouseService) {
        super(username, password, false);
        this.warehouseService = warehouseService;
    }

    @Override
    public void login() {
        // Implementasi login user umum
        if (authenticate(getUsername(), getPassword())) {
            System.out.println("General user login successful.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    public void generalUserMenu() {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n== Menu General User ==");
            System.out.println("1. Tampilkan semua parts");
            System.out.println("2. Ambil part");
            System.out.println("3. Kembalikan part");
            System.out.println("0. Keluar");

            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membuang karakter '\n' dari input sebelumnya

            switch (choice) {
                case 1:
                    warehouseService.displayAllParts();
                    break;
                case 2:
                    takePart(scanner);
                    break;
                case 3:
                    returnPart(scanner);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        }

        scanner.close();
    }

    private void takePart(Scanner scanner) {
        System.out.print("Masukkan nama part yang ingin diambil: ");
        String partName = scanner.nextLine();
        System.out.print("Masukkan jumlah part yang ingin diambil: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Membuang karakter '\n' dari input sebelumnya
        warehouseService.takePart(partName, quantity);
    }

    private void returnPart(Scanner scanner) {
        System.out.println("Masukkan nama part yanng akan dikembalikan : ");
        String partName = scanner.nextLine();
        System.out.println("Masukkan jumlah part yang akan dikembalikan : ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); //Membuang karakter '/n' dari input sebelumnya
        warehouseService.returnPart(partName, quantity);
    }
}
