# TicketFlow (Java, Console-Based)
A support/helpdesk ticket management system built in Java as a learning project and portfolio piece. The program will let a user create, view, update, assign, and search tickets stored in memory during runtime, tracking each ticket's status and priority.

**Status: early development.** Core `Ticket` class and basic creation flow are working; menu loop, storage, and remaining features are in progress.

## Features
- **Create Ticket** — Enter an ID, title, description, and assignee to add a new ticket. *(working)*
- **List Tickets** — Display all tickets currently stored. *(planned)*
- **View Ticket** — Look up a single ticket by ID. *(planned)*
- **Update Ticket** — Change a ticket's status, priority, or assignee. *(planned)*
- **Add Comment** — Attach a comment (author, text, timestamp) to a ticket. *(planned)*
- **Search/Filter** — Find tickets by status or priority. *(planned)*
- **Exit** — Cleanly exits the program. *(planned)*

## Project Structure
```
src/
├── Main.java                  # Entry point; handles the menu loop and user choice routing
└── model/
    └── Ticket.java             # Represents a single ticket (id, title, description, assignedTo)
```
*(structure will grow — `Status`, `Priority`, and `Comment` are next, followed by a storage/service layer once the menu loop and ArrayList are in place)*

## How It Works
- `Main.java` reads user input via `Scanner` and, at this stage, walks through a single create flow — a full repeating menu loop is the next step.
- Ticket data is currently constructed directly in `Main` and printed; it is not yet stored anywhere persistent between actions.
- `Ticket.java` holds a ticket's core fields (`id`, `title`, `description`, `assignedTo`) with a constructor and a `toString()` override for clean display formatting. `Status` and `Priority` fields are not implemented yet.

## Requirements
- Java JDK (any recent version)
- Any Java IDE (IntelliJ IDEA recommended) or the command line

## How to Run
**Using an IDE:**
1. Open the project folder in your IDE.
2. Run `Main.java`.

**Using the command line:**
```bash
cd src
javac Main.java model/Ticket.java
java main.Main
```

## Notes & Future Improvements
This project is a work in progress and is being built deliberately in phases, adding complexity only when a real need for it appears. Planned improvements for the current phase:
- Build a repeating menu loop instead of a single one-shot create flow.
- Store tickets in an `ArrayList<Ticket>` and implement List/View/Update/Search.
- Add `Status` and `Priority` enums, and a `Comment` class.
- Add input validation (empty titles, invalid enum values, non-existent IDs).
- Add error handling to prevent crashes on invalid input.
- Learn and add JUnit tests.

Beyond the console phase, the longer-term roadmap includes SQL/MySQL persistence, a Spring Boot REST API, MySQL integration via Spring Data JPA, n8n automation, and a frontend — each introduced only once the previous phase is solid.

## About This Project
This project is a hands-on exercise in real Java development: classes and objects, constructors, encapsulation, collections, `Scanner` input, control flow, and — as the project grows — SQL, Spring Boot, and beyond. It's built with a mentor-guided, one-concept-at-a-time approach rather than by following a finished reference implementation, and it doubles as an earlier project in an ongoing series of Java projects built while learning the language.