/*
Name: Sanket Nagwekar
Roll No.: 41
Seat No.: 24P0320042
Description: This is a menu driven management system for the ICON and FIRE conferences using OOC.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract class for Event
abstract class Event {
    private String eventName;
    private String eventDate;
    private String eventVenue;

    public Event(String eventName, String eventDate, String eventVenue) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventVenue = eventVenue;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    // Abstract method to display event details
    public abstract void displayEventDetails();
}

// Class for Workshop Event
class Workshop extends Event {
    private String speaker;

    public Workshop(String eventName, String eventDate, String eventVenue, String speaker) {
        super(eventName, eventDate, eventVenue);
        this.speaker = speaker;
    }

    public String getSpeaker() {
        return speaker;
    }

    @Override
    public void displayEventDetails() {
        System.out.println("Workshop Event: " + getEventName());
        System.out.println("Date: " + getEventDate());
        System.out.println("Venue: " + getEventVenue());
        System.out.println("Speaker: " + getSpeaker());
    }
}

// Class for Tutorial Event
class Tutorial extends Event {
    private String speaker;

    public Tutorial(String eventName, String eventDate, String eventVenue, String speaker) {
        super(eventName, eventDate, eventVenue);
        this.speaker = speaker;
    }

    public String getSpeaker() {
        return speaker;
    }

    @Override
    public void displayEventDetails() {
        System.out.println("Tutorial Event: " + getEventName());
        System.out.println("Date: " + getEventDate());
        System.out.println("Venue: " + getEventVenue());
        System.out.println("Speaker: " + getSpeaker());
    }
}

// Class for Paper Presentation Event
class PaperPresentation extends Event {
    private String speaker;

    public PaperPresentation(String eventName, String eventDate, String eventVenue, String speaker) {
        super(eventName, eventDate, eventVenue);
        this.speaker = speaker;
    }

    public String getSpeaker() {
        return speaker;
    }

    @Override
    public void displayEventDetails() {
        System.out.println("Paper Presentation Event: " + getEventName());
        System.out.println("Date: " + getEventDate());
        System.out.println("Venue: " + getEventVenue());
        System.out.println("Speaker: " + getSpeaker());
    }
}

// Class to manage the events
class ConferenceEventManager {
    private List<Event> events;

    public ConferenceEventManager() {
        events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void displayAllEvents() {
        for (Event event : events) {
            event.displayEventDetails();
            System.out.println("----------------------------");
        }
    }
}

public class ConferenceManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConferenceEventManager eventManager = new ConferenceEventManager();

        while (true) {
            System.out.println("Welcome to DCST, Goa Business School, Goa!");
            System.out.println("ICON and FIRE are scheduled to be held in the month of December 2024.");
            System.out.println("1. Add a Workshop");
            System.out.println("2. Add a Tutorial");
            System.out.println("3. Add a Paper Presentation");
            System.out.println("4. Display All Events");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Workshop Name: ");
                    String workshopName = scanner.nextLine();
                    System.out.print("Enter Workshop Date: ");
                    String workshopDate = scanner.nextLine();
                    System.out.print("Enter Workshop Venue: ");
                    String workshopVenue = scanner.nextLine();
                    System.out.print("Enter Speaker Name: ");
                    String workshopSpeaker = scanner.nextLine();
                    Workshop workshop = new Workshop(workshopName, workshopDate, workshopVenue, workshopSpeaker);
                    eventManager.addEvent(workshop);
                    break;

                case 2:
                    System.out.print("Enter Tutorial Name: ");
                    String tutorialName = scanner.nextLine();
                    System.out.print("Enter Tutorial Date: ");
                    String tutorialDate = scanner.nextLine();
                    System.out.print("Enter Tutorial Venue: ");
                    String tutorialVenue = scanner.nextLine();
                    System.out.print("Enter Tutor Name: ");
                    String tutorialSpeaker = scanner.nextLine();
                    Workshop tutorial = new Workshop(tutorialName, tutorialDate, tutorialVenue, tutorialSpeaker);
                    eventManager.addEvent(tutorial);
                    break;

                case 3:
                    System.out.print("Enter Paper Name: ");
                    String paperName = scanner.nextLine();
                    System.out.print("Enter Presentation Date: ");
                    String presentationDate = scanner.nextLine();
                    System.out.print("Enter Presentation Venue: ");
                    String presentationVenue = scanner.nextLine();
                    System.out.print("Enter Presentors Name: ");
                    String speaker = scanner.nextLine();
                    Workshop paperPresentation = new Workshop(paperName, presentationDate, presentationVenue, speaker);
                    eventManager.addEvent(paperPresentation);
                    break;

                case 4:
                    eventManager.displayAllEvents();
                    break;

                case 5:
                    System.out.println("Exiting the system...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
