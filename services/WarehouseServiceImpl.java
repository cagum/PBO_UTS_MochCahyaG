// WarehouseServiceImpl.java
package services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import models.Part;

public class WarehouseServiceImpl implements WarehouseService {
    private List<Part> parts;

    public WarehouseServiceImpl() {
        this.parts = new ArrayList<>();
        // Inisialisasi data parts awal
        this.parts.add(new Part("Keyboard", 10, "Mechanical"));
        this.parts.add(new Part("Mouse", 15, "Wireless"));
        this.parts.add(new Part("Monitor", 5, "27-inch IPS"));
    }

    @Override
    public void addPart(Part part) {
        parts.add(part);
    }

    @Override
    public void deletePart(String name) {
        for (Iterator<Part> iterator = parts.iterator(); iterator.hasNext();) {
            Part part = iterator.next();
            if (part.getName().equals(name)) {
                iterator.remove();
                return;
            }
        }
        System.out.println("Part dengan nama '" + name + "' tidak ditemukan.");
    }

    @Override
    public void editPartName(String name, String newName) {
        for (Part part : parts) {
            if (part.getName().equals(name)) {
                part.setName(newName);
                return;
            }
        }
        System.out.println("Part dengan nama '" + name + "' tidak ditemukan.");
    }

    @Override
    public void editPartQuantity(String name, int newQuantity) {
        for (Part part : parts) {
            if (part.getName().equals(name)) {
                part.setQuantity(newQuantity);
                return;
            }
        }
        System.out.println("Part dengan nama '" + name + "' tidak ditemukan.");
    }

    @Override
    public void displayAllParts() {
        System.out.println("== Daftar Parts ==");
        for (Part part : parts) {
            System.out.println("Nama: " + part.getName() + ", Quantity: " + part.getQuantity() + ", Spesifikasi: " + part.getSpecification());
        }
    }

    @Override
    public void searchPart(String name) {
        for (Part part : parts) {
            if (part.getName().equals(name)) {
                System.out.println("Part ditemukan:");
                System.out.println("Nama: " + part.getName() + ", Quantity: " + part.getQuantity() + ", Spesifikasi: " + part.getSpecification());
                return;
            }
        }
        System.out.println("Part dengan nama '" + name + "' tidak ditemukan.");
    }

    @Override
    public void editPart(String oldPartName, String newPartName, int newQuantity, String newSpecification) {
        throw new UnsupportedOperationException("Unimplemented method 'editPart'");
    }

    @Override
    public void takePart(String name, int quantity) {
        for (Part part : parts) {
            if (part.getName().equals(name)) {
                if (part.getQuantity() >= quantity) {
                    part.setQuantity(part.getQuantity() - quantity);
                    System.out.println("Part '" + name + "' sebanyak " + quantity + " berhasil diambil.");
                    return;
                } else {
                    System.out.println("Part '" + name + "' tidak memiliki cukup stok.");
                    return;
                }
            }
        }
        System.out.println("Part dengan nama '" + name + "' tidak ditemukan.");
    }

    @Override
    public void returnPart(String name, int quantity) {
        for (Part part : parts) {
            if (part.getName().equals(name)) {
                part.setQuantity(part.getQuantity() + quantity);
                System.out.println("Part '" + name + "' sebanyak " + quantity + " berhasil dikembalikan.");
                return;
            }
        }
        System.out.println("Part dengan nama '" + name + "' tidak ditemukan.");
    }
}
