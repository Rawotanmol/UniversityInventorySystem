package managers;

import models.*;

public class InventoryReports {

    // Generate inventory report using a for loop
    public void generateInventoryReport(InventoryItem[] items) {
        System.out.println("=== Inventory Report ===");
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                System.out.println(items[i]);
            }
        }
    }

    // Find expired warranties using while loop
    public void findExpiredWarranties(Equipment[] equipmentList) {
        System.out.println("=== Expired Warranties ===");
        int i = 0;
        while (i < equipmentList.length) {
            Equipment e = equipmentList[i];
            if (e != null && e.getWarrantyMonths() <= 0) {
                System.out.println(e);
            }
            i++;
        }
    }

    // Display assignments by department (enhanced for loop)
    public void displayAssignmentsByDepartment(StaffMember[] staffList) {
        System.out.println("=== Assignments by Department ===");
        for (StaffMember staff : staffList) {
            if (staff != null) {
                System.out.println(staff.getName() + "'s Equipment:");
                for (Equipment e : staff.getAssignedEquipment()) {
                    if (e != null) {
                        System.out.println(" - " + e.getName());
                    }
                }
            }
        }
    }

    // Calculate utilization rate using nested loops
    public void calculateUtilisationRate(StaffMember[] staffList, Equipment[] equipmentList) {
        System.out.println("=== Utilization Rate ===");
        int totalAssigned = 0;
        int totalEquipment = equipmentList.length;

        for (Equipment e : equipmentList) {
            if (e != null && !e.isAvailable()) {
                totalAssigned++;
            }
        }

        double utilisation = ((double) totalAssigned / totalEquipment) * 100;
        System.out.println("Equipment Utilisation: " + utilisation + "%");
    }

    // Generate maintenance schedule using do-while loop
    public void generateMaintenanceSchedule(Equipment[] equipmentList) {
        System.out.println("=== Maintenance Schedule ===");
        int i = 0;
        do {
            if (equipmentList[i] != null) {
                System.out.println("Schedule maintenance for: " + equipmentList[i].getName());
            }
            i++;
        } while (i < equipmentList.length);
    }
}
