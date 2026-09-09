import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}

public class StudentCRUD {
    private static List<Student> students = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Student CRUD ---");
            System.out.println("1. Create");
            System.out.println("2. Read All");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    students.add(new Student(nextId++, name));
                    System.out.println("Student added.");
                    break;
                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (Student s : students) {
                            System.out.println(s);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter ID to update: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid ID.");
                        scanner.next();
                        break;
                    }
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    boolean foundUpdate = false;
                    for (Student s : students) {
                        if (s.id == updateId) {
                            System.out.print("Enter new name: ");
                            s.name = scanner.nextLine();
                            foundUpdate = true;
                            System.out.println("Student updated.");
                            break;
                        }
                    }
                    if (!foundUpdate) System.out.println("Student not found.");
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid ID.");
                        scanner.next();
                        break;
                    }
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    boolean removed = students.removeIf(s -> s.id == deleteId);
                    if (removed) {
                        System.out.println("Student deleted.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
