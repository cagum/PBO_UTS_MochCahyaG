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
        try {
            parts.add(part);
        } catch (Exception e) {
            System.out.println("Error menambahkan part: " + e.getMessage());
        }
    }

    @Override
    public void deletePart(String name) {
        try {
            boolean found = false;
            for (Iterator<Part> iterator = parts.iterator(); iterator.hasNext();) {
                Part part = iterator.next();
                if (part.getName().equals(name)) {
                    iterator.remove();
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new Exception("Part dengan nama '" + name + "' tidak ditemukan.");
            }
        } catch (Exception e) {
            System.out.println("Error menghapus part: " + e.getMessage());
        }
    }

    @Override
    public void editPartName(String name, String newName) {
        try {
            boolean found = false;
            for (Part part : parts) {
                if (part.getName().equals(name)) {
                    part.setName(newName);
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new Exception("Part dengan nama '" + name + "' tidak ditemukan.");
            }
        } catch (Exception e) {
            System.out.println("Error mengedit nama part: " + e.getMessage());
        }
    }

    @Override
    public void editPartQuantity(String name, int newQuantity) {
        try {
            boolean found = false;
            for (Part part : parts) {
                if (part.getName().equals(name)) {
                    part.setQuantity(newQuantity);
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new Exception("Part dengan nama '" + name + "' tidak ditemukan.");
            }
        } catch (Exception e) {
            System.out.println("Error mengedit kuantitas part: " + e.getMessage());
        }
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
        try {
            boolean found = false;
            for (Part part : parts) {
                if (part.getName().equals(name)) {
                    System.out.println("Part ditemukan:");
                    System.out.println("Nama: " + part.getName() + ", Quantity: " + part.getQuantity() + ", Spesifikasi: " + part.getSpecification());
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new Exception("Part dengan nama '" + name + "' tidak ditemukan.");
            }
        } catch (Exception e) {
            System.out.println("Error mencari part: " + e.getMessage());
        }
    }

    @Override
    public void editPart(String oldPartName, String newPartName, int newQuantity, String newSpecification) {
        throw new UnsupportedOperationException("Unimplemented method 'editPart'");
    }

    @Override
    public void takePart(String name, int quantity) {
        try {
            boolean found = false;
            for (Part part : parts) {
                if (part.getName().equals(name)) {
                    if (part.getQuantity() >= quantity) {
                        part.setQuantity(part.getQuantity() - quantity);
                        System.out.println("Part '" + name + "' sebanyak " + quantity + " berhasil diambil.");
                    } else {
                        throw new Exception("Part '" + name + "' tidak memiliki cukup stok.");
                    }
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new Exception("Part dengan nama '" + name + "' tidak ditemukan.");
            }
        } catch (Exception e) {
            System.out.println("Error mengambil part: " + e.getMessage());
        }
    }

    @Override
    public void returnPart(String name, int quantity) {
        try {
            boolean found = false;
            for (Part part : parts) {
                if (part.getName().equals(name)) {
                    part.setQuantity(part.getQuantity() + quantity);
                    System.out.println("Part '" + name + "' sebanyak " + quantity + " berhasil dikembalikan.");
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new Exception("Part dengan nama '" + name + "' tidak ditemukan.");
            }
        } catch (Exception e) {
            System.out.println("Error mengembalikan part: " + e.getMessage());
        }
    }
}
