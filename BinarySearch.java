import java.util.InputMismatchException;
import java.util.Scanner;

public class BinarySearch {


    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Collect weather statistics
        int numDays = 0;
        boolean validInput = false;

        // Get the number of days from the user
        while (!validInput) {
            try {
                System.out.print("Enter the number of days: ");
                numDays = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); 
            }
        }


        // Create an array to store temperatures for each day
        double[] temperatures = new double[numDays];

        // Get the temperature for each day from the user
        for (int i = 0; i < numDays; i++) {
            validInput = false;

            while (!validInput) {
                try {
                    System.out.print("Enter the temperature for day " + (i + 1) + ": ");
                    temperatures[i] = scanner.nextDouble();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid temperature.");
                    scanner.nextLine(); // Clear the invalid input
                }
            }
        }


        int choice;
        do {
            // Display the menu
            System.out.println("Menu:");
            System.out.println("1. Search for a temperature");
            System.out.println("2. Sort the temperatures");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // Search for a specific temperature
                        System.out.print("Enter a temperature to search: ");
                        double searchTemperature;
                        while (true) {
                            try {
                                searchTemperature = scanner.nextDouble();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid temperature. Please enter a valid decimal number.");
                                scanner.nextLine(); 
                            }
                        }
                        // Perform binary search to find a specific temperature in the array
                        int index = binarySearch(temperatures, searchTemperature);

                        if (index != -1) {
                            System.out.println("Temperature found at index: " + index);
                        } else {
                            System.out.println("Temperature not found.");
                        }
                        break;

                    case 2:
                        // Sort the temperatures using Bubble Sort[sort the array!]
                        bubbleSort(temperatures);

                        // Print the sorted temperatures
                        System.out.println("Sorted Temperatures:");
                        for (double temperature : temperatures) {
                            System.out.println(temperature);
                        }

                        // Exit the program
                        choice = 2; 
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid menu choice.");
                scanner.nextLine(); 
                // Set choice to an invalid value to continue the loop
                choice = 0; 
            }

            System.out.println();

        } while (choice != 2);
    }

    // Bubble Sort algorithm to sort the array of temperatures
    private static void bubbleSort(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements if they are in the wrong order
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Binary Search algorithm to find a specific temperature in the sorted array
    private static int binarySearch(double[] arr, double key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                 // Return the index if the temperature is found
                return mid;
            } else if (arr[mid] < key) {
                // Continue searching in the right half of the array
                low = mid + 1; 
            } else {
                // Continue searching in the left half of the array
            }
                high = mid - 1; 
        }

        return -1; // Return -1 if the temperature is not found
    }
}