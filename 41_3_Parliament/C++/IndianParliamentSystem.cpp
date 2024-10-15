#include <iostream>
#include <vector>
#include <string>

using namespace std;

class President {
    string name;
    string termStartDate;
public:
    President(string name, string termStartDate) : name(name), termStartDate(termStartDate) {}
    void display() {
        cout << "President Name: " << name << endl;
        cout << "Term Start Date: " << termStartDate << endl;
    }
};

class Member {
    string name;
    string party;
    string house;
public:
    Member(string name, string party, string house) : name(name), party(party), house(house) {}
    void display() {
        cout << "Name: " << name << endl;
        cout << "Party: " << party << endl;
        cout << "House: " << house << endl;
    }
};

class Bill {
    string title;
    string description;
    string status;
public:
    Bill(string title, string description, string status) : title(title), description(description), status(status) {}
    void display() {
        cout << "Bill Title: " << title << endl;
        cout << "Description: " << description << endl;
        cout << "Status: " << status << endl;
    }
};

class Session {
    string sessionName;
    string startDate;
    string endDate;
public:
    Session(string sessionName, string startDate, string endDate) : sessionName(sessionName), startDate(startDate), endDate(endDate) {}
    void display() {
        cout << "Session Name: " << sessionName << endl;
        cout << "Start Date: " << startDate << endl;
        cout << "End Date: " << endDate << endl;
    }
};

int main() {
    President* president = nullptr;
    vector<Member> rajyaSabhaMembers;
    vector<Member> lokSabhaMembers;
    vector<Bill> bills;
    vector<Session> sessions;

    int choice;
    string name, party, title, description, status, sessionName, startDate, endDate;

    do {
        cout << "\nIndian Parliament System Menu:" << endl;
        cout << "1. Set President" << endl;
        cout << "2. Add Member to Rajya Sabha" << endl;
        cout << "3. Add Member to Lok Sabha" << endl;
        cout << "4. Add Bill" << endl;
        cout << "5. Add Session" << endl;
        cout << "6. Display President" << endl;
        cout << "7. Display Rajya Sabha Members" << endl;
        cout << "8. Display Lok Sabha Members" << endl;
        cout << "9. Display Bills" << endl;
        cout << "10. Display Sessions" << endl;
        cout << "11. Exit" << endl;
        cout << "Enter your choice: ";
        cin >> choice;
        cin.ignore(); // Consume newline

        switch (choice) {
            case 1:
                cout << "Enter President's Name: ";
                getline(cin, name);
                cout << "Enter Term Start Date: ";
                getline(cin, termStartDate);
                delete president; // Clean up previous instance
                president = new President(name, termStartDate);
                cout << "President set successfully." << endl;
                break;
            case 2:
                cout << "Enter Member's Name: ";
                getline(cin, name);
                cout << "Enter Party: ";
                getline(cin, party);
                rajyaSabhaMembers.push_back(Member(name, party, "Rajya Sabha"));
                cout << "Rajya Sabha member added successfully." << endl;
                break;
            case 3:
                cout << "Enter Member's Name: ";
                getline(cin, name);
                cout << "Enter Party: ";
                getline(cin, party);
                lokSabhaMembers.push_back(Member(name, party, "Lok Sabha"));
                cout << "Lok Sabha member added successfully." << endl;
                break;
            case 4:
                cout << "Enter Bill Title: ";
                getline(cin, title);
                cout << "Enter Bill Description: ";
                getline(cin, description);
                cout << "Enter Bill Status: ";
                getline(cin, status);
                bills.push_back(Bill(title, description, status));
                cout << "Bill added successfully." << endl;
                break;
            case 5:
                cout << "Enter Session Name: ";
                getline(cin, sessionName);
                cout << "Enter Session Start Date: ";
                getline(cin, startDate);
                cout << "Enter Session End Date: ";
                getline(cin, endDate);
                sessions.push_back(Session(sessionName, startDate, endDate));
                cout << "Session added successfully." << endl;
                break;
            case 6:
                if (president != nullptr) {
                    president->display();
                } else {
                    cout << "President not set." << endl;
                }
                break;
            case 7:
                if (rajyaSabhaMembers.empty()) {
                    cout << "No Rajya Sabha members added." << endl;
                } else {
                    for (auto& m : rajyaSabhaMembers) {
                        m.display();
                        cout << endl;
                    }
                }
                break;
            case 8:
                if (lokSabhaMembers.empty()) {
                    cout << "No Lok Sabha members added." << endl;
                } else {
                    for (auto& m : lokSabhaMembers) {
                        m.display();
                        cout << endl;
                    }
                }
                break;
            case 9:
                if (bills.empty()) {
                    cout << "No bills added." << endl;
                } else {
                    for (auto& b : bills) {
                        b.display();
                        cout << endl;
                    }
                }
                break;
            case 10:
                if (sessions.empty()) {
                    cout << "No sessions added." << endl;
                } else {
                    for (auto& s : sessions) {
                        s.display();
                        cout << endl;
                    }
                }
                break;
            case 11:
                cout << "Exiting..." << endl;
                break;
            default:
                cout << "Invalid choice. Please enter a number between 1 and 11." << endl;
        }
    } while (choice != 11);

    delete president; // Clean up before exiting
    return 0;
}
