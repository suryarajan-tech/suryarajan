import java.util.*;

// Define Student class to represent students
class Student {
    private String name;
    private String classroomName;

    public Student(String name, String classroomName) {
        this.name = name;
        this.classroomName = classroomName;
    }

    public String getName() {
        return name;
    }

    public String getClassroomName() {
        return classroomName;
    }
}

// Define Classroom class to represent classrooms
class Classroom {
    private String name;
    private List<Student> students;
    private List<String> assignments;

    public Classroom(String name) {
        this.name = name;
        students = new ArrayList<>();
        assignments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addAssignment(String assignmentName) {
        assignments.add(assignmentName);
    }

    public List<String> getAssignments() {
        return assignments;
    }
}

// VirtualClassroom class to manage classrooms and students
public class VirtualClassroom {
    private List<Classroom> classrooms;

    public VirtualClassroom() {
        classrooms = new ArrayList<>();
    }

    public void addClassroom(String classroomName) {
        Classroom classroom = new Classroom(classroomName);
        classrooms.add(classroom);
    }

    public void listClassrooms() {
        List<String> classroomNames = new ArrayList<>();
        for (Classroom classroom : classrooms) {
            classroomNames.add(classroom.getName());
        }
        Collections.sort(classroomNames);
        System.out.println(classroomNames);
    }

    public void addStudent(String studentName, String classroomName) {
        Student student = new Student(studentName, classroomName);
        for (Classroom classroom : classrooms) {
            if (classroom.getName().equals(classroomName)) {
                classroom.addStudent(student);
                break;
            }
        }
    }

    public void listStudents() {
        System.out.println("List of students in classrooms: ");
        for (Classroom classroom : classrooms) {
            List<String> studentsInClassroom = new ArrayList<>();
            for (Student student : classroom.getStudents()) {
                studentsInClassroom.add(student.getName());
            }
            System.out.println("Classroom: " + classroom.getName() + ", Students: " + studentsInClassroom);
        }
    }

    public void scheduleAssignment(String assignmentName, String classroomName) {
        for (Classroom classroom : classrooms) {
            if (classroom.getName().equals(classroomName)) {
                classroom.addAssignment(assignmentName);
                break;
            }
        }
    }

    // Implement submitAssignment and other methods similarly

    public static void main(String[] args) {
        VirtualClassroom virtualClassroom = new VirtualClassroom();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if ("add_classroom".equals(input[0])) {
                virtualClassroom.addClassroom(input[1]);
            } else if ("list_classroom".equals(input[0])) {
                virtualClassroom.listClassrooms();
            } else if ("student_add".equals(input[0])) {
                virtualClassroom.addStudent(input[1], input[2]);
            } else if ("list_student".equals(input[0])) {
                virtualClassroom.listStudents();
            } else if ("schedule_assignment".equals(input[0])) {
                virtualClassroom.scheduleAssignment(input[1], input[2]);
            } else if ("submit_assignment".equals(input[0])) {
                // Implement submit_assignment
            } else if ("remove_classroom".equals(input[0])) {
                // Implement remove_classroom
            } else if ("student_classname".equals(input[0])) {
                // Implement student_classname
            } else if ("out".equals(input[0])) {
                System.exit(0);
            }
        }
    }
}
