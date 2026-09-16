package main;

import model.Priority;
import model.Status;
import model.Ticket;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<Ticket> tickets = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                1 - Create Ticket
                2 - View Tickets
                3 - Update Ticket
                4 - Remove Ticket
                """);
        System.out.print("What do you want to do?: ");
        int choice = scanner.nextInt();

        switch(choice){
            case 1 -> {
    // ----------------------------------------------------------------------------------------------------------------------
                System.out.print("Enter ticket ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Title: ");
                String title = scanner.nextLine();
                System.out.print("Description: ");
                String description = scanner.nextLine();
                System.out.print("Assigned personnel: ");
                String assignedTo = scanner.nextLine();
                System.out.print("Priority: ");
                String priority = scanner.nextLine().toUpperCase();
    // ----------------------------------------------------------------------------------------------------------------------
                Priority p;
                try {
                    p = Priority.valueOf(priority);
                } // End of try
                catch(IllegalArgumentException e){
                    System.out.println("Error");
                    return;
                } // End of catch
    // ----------------------------------------------------------------------------------------------------------------------
                Ticket ticket = new Ticket(
                        id,
                        title,
                        description,
                        assignedTo,
                        Status.OPEN,
                        p
                );
    // ----------------------------------------------------------------------------------------------------------------------
                if (
                        ticket.getId() < 0 ||
                                ticket.getTitle().isBlank() ||
                                ticket.getDescription().isBlank() ||
                                ticket.getAssignedTo().isBlank()
                ) {
                    System.out.println("Redo");
                } else {
                    tickets.add(ticket);
                    System.out.println(tickets.get(0));
                }// End of else
            } // End of case 1
            case 2 -> {
                System.out.println("View");
            } // End of case 2
            case 3 -> {
                System.out.println("Update");
            } // End of case 3
            case 4 -> {
                System.out.println("Remove");
            } // End of case 4
            default -> System.out.println("Invalid Input");
        } // End of switch case






    }
}
