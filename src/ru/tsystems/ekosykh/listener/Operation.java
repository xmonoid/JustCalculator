package ru.tsystems.ekosykh.listener;

public enum Operation {

    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    MODULO("\\");

    private final String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public static Operation fromString(final String operation) {
        for (Operation operation1: values()) {
            if (operation1.operation.equalsIgnoreCase(operation)) {
                return operation1;
            }
        }
        throw new IllegalArgumentException("Unknown operation: " + Operation.class.getSimpleName() + ": " + operation);
    }
}
