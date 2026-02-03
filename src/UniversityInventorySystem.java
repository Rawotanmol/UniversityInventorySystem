import java.util.Scanner;
import models.*;
import managers.*;
import exceptions.*;

public class UniversityInventorySystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample arrays to store staff and equipment
        StaffMember[] staffList = new StaffMember[10];
        Equipment[] equipmentList = new Equipment[20];

        InventoryManager manager = new InventoryManager();
        InventoryReports reports = new InventoryReports();

        boolean exit = false;

        while (!exit) {
            // Display menu
            System.out.println("\n=== University Inventory System ===");
            System.out.println("1. Add new equipment");
            System.out.println("2. Register a new staff member");
            System.out.println("3. Assign equipment to staff");
            System.out.println("4. Return equipment");
            System.out.println("5. Search inventory");
            System.out.println("6. Generate reports");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        // Add new equipment
                        System.out.print("Enter equipment ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter brand: ");
                        String brand = scanner.nextLine();
                        System.out.print("Enter warranty months: ");
                        int warranty = scanner.nextInt();
                        scanner.nextLine();

                        Equipment eq = new Equipment(id, name, true, brand, warranty);

                        // Add to first empty spot
                        for (int i = 0; i < equipmentList.length; i++) {
                            if (equipmentList[i] == null) {
                                equipmentList[i] = eq;
                                break;
                            }
                        }
                        System.out.println("Equipment added successfully!");
                        break;

                    case 2:
                        // Register staff
                        System.out.print("Enter staff ID: ");
                        int staffId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter staff name: ");
                        String staffName = scanner.nextLine();
                        System.out.print("Enter staff email: ");
                        String email = scanner.nextLine();

                        StaffMember staff = new StaffMember(staffId, staffName, email);
                        for (int i = 0; i < staffList.length; i++) {
                            if (staffList[i] == null) {
                                staffList[i] = staff;
                                break;
                            }
                        }
                        System.out.println("Staff registered successfully!");
                        break;

                    case 3:
                        // Assign equipment (simplified)
                        System.out.print("Enter staff ID: ");
                        int sid = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter equipment ID: ");
                        String eid = scanner.nextLine();

                        StaffMember assignStaff = null;
                        Equipment assignEq = null;

                        for (StaffMember s : staffList) {
                            if (s != null && s.getStaffId() == sid) {
                                assignStaff = s;
                                break;
                            }
                        }

                        for (Equipment e : equipmentList) {
                            if (e != null && e.getId().equals(eid)) {
                                assignEq = e;
                                break;
                            }
                        }

                        if (assignStaff != null && assignEq != null) {
                            manager.assignEquipment(assignStaff, assignEq);
                        } else {
                            System.out.println("Staff or Equipment not found.");
                        }
                        break;

                    case 4:
                        // Return equipment
                        System.out.print("Enter staff ID: ");
                        int returnSid = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter equipment ID: ");
                        String returnEid = scanner.nextLine();

                        StaffMember returnStaff = null;

                        for (StaffMember s : staffList) {
                            if (s != null && s.getStaffId() == returnSid) {
                                returnStaff = s;
                                break;
                            }
                        }

                        if (returnStaff != null) {
                            manager.returnEquipment(returnStaff, returnEid);
                        } else {
                            System.out.println("Staff not found.");
                        }
                        break;

                    case 5:
                        // Search inventory by name (example)
                        System.out.print("Enter equipment name to search: ");
                        String searchName = scanner.nextLine();
                        manager.searchEquipment(equipmentList, searchName);
                        break;

                    case 6:
                        // Generate inventory report
                        reports.generateInventoryReport(equipmentList);
                        reports.findExpiredWarranties(equipmentList);
                        reports.calculateUtilisationRate(staffList, equipmentList);
                        reports.generateMaintenanceSchedule(equipmentList);
                        break;

                    case 7:
                        exit = true;
                        System.out.println("Exiting system...");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            } catch (InventoryException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }

        scanner.close();
    }
}
