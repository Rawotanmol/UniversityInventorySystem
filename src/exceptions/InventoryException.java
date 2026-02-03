package exceptions;

// Base exception
public class InventoryException extends Exception {
    public InventoryException() {
        super();
    }

    public InventoryException(String message) {
        super(message);
    }
}

// Equipment not available exception
class EquipmentNotAvailableException extends InventoryException {
    public EquipmentNotAvailableException(String message) {
        super(message);
    }
}

// Staff member not found exception
class StaffMemberNotFoundException extends InventoryException {
    public StaffMemberNotFoundException(String message) {
        super(message);
    }
}

// Assignment limit exceeded exception
class AssignmentLimitExceededException extends InventoryException {
    public AssignmentLimitExceededException(String message) {
        super(message);
    }
}
