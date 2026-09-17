package main;

import model.Comment;
import model.Priority;
import model.Status;
import model.Ticket;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<Ticket> tickets = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while(loop) {
            System.out.println("""
                    1 - Create Ticket
                    2 - View Tickets
                    3 - Update Ticket
                    4 - Remove Ticket
                    5 - Exit
                    """);
            System.out.print("What do you want to do?: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    createTicket(tickets, scanner);
                } // End of case 1
                case 2 -> {
                    viewTicket(tickets, scanner);
                } // End of case 2
                case 3 -> {
                    updateTicket(tickets, scanner);
                } // End of case 3
                case 4 -> {
                    removeTicket(tickets, scanner);
                } // End of case 4
                case 5 -> {
                    System.out.println("BYE");
                    loop = false;
                }
                default -> System.out.println("Invalid Input");
            } // End of switch case
        } // End of while loop

    } // End of main

    public static void createTicket(ArrayList<Ticket> tickets, Scanner scanner){
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
    } // End of createTicket

    public static void viewTicket(ArrayList<Ticket> tickets, Scanner scanner){
        System.out.println("Do you want to view all tickets? (Y/N)");
        System.out.print("Answer: ");
        scanner.nextLine();
        String viewChoice = scanner.nextLine().toUpperCase();
        if(viewChoice.equals("Y")){
            for(Ticket ticket : tickets){
                System.out.println(ticket + "\n");
            }
        }else if(viewChoice.equals("N")) {
            System.out.print("Type the ID: ");
            int idChoice = scanner.nextInt();
            for (Ticket ticket : tickets) {
                if (ticket.getId() == idChoice) {
                    System.out.println(ticket);
                }
                else if(tickets.contains(ticket.getId()) == false){
                    System.out.println("No matching ID !!!");
                }
            } // End of for loop
        } // End of else if condition

    } // End of viewTicket

    public static void updateTicket(ArrayList<Ticket> tickets, Scanner scanner){
        System.out.print("Type the ID: ");
        int idChoice = scanner.nextInt();
        boolean found = false;
        for (Ticket ticket : tickets) {
            if (ticket.getId() == idChoice) {
                int id = ticket.getId();
                String title = ticket.getTitle();
                String description = ticket.getDescription();

                System.out.println(ticket);
                System.out.println("""
                        Choices:
                        OPEN
                        IN_PROGRESS
                        RESOLVED
                        CLOSED
                        """);
                System.out.print("Status: ");
                scanner.nextLine();
                String status = scanner.nextLine().toUpperCase();
                System.out.println("""
                        Choices:
                        LOW
                        MEDIUM
                        HIGH
                        URGENT
                        """);
                System.out.print("Priority: ");
                String priority = scanner.nextLine().toUpperCase();
                System.out.print("Assigned personnel: ");
                String assignedTo = scanner.nextLine();

                Priority p;
                Status s;
                try {
                    p = Priority.valueOf(priority);
                    s = Status.valueOf(status);
                } // End of try
                catch(IllegalArgumentException e){
                    System.out.println("Error");
                    return;
                } // End of catch

                ticket.setStatus(s);
                ticket.setPriority(p);
                ticket.setAssignedTo(assignedTo);
            } // End of if condition
            else if(tickets.contains(ticket.getId()) == false){
                System.out.println("No matching ID !!!");
            }
        } // End of for loop
    } // End of updateTicket method

    public static void removeTicket(ArrayList<Ticket> tickets, Scanner scanner){
        System.out.print("Type the ID: ");
        int idChoice = scanner.nextInt();
        try {
            for (Ticket ticket : tickets) {
                int index = tickets.indexOf(ticket);
                if (ticket.getId() == idChoice) {
                    tickets.remove(index);
                    System.out.println("Ticket with ID " + idChoice + " is now removed.");
                } else if (tickets.contains(ticket.getId()) == false) {
                    System.out.println("No matching ID !!!");
                }
            } // End of for loop
        } // End of try
        catch(ConcurrentModificationException e){
            // Ignored: The program will continue executing normally
        } // End of catch

    } // End of removeTicket method

}
