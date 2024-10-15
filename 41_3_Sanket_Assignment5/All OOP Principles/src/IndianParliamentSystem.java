import java.util.ArrayList;
import java.util.Scanner;

abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void display();
}

class President extends Person {
    private String termStartDate;

    public President(String name, String termStartDate) {
        super(name);
        this.termStartDate = termStartDate;
    }

    @Override
    public void display() {
        System.out.println("President Name: " + getName());
        System.out.println("Term Start Date: " + termStartDate);
    }
}

class Member extends Person {
    private String party;
    private String house;

    public Member(String name, String party, String house) {
        super(name);
        this.party = party;
        this.house = house;
    }

    @Override
    public void display() {
        System.out.println("Name: " + getName());
        System.out.println("Party: " + party);
        System.out.println("House: " + house);
    }
}

class Bill {
    private String title;
    private String description;
    private String status;

    public Bill(String title, String description, String status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public void display() {
        System.out.println("Bill Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Status: " + status);
    }
}

class Session {
    private String sessionName;
    private String startDate;
    private String endDate;

    public Session(String sessionName, String startDate, String endDate) {
        this.sessionName = sessionName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void display() {
        System.out.println("Session Name: " + sessionName);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
    }
}

public class IndianParliamentSystem {
    private static President president;
    private static ArrayList<Member> rajyaSabhaMembers = new ArrayList<>();
    private static ArrayList<Member> lokSabhaMembers = new ArrayList<>();
    private static ArrayList<Bill> bills = new ArrayList<>();
    private static ArrayList<Session> sessions = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nIndian Parliament System Menu:");
            System.out.println("1. Set President");
            System.out.println("2. Add Member to Rajya Sabha");
            System.out.println("3. Add Member to Lok Sabha");
            System.out.println("4. Add Bill");
            System.out.println("5. Add Session");
            System.out.println("6. Display President");
            System.out.println("7. Display Rajya Sabha Members");
            System.out.println("8. Display Lok Sabha Members");
            System.out.println("9. Display Bills");
            System.out.println("10. Display Sessions");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter President's Name: ");
                    String presidentName = scanner.nextLine();
                    System.out.print("Enter Term Start Date: ");
                    String termStartDate = scanner.nextLine();
                    president = new President(presidentName, termStartDate);
                    System.out.println("President set successfully.");
                    break;
                case 2:
                    System.out.print("Enter Member's Name: ");
                    String rajyaSabhaMemberName = scanner.nextLine();
                    System.out.print("Enter Party: ");
                    String rajyaSabhaParty = scanner.nextLine();
                    rajyaSabhaMembers.add(new Member(rajyaSabhaMemberName, rajyaSabhaParty, "Rajya Sabha"));
                    System.out.println("Rajya Sabha member added successfully.");
                    break;
                case 3:
                    System.out.print("Enter Member's Name: ");
                    String lokSabhaMemberName = scanner.nextLine();
                    System.out.print("Enter Party: ");
                    String lokSabhaParty = scanner.nextLine();
                    lokSabhaMembers.add(new Member(lokSabhaMemberName, lokSabhaParty, "Lok Sabha"));
                    System.out.println("Lok Sabha member added successfully.");
                    break;
                case 4:
                    System.out.print("Enter Bill Title: ");
                    String billTitle = scanner.nextLine();
                    System.out.print("Enter Bill Description: ");
                    String billDescription = scanner.nextLine();
                    System.out.print("Enter Bill Status: ");
                    String billStatus = scanner.nextLine();
                    bills.add(new Bill(billTitle, billDescription, billStatus));
                    System.out.println("Bill added successfully.");
                    break;
                case 5:
                    System.out.print("Enter Session Name: ");
                    String sessionName = scanner.nextLine();
                    System.out.print("Enter Session Start Date: ");
                    String sessionStartDate = scanner.nextLine();
                    System.out.print("Enter Session End Date: ");
                    String sessionEndDate = scanner.nextLine();
                    sessions.add(new Session(sessionName, sessionStartDate, sessionEndDate));
                    System.out.println("Session added successfully.");
                    break;
                case 6:
                    if (president != null) {
                        president.display();
                    } else {
                        System.out.println("President not set.");
                    }
                    break;
                case 7:
                    if (rajyaSabhaMembers.isEmpty()) {
                        System.out.println("No Rajya Sabha members added.");
                    } else {
                        for (Member m : rajyaSabhaMembers) {
                            m.display();
                            System.out.println();
                        }
                    }
                    break;
                case 8:
                    if (lokSabhaMembers.isEmpty()) {
                        System.out.println("No Lok Sabha members added.");
                    } else {
                        for (Member m : lokSabhaMembers) {
                            m.display();
                            System.out.println();
                        }
                    }
                    break;
                case 9:
                    if (bills.isEmpty()) {
                        System.out.println("No bills added.");
                    } else {
                        for (Bill b : bills) {
                            b.display();
                            System.out.println();
                        }
                    }
                    break;
                case 10:
                    if (sessions.isEmpty()) {
                        System.out.println("No sessions added.");
                    } else {
                        for (Session s : sessions) {
                            s.display();
                            System.out.println();
                        }
                    }
                    break;
                case 11:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 11.");
            }
        } while (choice != 11);

        scanner.close();
    }
}
