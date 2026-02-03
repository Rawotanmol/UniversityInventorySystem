package models;

public class Equipment extends InventoryItem {
    private String brand;
    private int warrantyMonths;

    // Constructor
    public Equipment(String id, String name, boolean isAvailable, String brand, int warrantyMonths) {
        super(id, name, isAvailable);
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
    }

    // Getters and Setters
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public int getWarrantyMonths() { return warrantyMonths; }
    public void setWarrantyMonths(int warrantyMonths) { this.warrantyMonths = warrantyMonths; }

    // Implement abstract method
    @Override
    public String getItemType() {
        return "Equipment";
    }

    // Override toString
    @Override
    public String toString() {
        return "Equipment [id=" + getId() + ", name=" + getName() + ", available=" + isAvailable() +
                ", brand=" + brand + ", warrantyMonths=" + warrantyMonths + "]";
    }

    // equals method to compare by id
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Equipment other = (Equipment) obj;
        return this.getId().equals(other.getId());
    }
}

