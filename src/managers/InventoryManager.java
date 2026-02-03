package managers;

import models.*;
import exceptions.*;

public class InventoryManager {

    // Assign equipment to a staff member
    public void assignEquipment(StaffMember staff, Equipment equipment) 
            throws EquipmentNotAvailableException, AssignmentLimitExceededException {

        if (!equipment.isAvailable()) {
            throw new EquipmentNotAvailableException("Equipment " + equipment.getId() + " is not available.");
        }

        if (staff.getAssignedEquipmentCount() >= 5) {
            throw new AssignmentLimitExceededException("Staff " + staff.getName() + " has reached the assignment limit.");
        }

        staff.addAssignedEquipment(equipment);
        equipment.setAvailable(false);
        System.out.println("Assigned " + equipment.getName() + " to " + staff.getName());
    }

    // Return equipment
    public void returnEquipment(StaffMember staff, String assetId) throws EquipmentNotAvailableException {
        boolean removed = staff.removeAssignedEquipment(assetId);
        if (!removed) {
            throw new EquipmentNotAvailableException("Equipment " + assetId + " was not assigned to " + staff.getName());
        }
        System.out.println("Equipment " + assetId + " returned by " + staff.getName());
    }

    // Calculate maintenance fee
    public double calculateMaintenanceFee(Equipment equipment, int daysOverdue) {
        double fee = 0.0;

        // Example switch by category (assume category is stored in Equipment name for simplicity)
        switch (equipment.getItemType()) {
            case "Equipment":
                fee = daysOverdue * 5;
                break;
            case "LabEquipment":
                fee = daysOverdue * 10;
                break;
            case "Furniture":
                fee = daysOverdue * 2;
                break;
            default:
                fee = daysOverdue * 1;
        }
        return fee;
    }

    // Search equipment by name
    public void searchEquipment(Equipment[] inventory, String name) {
        System.out.println("Searching for equipment by name: " + name);
        for (Equipment e : inventory) {
            if (e != null && e.getName().equalsIgnoreCase(name)) {
                System.out.println(e);
            }
        }
    }

    // Additional search methods (overloaded)
    public void searchEquipment(Equipment[] inventory, String category, boolean availableOnly) {
        System.out.println("Searching for equipment by category: " + category + " Available only: " + availableOnly);
        for (Equipment e : inventory) {
            if (e != null && e.getCategory().equalsIgnoreCase(category)) {
                if (!availableOnly || e.isAvailable()) {
                    System.out.println(e);
                }
            }
        }
    }

    public void searchEquipment(Equipment[] inventory, int minWarranty, int maxWarranty) {
        System.out.println("Searching for equipment with warranty between " + minWarranty + " and " + maxWarranty);
        for (Equipment e : inventory) {
            if (e != null && e.getWarrantyMonths() >= minWarranty && e.getWarrantyMonths() <= maxWarranty) {
                System.out.println(e);
            }
        }
    }
}
