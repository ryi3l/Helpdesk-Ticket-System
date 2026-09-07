package main;

import model.Ticket;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        ArrayList<Ticket> tickets = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Create a ticket?: ");
        String createChoice = scanner.nextLine().toUpperCase();

        if(createChoice.equals("Y")){

            System.out.print("Enter ticket ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Description: ");
            String description = scanner.nextLine();
            System.out.print("Assigned personel: ");
            String assignedTo = scanner.nextLine();

            Ticket ticket = new Ticket(
                    id,
                    title,
                    description,
                    assignedTo
            );

            tickets.add(ticket);


            System.out.println(tickets.get(0));

        }
        else{
            System.out.println("Nonono");
        }
    }
}
