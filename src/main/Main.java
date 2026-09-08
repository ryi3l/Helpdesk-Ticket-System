package main;

import model.Priority;
import model.Status;
import model.Ticket;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try {
            Status s = Status.OPEN;
            ArrayList<Ticket> tickets = new ArrayList<>();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Create a ticket?: ");
            String createChoice = scanner.nextLine().toUpperCase();

            if (createChoice.equals("Y")) {

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

                Priority p = Priority.valueOf(priority);

                Ticket ticket = new Ticket(
                        id,
                        title,
                        description,
                        assignedTo,
                        s,
                        p
                );

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
                }

            } else {
                System.out.println("Nonono");
            }
        }
        catch(IllegalArgumentException e){
            System.out.println("Nakupo");
        }
    }
}
