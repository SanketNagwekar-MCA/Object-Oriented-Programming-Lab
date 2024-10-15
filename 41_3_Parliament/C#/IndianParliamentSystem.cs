using System;
using System.Collections.Generic;

class President
{
    public string Name { get; set; }
    public string TermStartDate { get; set; }

    public President(string name, string termStartDate)
    {
        Name = name;
        TermStartDate = termStartDate;
    }

    public void Display()
    {
        Console.WriteLine("President Name: " + Name);
        Console.WriteLine("Term Start Date: " + TermStartDate);
    }
}

class Member
{
    public string Name { get; set; }
    public string Party { get; set; }
    public string House { get; set; }

    public Member(string name, string party, string house)
    {
        Name = name;
        Party = party;
        House = house;
    }

    public void Display()
    {
        Console.WriteLine("Name: " + Name);
        Console.WriteLine("Party: " + Party);
        Console.WriteLine("House: " + House);
    }
}

class Bill
{
    public string Title { get; set; }
    public string Description { get; set; }
    public string Status { get; set; }

    public Bill(string title, string description, string status)
    {
        Title = title;
        Description = description;
        Status = status;
    }

    public void Display()
    {
        Console.WriteLine("Bill Title: " + Title);
        Console.WriteLine("Description: " + Description);
        Console.WriteLine("Status: " + Status);
    }
}

class Session
{
    public string SessionName { get; set; }
    public string StartDate { get; set; }
    public string EndDate { get; set; }

    public Session(string sessionName, string startDate, string endDate)
    {
        SessionName = sessionName;
        StartDate = startDate;
        EndDate = endDate;
    }

    public void Display()
    {
        Console.WriteLine("Session Name: " + SessionName);
        Console.WriteLine("Start Date: " + StartDate);
        Console.WriteLine("End Date: " + EndDate);
    }
}

class Program
{
    static President president;
    static List<Member> rajyaSabhaMembers = new List<Member>();
    static List<Member> lokSabhaMembers = new List<Member>();
    static List<Bill> bills = new List<Bill>();
    static List<Session> sessions = new List<Session>();

    static void Main()
    {
        int choice;
        do
        {
            Console.WriteLine("\nIndian Parliament System Menu:");
            Console.WriteLine("1. Set President");
            Console.WriteLine("2. Add Member to Rajya Sabha");
            Console.WriteLine("3. Add Member to Lok Sabha");
            Console.WriteLine("4. Add Bill");
            Console.WriteLine("5. Add Session");
            Console.WriteLine("6. Display President");
            Console.WriteLine("7. Display Rajya Sabha Members");
            Console.WriteLine("8. Display Lok Sabha Members");
            Console.WriteLine("9. Display Bills");
            Console.WriteLine("10. Display Sessions");
            Console.WriteLine("11. Exit");
            Console.Write("Enter your choice: ");
            choice = int.Parse(Console.ReadLine());

            switch (choice)
            {
                case 1:
                    Console.Write("Enter President's Name: ");
                    string presidentName = Console.ReadLine();
                    Console.Write("Enter Term Start Date: ");
                    string termStartDate = Console.ReadLine();
                    president = new President(presidentName, termStartDate);
                    Console.WriteLine("President set successfully.");
                    break;
                case 2:
                    Console.Write("Enter Member's Name: ");
                    string rajyaSabhaMemberName = Console.ReadLine();
                    Console.Write("Enter Party: ");
                    string rajyaSabhaParty = Console.ReadLine();
                    rajyaSabhaMembers.Add(new Member(rajyaSabhaMemberName, rajyaSabhaParty, "Rajya Sabha"));
                    Console.WriteLine("Rajya Sabha member added successfully.");
                    break;
                case 3:
                    Console.Write("Enter Member's Name: ");
                    string lokSabhaMemberName = Console.ReadLine();
                    Console.Write("Enter Party: ");
                    string lokSabhaParty = Console.ReadLine();
                    lokSabhaMembers.Add(new Member(lokSabhaMemberName, lokSabhaParty, "Lok Sabha"));
                    Console.WriteLine("Lok Sabha member added successfully.");
                    break;
                case 4:
                    Console.Write("Enter Bill Title: ");
                    string billTitle = Console.ReadLine();
                    Console.Write("Enter Bill Description: ");
                    string billDescription = Console.ReadLine();
                    Console.Write("Enter Bill Status: ");
                    string billStatus = Console.ReadLine();
                    bills.Add(new Bill(billTitle, billDescription, billStatus));
                    Console.WriteLine("Bill added successfully.");
                    break;
                case 5:
                    Console.Write("Enter Session Name: ");
                    string sessionName = Console.ReadLine();
                    Console.Write("Enter Session Start Date: ");
                    string sessionStartDate = Console.ReadLine();
                    Console.Write("Enter Session End Date: ");
                    string sessionEndDate = Console.ReadLine();
                    sessions.Add(new Session(sessionName, sessionStartDate, sessionEndDate));
                    Console.WriteLine("Session added successfully.");
                    break;
                case 6:
                    if (president != null)
                    {
                        president.Display();
                    }
                    else
                    {
                        Console.WriteLine("President not set.");
                    }
                    break;
                case 7:
                    if (rajyaSabhaMembers.Count == 0)
                    {
                        Console.WriteLine("No Rajya Sabha members added.");
                    }
                    else
                    {
                        foreach (var m in rajyaSabhaMembers)
                        {
                            m.Display();
                            Console.WriteLine();
                        }
                    }
                    break;
                case 8:
                    if (lokSabhaMembers.Count == 0)
                    {
                        Console.WriteLine("No Lok Sabha members added.");
                    }
                    else
                    {
                        foreach (var m in lokSabhaMembers)
                        {
                            m.Display();
                            Console.WriteLine();
                        }
                    }
                    break;
                case 9:
                    if (bills.Count == 0)
                    {
                        Console.WriteLine("No bills added.");
                    }
                    else
                    {
                        foreach (var b in bills)
                        {
                            b.Display();
                            Console.WriteLine();
                        }
                    }
                    break;
                case 10:
                    if (sessions.Count == 0)
                    {
                        Console.WriteLine("No sessions added.");
                    }
                    else
                    {
                        foreach (var s in sessions)
                        {
                            s.Display();
                            Console.WriteLine();
                        }
                    }
                    break;
                case 11:
                    Console.WriteLine("Exiting...");
                    break;
                default:
                    Console.WriteLine("Invalid choice. Please enter a number between 1 and 11.");
                    break;
            }
        } while (choice != 11);
    }
}
