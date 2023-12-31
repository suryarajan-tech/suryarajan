//This is a code of Virtual classroom in java bit with the same format of inputs.


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VirtualClassroom {
    private List<String> classrooms = new ArrayList<>();
    private Map<String, String> students = new HashMap<>();
    private List<String> assignments = new ArrayList<>();
    private List<String> submissions = new ArrayList<>();

    public void addClassroom(String classroomName) {
        classrooms.add(classroomName);
    }

    public void listClassrooms() {
        Set<String> uniqueClassrooms = new HashSet<>(classrooms);
        List<String> sortedClassrooms = new ArrayList<>(uniqueClassrooms);
        sortedClassrooms.sort(String::compareTo);
        System.out.println(sortedClassrooms);
    }

    public void addStudent(String studentName, String classroomName) {
        students.put(studentName, classroomName);
        System.out.println(students);
    }

    public void listStudents() {
        System.out.println("List of students in classrooms: ");
        Set<String> uniqueClassrooms = new HashSet<>(students.values());
        for (String classroom : uniqueClassrooms) {
            List<String> studentsInClassroom = new ArrayList<>();
            for (Map.Entry<String, String> entry : students.entrySet()) {
                if (entry.getValue().equals(classroom)) {
                    studentsInClassroom.add(entry.getKey());
                }
            }
            System.out.println("Classroom: " + classroom + ", Students: " + studentsInClassroom);
        }
    }

    public void scheduleAssignment(String assignmentName, String classroomName) {
        String assignment = assignmentName + " is given to " + classroomName;
        assignments.add(assignment);
        System.out.println(assignments);
    }

    public void submitAssignment(String studentName, String assignmentName) {
        String submission = studentName + " submitted " + assignmentName;
        submissions.add(submission);
        System.out.println(submissions);
    }

    public void removeClassroom(int index) {
        if (index >= 0 && index < classrooms.size()) {
            classrooms.remove(index);
        } else {
            System.out.println("Invalid classroom index");
        }
    }

    public String getStudentClassroom(String studentName) {
        return students.get(studentName);
    }

    public static void main(String[] args) {
        VirtualClassroom virtualClassroom = new VirtualClassroom();
        while (true) {
            String[] input = System.console().readLine().split(" ");
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
                virtualClassroom.submitAssignment(input[1], input[2]);
            } else if ("remove_classroom".equals(input[0])) {
                virtualClassroom.removeClassroom(Integer.parseInt(input[1]));
            } else if ("student_classname".equals(input[0])) {
                String classroom = virtualClassroom.getStudentClassroom(input[1]);
                System.out.println(classroom);
            } else if ("out".equals(input[0])) {
                System.exit(0);
            }
        }
    }
}
