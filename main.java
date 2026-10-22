import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n==============================");
            System.out.println("     ALGORITHM SELECTOR       ");
            System.out.println("==============================");
            System.out.println("1. Binary Search");
            System.out.println("2. Linear Search");
            System.out.println("3. Sorting Algorithms");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next(); // Clear invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    BinarySearch.run();
                    break;
                case 2:
                    LinearSearch.run();
                    break;
                case 3:
                    Sorting.run();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose between 1 and 4.");
            }
        }
        scanner.close();
    }
}
