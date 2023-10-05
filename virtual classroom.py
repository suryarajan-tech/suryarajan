#Only 5 class is acceptable if class does not exist students cannot be enrolled in the class

#Using lists this code is made
class virtual_classroom():
    global l     #Converting local variable into global to be used in user defined functions
    l=[]
    global l1
    global l2
    global l3
    global l4
    global l5
    global l7
    global l8
    l1=[]
    l2=[]
    l3=[]
    l4=[]
    l5=[]
    l7=[]
    l8=[]

    def add_classroom(w):
        l.append(s[1])
        
    def list_classroom(w):
        print(sorted(l))
        
    def student_add(w):
        if (s[2]=="class1" and "class1" in l): #Checking whether class is created and s[2] for which class name is given
            l1.append(s[1])

        if s[2]=="class2" and "class2" in l:
            l2.append(s[1])

        if s[2]=="class3" and "class3" in l:
            l3.append(s[1])

        if s[2]=="class4" and "class4" in l:
            l4.append(s[1])

        if s[2]=="class5" and "class5" in l:
            l5.append(s[1])
        
    def list_student(w):
        if (l1!=None):
            print("list of students in class",sorted(set(l1)))
        if (l2!=None):
            print("list of students in class",sorted(set(l2)))
        if (l3!=None):
            print("list of students in class",sorted(set(l3)))
        if (l4!=None):
            print("list of students in class",sorted(set(l4)))
        if (l5!=None):
            print("list of students in class",sorted(set(l5)))
            
    def schedule_assignment(w):
        global c
        c=s[1]+" is given to "+s[2]
        l7.append(c)
        for i in l7:
            print(i,end="")

    def submit_assignment(w):
        global n
        n=s[1]+" submitted "+s[2]
        l8.append(n)
        for i in l8:
            print(i,end="")

    def remove_classroom(w):
        l.pop(int(s[1]))

    def student_classname(w):
        if (int(s[1])<=50):
            print("Class1") #return

        elif (int(s[1])>50 and int(s[1])<=100):
            print("Class2") #return

        elif (int(s[1])>100 and int(s[1])<=150):
            print("Class3") #return

        elif (int(s[1])>150 and int(s[1])<=200):
            print("Class4") #return

        elif (int(s[1])>200 and int(s[1])<=250):
            print("Class5") #return

        else:
            print("Student Id not enrolled") #return

    def quit(w):
        exit()
        
c=virtual_classroom()

while(1):
    global s
    s=input().split(" ")
    if "add_classroom" in s:
        c.add_classroom()
        
    if "list_classroom" in s:
        c.list_classroom()

    if "student_add" in s:
        c.student_add()

    if "list_student" in s:
        c.list_student()
        
    if "schedule_assignment" in s:
        c.schedule_assignment()
    
    if "submit_assignment" in s:
        c.submit_assignment()

    if "remove_classroom" in s:
        c.remove_classroom()

    if "student_classname" in s:
        c.student_classname()

    if "quit out" in s:
        c.quit()
