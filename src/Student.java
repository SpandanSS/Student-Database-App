import java.util.Scanner;
public class Student {
    private String firstName;
    private String lastName;
    private int grade;
    private String courses = "";
    private String studentId;
    private int balance = 0;
    private static final int courseCost = 600;
    private static int id = 1000;

    //constructor to ask user for student name and year, call setStudentID() and mainScreen()
    public Student(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter student's first name: ");
        this.firstName = in.nextLine();

        System.out.print("Enter student's last name: ");
        this.lastName = in.nextLine();

        System.out.println("\nChoose an option for student's grade level:\n1. Freshman\n2. Sophomore\n3. Junior\n4. Senior ");
        this.grade = in.nextInt();

        setStudentID();

        System.out.println("\nName: " + firstName + " " + lastName +
                "\nGrade level: " + grade + "\nStudent's unique ID: "  + studentId);

        mainScreen();

    }
    //mainScreen method in a loop till user picks an option or decides to exit
    public void mainScreen(){
        Scanner in = new Scanner(System.in);
        int option;
        do{
            System.out.println("""
                                    
                    Choose an option:
                    Press 1 to enroll in courses.
                    Press 2 to pay tuition.
                    Press 3 to show account balance.
                    Press 4 to show student info.
                    Press 0 to quit.
                                    
                    """);

            option = in.nextInt();
            switch (option) {
                case 1: enroll(); break;
                case 2:  {if (balance > 0) payTuition();
                            else System.out.println("\nYour account is in good standing.");} break;
                case 3: getBalance(); break;
                case 4: showInfo(); break;
                case 0: break;
                default: System.out.println("Enter correct input"); break;
            }
        }while(option!=0);
    }

    //Generate a unique ID using grade year as first digit
    private void setStudentID(){
        id++;
        this.studentId = grade + String.valueOf(id);
    }

    //Enroll in courses
    public void enroll() {
        int choice;
        do {
            System.out.println("""
                    
                    Choose courses to enroll in:
                    1. History 101
                    2. Mathematics 101
                    3. English 101
                    4. Chemistry 101
                    5. Computer Science 101
                    Press 0 to go to main screen.
                    
                    """);
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();
            switch (choice){
                case 1: balance += courseCost; courses += "\n  History 101"; break;
                case 2: balance += courseCost; courses += "\n  Mathematics 101"; break;
                case 3: balance += courseCost; courses += "\n  English 101"; break;
                case 4: balance += courseCost; courses += "\n  Chemistry 101"; break;
                case 5: balance += courseCost; courses += "\n  Computer Science 101"; break;
                case 0: mainScreen(); break;
                default: System.out.println("PLease enter correct input."); break;
            }
        } while (choice != 0);

        System.out.println("\nEnrolled in:\n" + courses + "\nTuition balance: $" + balance);
    }

    //View Balance
    public void getBalance() {
        if (balance > 0) System.out.println("Your balance is: $" + balance);
            else System.out.println("Your account is in good standing");
    }

    //Pay tuition and update balance
    public void payTuition(){
        int payment;
        Scanner in = new Scanner(System.in);
        System.out.print("Input payment amount: $" );
        payment = in.nextInt();
        balance -= payment;
        System.out.println("Thanks for your payment. Your new balance is $" + balance);
    }

    //Show student info
    public void showInfo(){
        System.out.println("\nName: " + firstName + " " + lastName +
                "\nGrade level: " + grade + "\nStudent unique ID: "  + studentId +
                "\nCourses enrolled in: " + courses +
                "\nAccount balance: $" + balance );
    }
}
