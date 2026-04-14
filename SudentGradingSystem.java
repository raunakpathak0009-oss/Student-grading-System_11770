import java.util.Scanner;

/**
 * Student Grading System
 * Demonstrates OOP concepts: Encapsulation, Classes, Methods
 */
public class StudentGradingSystem{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter number of subjects: ");
        int numSubjects = scanner.nextInt();

        int[] marks = new int[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }

        // Create Student object
        Student student = new Student(name, marks);

        // Display results
        student.displayDetails();

        scanner.close();
    }
}


/**
 * Student class encapsulating student data and grading logic
 */
class Student {

    // Private fields (Encapsulation)
    private String name;
    private int[] marks;

    // Constructor
    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int[] getMarks() {
        return marks;
    }

    /**
     * Calculates and returns the average of all subject marks
     */
    public double calculateAverage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return (double) total / marks.length;
    }

    /**
     * Assigns a grade based on the calculated average
     * A: 90-100, B: 75-89, C: 60-74, D: 50-59, F: Below 50
     */
    public char assignGrade() {
        double average = calculateAverage();

        if (average >= 90) {
            return 'A';
        } else if (average >= 75) {
            return 'B';
        } else if (average >= 60) {
            return 'C';
        } else if (average >= 50) {
            return 'D';
        } else {
            return 'F';
        }
    }

    /**
     * Displays the complete student report
     */
    public void displayDetails() {
        System.out.println("\n=============================");
        System.out.println("      STUDENT REPORT CARD    ");
        System.out.println("=============================");
        System.out.println("Student Name : " + name);

        // Print marks
        System.out.print("Marks        : ");
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i]);
            if (i < marks.length - 1) System.out.print(", ");
        }

        System.out.printf("%nAverage      : %.2f%n", calculateAverage());
        System.out.println("Grade        : " + assignGrade());
        System.out.println("=============================");
    }
}