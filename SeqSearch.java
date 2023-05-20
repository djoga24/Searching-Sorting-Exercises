import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SeqSearch {

    public static void main(String[] args) {
        List<String> teamList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Add teams to the list
        teamList.add("Nashville");
        teamList.add("Anaheim");
        teamList.add("Arizona");

        int choice;
        do {
            // Display the menu
            System.out.println("Menu:");
            System.out.println("1. Search for a team");
            System.out.println("2. Add a team");
            System.out.println("3. Print the original and sorted lists");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        // Allow the user to search for a team
                        System.out.print("Enter a team name to search: ");
                        String teamToSearch = scanner.nextLine();

                        // If the team is in the array, print it is. If not, the user has the option to add the team to the list
                        boolean found = sequentialSearch(teamList, teamToSearch);
                        if (found) {
                            System.out.println("The team is on the list.");
                        } else {
                            System.out.print("The team is not on the list. Do you want to add it? (y/n): ");
                            String addChoice = scanner.nextLine();
                            if (addChoice.equalsIgnoreCase("y")) {
                                // Check if the team already exists before adding
                                if (teamList.contains(teamToSearch)) {
                                    System.out.println("The team is already in the list.");
                                } else {
                                    teamList.add(teamToSearch);
                                    System.out.println("The team has been added to the list.");
                                }
                            }
                        }
                        break;

                        
                    case 2:
                        // Allow the user to add a team
                        System.out.print("Enter the team name to add: ");
                        String teamToAdd = scanner.nextLine();

                        // Check if the team already exists before adding
                        if (teamList.contains(teamToAdd)) {
                            System.out.println("The team is already in the list.");
                        } else {
                            teamList.add(teamToAdd);
                            System.out.println("The team has been added to the list.");
                        }
                        break;

                    case 3:
                        // Print the list in its original form
                        System.out.println("Original List:");
                        for (String team : teamList) {
                            System.out.println(team);
                        }

                        // Sort the list using sequential sort
                        sequentialSort(teamList);
                        System.out.println("");
                        System.out.println("");

                        // Print the sorted list
                        System.out.println("Sorted List:");
                        for (String team : teamList) {
                            System.out.println(team);
                        }
                        // Exit the program
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }

                System.out.println(); 
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid menu choice.");
                scanner.nextLine(); 
                // Set choice to an invalid value to continue the loop
                choice = 0; 
            }

            // Continuing the loop until valid number is entered
        } while (choice != 3);
    }

    // Perform sequential search on the list to find the team
    private static boolean sequentialSearch(List<String> list, String searchTerm) {
        for (String team : list) {
            if (team.equalsIgnoreCase(searchTerm)) {
                return true;
            }
        }
        return false;
    }

    // Perform sequential sort on the list
    private static void sequentialSort(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareToIgnoreCase(list.get(j)) > 0) {
                    // Swap elements
                    String temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }
}

