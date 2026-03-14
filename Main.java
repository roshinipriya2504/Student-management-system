import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while(true){

            System.out.println("\n---- Student Record System ----");
            System.out.println("1 Add Student");
            System.out.println("2 View Students");
            System.out.println("3 Search Student");
            System.out.println("4 Delete Student");
            System.out.println("5 Exit");

            int choice = sc.nextInt();

            switch(choice){

                case 1:

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();

                    service.addStudent(id, name, marks);
                    break;

                case 2:
                    service.viewStudents();
                    break;

                case 3:

                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    service.searchStudent(searchId);
                    break;

                case 4:

                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    service.deleteStudent(deleteId);
                    break;

                case 5:

                    service.generateHTML();
                    System.out.println("Program exited. Open results.html to see page.");
                    return;

                default:
                    System.out.println("Invalid option");

            }

        }

    }

}