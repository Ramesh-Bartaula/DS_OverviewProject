import java.util.*;
import java.lang.*;
import java.io.*;

class ArrayList
{
	public static void main (String[] args) throws java.lang.Exception
	{
		ArrayList<String> vehicles = new ArrayList<>(Arrays.asList("Civic", "Accord", "HR-V", "CR-V", "Tesla")); 
//Display the original list.
System.out.println(vehicles); 

//Add a new vehicle to the list.
vehicles.add("Pilot");

// Insert a vehicle at a specific index.
vehicles.add(1, "Passport");

//Update/change one vehicle in the list.
vehicles.set(2,"Odyssey");

//Delete/remove one vehicle from the list.
vehicles.remove("CR-V");

//Search for a specific vehicle in the list.
int index = vehicles.indexOf("Civic");
if (index != -1) {
    System.out.println("Civic found at index: " + index);
} else {
    System.out.println("Vehicle not found.");
}

//Display the size of the list.
System.out.println("Size of the list: " + vehicles.size());

//Display the final list after all operations.
System.out.println("Final list: " + vehicles);

	}
}
