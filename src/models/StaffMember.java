package models;

public class StaffMember {
    private int staffId;
    private String name;
    private String email;
    private Equipment[] assignedEquipment;
    private int equipmentCount; // tracks how many equipment are assigned

    // Constructor
    public StaffMember(int staffId, String name, String email) {
        this.staffId = staffId;
        this.name = name;
        this.email = email;
        this.assignedEquipment = new Equipment[5];
        this.equipmentCount = 0;
    }

    // Getters and Setters
    public int getStaffId() { return staffId; }
    public void setStaffId(int staffId) { this.staffId = staffId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Add equipment
    public boolean addAssignedEquipment(Equipment equipment) {
        if (equipmentCount < assignedEquipment.length) {
            assignedEquipment[equipmentCount++] = equipment;
            return true;
        } else {
            System.out.println("Assignment limit reached for " + name);
            return false;
        }
    }

    // Remove equipment by assetId
    public boolean removeAssignedEquipment(String assetId) {
        for (int i = 0; i < equipmentCount; i++) {
            if (assignedEquipment[i].getAssetId().equals(assetId)) {
                // Shift elements to remove the equipment
                for (int j = i; j < equipmentCount - 1; j++) {
                    assignedEquipment[j] = assignedEquipment[j + 1];
                }
                assignedEquipment[--equipmentCount] = null;
                return true;
            }
        }
        return false;
    }

    // Get number of assigned equipment
    public int getAssignedEquipmentCount() {
        return equipmentCount;
    }

    // Display assigned equipment
    public void displayAssignedEquipment() {
        System.out.println("Equipment assigned to " + name + ":");
        for (int i = 0; i < equipmentCount; i++) {
            System.out.println(assignedEquipment[i]);
        }
    }
}
