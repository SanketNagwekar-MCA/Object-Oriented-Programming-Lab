class President:
    def __init__(self, name, term_start_date):
        self.name = name
        self.term_start_date = term_start_date

    def display(self):
        print(f"President Name: {self.name}")
        print(f"Term Start Date: {self.term_start_date}")

class Member:
    def __init__(self, name, party, house):
        self.name = name
        self.party = party
        self.house = house

    def display(self):
        print(f"Name: {self.name}")
        print(f"Party: {self.party}")
        print(f"House: {self.house}")

class Bill:
    def __init__(self, title, description, status):
        self.title = title
        self.description = description
        self.status = status

    def display(self):
        print(f"Bill Title: {self.title}")
        print(f"Description: {self.description}")
        print(f"Status: {self.status}")

class Session:
    def __init__(self, session_name, start_date, end_date):
        self.session_name = session_name
        self.start_date = start_date
        self.end_date = end_date

    def display(self):
        print(f"Session Name: {self.session_name}")
        print(f"Start Date: {self.start_date}")
        print(f"End Date: {self.end_date}")

def main():
    president = None
    rajya_sabha_members = []
    lok_sabha_members = []
    bills = []
    sessions = []

    while True:
        print("\nIndian Parliament System Menu:")
        print("1. Set President")
        print("2. Add Member to Rajya Sabha")
        print("3. Add Member to Lok Sabha")
        print("4. Add Bill")
        print("5. Add Session")
        print("6. Display President")
        print("7. Display Rajya Sabha Members")
        print("8. Display Lok Sabha Members")
        print("9. Display Bills")
        print("10. Display Sessions")
        print("11. Exit")
        choice = int(input("Enter your choice: "))

        if choice == 1:
            name = input("Enter President's Name: ")
            term_start_date = input("Enter Term Start Date: ")
            president = President(name, term_start_date)
            print("President set successfully.")
        elif choice == 2:
            name = input("Enter Member's Name: ")
            party = input("Enter Party: ")
            rajya_sabha_members.append(Member(name, party, "Rajya Sabha"))
            print("Rajya Sabha member added successfully.")
        elif choice == 3:
            name = input("Enter Member's Name: ")
            party = input("Enter Party: ")
            lok_sabha_members.append(Member(name, party, "Lok Sabha"))
            print("Lok Sabha member added successfully.")
        elif choice == 4:
            title = input("Enter Bill Title: ")
            description = input("Enter Bill Description: ")
            status = input("Enter Bill Status: ")
            bills.append(Bill(title, description, status))
            print("Bill added successfully.")
        elif choice == 5:
            session_name = input("Enter Session Name: ")
            start_date = input("Enter Session Start Date: ")
            end_date = input("Enter Session End Date: ")
            sessions.append(Session(session_name, start_date, end_date))
            print("Session added successfully.")
        elif choice == 6:
            if president:
                president.display()
            else:
                print("President not set.")
        elif choice == 7:
            if not rajya_sabha_members:
                print("No Rajya Sabha members added.")
            else:
                for member in rajya_sabha_members:
                    member.display()
                    print()
        elif choice == 8:
            if not lok_sabha_members:
                print("No Lok Sabha members added.")
            else:
                for member in lok_sabha_members:
                    member.display()
                    print()
        elif choice == 9:
            if not bills:
                print("No bills added.")
            else:
                for bill in bills:
                    bill.display()
                    print()
        elif choice == 10:
            if not sessions:
                print("No sessions added.")
            else:
                for session in sessions:
                    session.display()
                    print()
        elif choice == 11:
            print("Exiting...")
            break
        else:
            print("Invalid choice. Please enter a number between 1 and 11.")

if __name__ == "__main__":
    main()
