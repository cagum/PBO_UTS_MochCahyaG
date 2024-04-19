// Part.java
package models;

public class Part {
    private String name;
    private int quantity;
    private String specification;

    public Part(String name, int quantity, String specification) {
        this.name = name;
        this.quantity = quantity;
        this.specification = specification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }
}