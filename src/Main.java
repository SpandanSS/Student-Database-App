import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //ask user how many students they want to add
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students you want to add: ");
        int numOfStudents = sc.nextInt();

        //Create n number of Student objects
        Student[] students = new Student[numOfStudents];
        for(int i = 0; i<numOfStudents; i++){
            students[i] = new Student();
        }
    }
}
