import java.util.ArrayList;
import java.io.FileWriter;

public class StudentService {

    ArrayList<Student> students = new ArrayList<>();

    public void addStudent(int id, String name, int marks){
        Student s = new Student(id, name, marks);
        students.add(s);
        System.out.println("Student Added");
    }

    public void viewStudents(){

        if(students.size() == 0){
            System.out.println("No students found");
            return;
        }

        for(Student s : students){
            System.out.println("ID: " + s.id);
            System.out.println("Name: " + s.name);
            System.out.println("Marks: " + s.marks);
            System.out.println("----------------");
        }
    }

    public void searchStudent(int id){

        for(Student s : students){
            if(s.id == id){
                System.out.println("Student Found");
                System.out.println("Name: " + s.name);
                System.out.println("Marks: " + s.marks);
                return;
            }
        }

        System.out.println("Student Not Found");
    }

    public void deleteStudent(int id){

        for(Student s : students){
            if(s.id == id){
                students.remove(s);
                System.out.println("Student Deleted");
                return;
            }
        }

        System.out.println("Student Not Found");
    }

    // GENERATE HTML PAGE
    public void generateHTML(){

        try{

            FileWriter writer = new FileWriter("results.html");

            writer.write("<html>");
            writer.write("<head><title>Student Records</title></head>");
            writer.write("<body>");

            writer.write("<h1>Student Record System</h1>");

            writer.write("<table border='1'>");
            writer.write("<tr>");
            writer.write("<th>ID</th>");
            writer.write("<th>Name</th>");
            writer.write("<th>Marks</th>");
            writer.write("</tr>");

            for(Student s : students){

                writer.write("<tr>");
                writer.write("<td>" + s.id + "</td>");
                writer.write("<td>" + s.name + "</td>");
                writer.write("<td>" + s.marks + "</td>");
                writer.write("</tr>");

            }

            writer.write("</table>");
            writer.write("</body>");
            writer.write("</html>");

            writer.close();

            System.out.println("results.html created");

        }
        catch(Exception e){
            System.out.println("Error creating HTML page");
        }

    }

}