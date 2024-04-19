// Admin.java
package users;

import java.util.Scanner;
import models.Part;
import services.WarehouseService;

public class Admin extends User {
    private WarehouseService warehouseService;

    public Admin(String username, String password, WarehouseService warehouseService) {
        super(username, password, true);
        this.warehouseService = warehouseService;
    }

    @Override
    public void login() {
        // Implementasi login admin
        if (authenticate(getUsername(), getPassword())) {
            System.out.println("Admin login successful.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    public void adminMenu() {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n== Menu Admin ==");
            System.out.println("1. Tampilkan semua parts");
            System.out.println("2. Tambah part baru");
            System.out.println("3. Hapus part");
            System.out.println("4. Edit part");
            System.out.println("0. Keluar");

            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membuang karakter '\n' dari input sebelumnya

            switch (choice) {
                case 1:
                    warehouseService.displayAllParts();
                    break;
                case 2:
                    addNewPart(scanner);
                    break;
                case 3:
                    deletePart(scanner);
                    break;
                case 4:
                    editPart(scanner);
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

    private void addNewPart(Scanner scanner) {
        System.out.print("Nama part baru: ");
        String name = scanner.nextLine();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Membuang karakter '\n' dari input sebelumnya
        System.out.print("Spesifikasi: ");
        String specification = scanner.nextLine();

        // Membuat objek Part dengan parameter yang diterima dari input
        Part newPart = new Part(name, quantity, specification);
        warehouseService.addPart(newPart); // Memanggil metode addPart dengan objek Part sebagai parameter
        System.out.println("Part baru berhasil ditambahkan.");
    }

    private void deletePart(Scanner scanner) {
        System.out.print("Nama part yang akan dihapus: ");
        String partName = scanner.nextLine();
        warehouseService.deletePart(partName);
    }

    private void editPart(Scanner scanner) {
        System.out.print("Nama part yang akan diedit: ");
        String oldPartName = scanner.nextLine();
        System.out.print("Nama baru: ");
        String newPartName = scanner.nextLine();
        System.out.print("Quantity baru: ");
        int newQuantity = scanner.nextInt();
        scanner.nextLine(); // Membuang karakter '\n' dari input sebelumnya
        System.out.print("Spesifikasi baru: ");
        String newSpecification = scanner.nextLine();
        warehouseService.editPart(oldPartName, newPartName, newQuantity, newSpecification);
    }
}
