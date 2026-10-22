import java.util.Arrays;

public class BinarySearch{
    public static void main(String[] args) {
        String[] vehicles = {"V001", "V002", "V003", "V004", "V005", "V006", "V007", "V008", "V009", "V010"};
        String target = "V001";

        Arrays.sort(vehicles);

        int index = binarySearch(vehicles, target);

        if (index != -1) {
            System.out.println("'" + target + "' found at index " + index);
        } else {
            System.out.println("'" + target + "' not found in the dataset.");
        }
    }

    public static int binarySearch(String[] arr, String target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = arr[mid].compareToIgnoreCase(target);

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
