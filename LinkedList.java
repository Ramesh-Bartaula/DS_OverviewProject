class LinkedList {
    private static class Node {
        String vehicle;
        Node next;

        Node(String vehicle) {
            this.vehicle = vehicle;
        }
    }
//Create a LinkedList with at least 5 vehicles.
    public static void main(String[] args) {
        Node head = new Node("Civic");
        Node accord = new Node("Accord");
        Node hrV = new Node("HR-V");
        Node crV = new Node("CR-V");
        Node tesla = new Node("Tesla");

        head.next = accord;
        accord.next = hrV;
        hrV.next = crV;
        crV.next = tesla;
        tesla.next = null;

        // Display the original list.
        System.out.print("Original List: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.vehicle + " ");
            current = current.next;
        }
        System.out.println();

        // Add a new vehicle (Pilot)
        tesla.next = new Node("Pilot");

        // Remove a new vehicle (HR-V)
        accord.next = crV;

        // Display the vehicle at a specific position (2)
        current = head;
        for (int position = 1; position < 2; position++) {
            current = current.next;
        }
        System.out.println("Vehicle at second position: " + current.vehicle);

        // Traverse and display the vehicles from beginning to end
        System.out.print("Beginning to end: ");
        current = head;
        while (current != null) {
            System.out.print(current.vehicle + " ");
            current = current.next;
        }
        System.out.println();

        // Traverse and display the vehicles from end to beginning
        System.out.print("End to beginning: ");
        displayBackward(head);
        System.out.println();

        // Display the final LinkedList.
        System.out.print("Final List: ");
        current = head;
        while (current != null) {
            System.out.print(current.vehicle + " ");
            current = current.next;
        }
        System.out.println();
    }

    private static void displayBackward(Node node) {
        if (node != null) {
            displayBackward(node.next);
            System.out.print(node.vehicle + " ");
        }
    }
}
