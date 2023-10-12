import java.util.ArrayList;
import java.util.List;

// Model
class ClassroomModel {
    private List<String> classrooms = new ArrayList<>();
    private List<String> students = new ArrayList<>();
    private List<String> assignments = new ArrayList<>();
    private List<String> submissions = new ArrayList<>();

    public void addClassroom(String classroomName) {
        classrooms.add(classroomName);
    }

    public List<String> getClassrooms() {
        return classrooms;
    }

    public void addStudent(String studentName) {
        students.add(studentName);
    }

    public List<String> getStudents() {
        return students;
    }

    public void scheduleAssignment(String assignmentName) {
        assignments.add(assignmentName);
    }

    public List<String> getAssignments() {
        return assignments;
    }

    public void submitAssignment(String submission) {
        submissions.add(submission);
    }

    public List<String> getSubmissions() {
        return submissions;
    }
}

// View
class ClassroomView {
    public void printClassrooms(List<String> classrooms) {
        System.out.println("Classrooms: " + classrooms);
    }

    public void printStudents(List<String> students) {
        System.out.println("Students: " + students);
    }

    public void printAssignments(List<String> assignments) {
        System.out.println("Assignments: " + assignments);
    }

    public void printSubmissions(List<String> submissions) {
        System.out.println("Submissions: " + submissions);
    }
}

// Controller
class ClassroomController {
    private ClassroomModel model;
    private ClassroomView view;

    public ClassroomController(ClassroomModel model, ClassroomView view) {
        this.model = model;
        this.view = view;
    }

    public void addClassroom(String classroomName) {
        model.addClassroom(classroomName);
    }

    public void listClassrooms() {
        view.printClassrooms(model.getClassrooms());
    }

    public void addStudent(String studentName) {
        model.addStudent(studentName);
    }

    public void listStudents() {
        view.printStudents(model.getStudents());
    }

    public void scheduleAssignment(String assignmentName) {
        model.scheduleAssignment(assignmentName);
    }

    public void listAssignments() {
        view.printAssignments(model.getAssignments());
    }

    public void submitAssignment(String submission) {
        model.submitAssignment(submission);
    }

    public void listSubmissions() {
        view.printSubmissions(model.getSubmissions());
    }
}

public class VirtualClassroomApp {
    public static void main(String[] args) {
        ClassroomModel model = new ClassroomModel();
        ClassroomView view = new ClassroomView();
        ClassroomController controller = new ClassroomController(model, view);

        controller.addClassroom("Math");
        controller.addClassroom("Science");
        controller.addStudent("Alice");
        controller.addStudent("Bob");
        controller.scheduleAssignment("Math Homework");
        controller.scheduleAssignment("Science Project");
        controller.submitAssignment("Alice submitted Math Homework");
        controller.submitAssignment("Bob submitted Science Project");

        controller.listClassrooms();
        controller.listStudents();
        controller.listAssignments();
        controller.listSubmissions();
    }
}
