// WarehouseService.java
package services;

import models.Part;

public interface WarehouseService {
    void addPart(Part part);
    void deletePart(String name);
    void editPartName(String name, String newName);
    void editPartQuantity(String name, int newQuantity);
    void displayAllParts();
    void searchPart(String name);
    void editPart(String oldPartName, String newPartName, int newQuantity, String newSpecification);
    void takePart(String name, int quantity); // Perbarui tanda tangan metode takePart
    void returnPart(String name, int quantity);
}
