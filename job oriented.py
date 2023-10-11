import tkinter as tk
from tkinter import messagebox

class VirtualClassroom:
    def __init__(self):
        self.classrooms = []
        self.students = {}
        self.assignments = []
        self.submissions = []

    def add_classroom(self, classroom_name):
        self.classrooms.append(classroom_name)

    def list_classrooms(self):
        return sorted(set(self.classrooms))

    def add_student(self, student_name, classroom_name):
        self.students[student_name] = classroom_name

    def list_students(self):
        student_list = {}
        for student, classroom in self.students.items():
            if classroom not in student_list:
                student_list[classroom] = [student]
            else:
                student_list[classroom].append(student)
        return student_list

    def schedule_assignment(self, assignment_name, classroom_name):
        assignment = f"{assignment_name} is given to {classroom_name}"
        self.assignments.append(assignment)

    def submit_assignment(self, student_name, assignment_name):
        submission = f"{student_name} submitted {assignment_name}"
        self.submissions.append(submission)

    def remove_classroom(self, classroom_name):
        self.classrooms.remove(classroom_name)
        for student, classroom in list(self.students.items()):
            if classroom == classroom_name:
                del self.students[student]

    def student_classname(self, student_name):
        return self.students.get(student_name, "Student not found")

def login():
    username = username_entry.get()
    password = password_entry.get()
    if username == "user" and password == "password":
        login_window.destroy()
        virtual_classroom()
    else:
        messagebox.showerror("Login Failed", "Invalid username or password")

def virtual_classroom():
    def handle_command():
        command = command_entry.get().split(" ")
        if "add_classroom" in command:
            classroom_name = command[1]
            virtual_classroom.add_classroom(classroom_name)
        elif "list_classroom" in command:
            classrooms = virtual_classroom.list_classrooms()
            result_text.set(", ".join(classrooms))
        elif "student_add" in command:
            student_name = command[1]
            classroom_name = command[2]
            virtual_classroom.add_student(student_name, classroom_name)
        elif "list_student" in command:
            students = virtual_classroom.list_students()
            result_text.set(students)
        elif "schedule_assignment" in command:
            assignment_name = command[1]
            classroom_name = command[2]
            virtual_classroom.schedule_assignment(assignment_name, classroom_name)
        elif "submit_assignment" in command:
            student_name = command[1]
            assignment_name = command[2]
            virtual_classroom.submit_assignment(student_name, assignment_name)
        elif "remove_classroom" in command:
            classroom_name = command[1]
            virtual_classroom.remove_classroom(classroom_name)
        elif "student_classname" in command:
            student_name = command[1]
            result_text.set(virtual_classroom.student_classname(student_name))
        elif "out" in command:
            root.destroy()

    root = tk.Tk()
    root.title("Virtual Classroom")
    root.geometry('925x500+300+200')
    command_label = tk.Label(root, text="Enter a command:")
    command_label.pack()
    command_entry = tk.Entry(root)
    command_entry.pack()
    submit_button = tk.Button(root, text="Submit", command=handle_command)
    submit_button.pack()
    result_text = tk.StringVar()
    result_label = tk.Label(root, textvariable=result_text)
    result_label.pack()

    virtual_classroom = VirtualClassroom()
    root.mainloop()

# Create a login window
login_window = tk.Tk()
login_window.title("Login")
username_label = tk.Label(login_window, text="Username:")
username_label.pack()
username_entry = tk.Entry(login_window)
username_entry.pack()
password_label = tk.Label(login_window, text="Password:")
password_label.pack()
password_entry = tk.Entry(login_window, show="*")
password_entry.pack()
login_button = tk.Button(login_window, text="Login", command=login)
login_button.pack()
login_window.mainloop()
