
public class LinearSearch_Bartaula {
    public static void main(String[] args) {
        String[] vehicles = {"Accord", "Accord", "Civic", "Civic", "CR-V", "HR-V", "Odyssey", "Passport", "Pilot", "Ridgeline"};
        String target = "pilot";
        int counter = 0;

        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i].equalsIgnoreCase(target)) {
                System.out.println(target + " found in position:" + i);
                counter++;
            }
        }

        if (counter == 0) {
            System.out.println(target + " not found ");
        }

        System.out.println("Total number of " + target + " = " + counter);
    }
}
