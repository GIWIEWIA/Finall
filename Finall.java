import java.util.ArrayList;

interface Person {
    String getName();
    void setName(String name);
    int getAge();
    void setAge(int age);
}

interface Job {
    String getPosition();
    void setPosition(String position);
    int getEmpID();
    void setEmpID(int empID);
}

class Employee implements Person, Job {
    private String Name;
    private int Age;
    private String EmpID;
    private ArrayList<Project> MyProjects;

    public Employee(String name, int age, String empID) {
        this.Name = name;
        this.Age = age;
        this.EmpID = empID;
        this.MyProjects = new ArrayList<>();
    }

    public void AddProject(Project project) {
        MyProjects.add(project);
    }

    public void ShowDetails() {
        System.out.println("Name : " + getName());
        System.out.println("Position : " + getPosition());
        System.out.println("EmpID : " + getEmpID());
        System.out.println("Project");
        for (Project project : MyProjects) {
            System.out.println("    " + project.getProject());
        }
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public void setName(String name) {
        this.Name = name;
    }

    @Override
    public int getAge() {
        return Age;
    }

    @Override
    public void setAge(int age) {
        this.Age = age;
    }

    @Override
    public String getPosition() {
        return MyProjects.get(0).getPosition(); // Assuming all projects have the same position for simplicity
    }

    @Override
    public void setPosition(String position) {
        MyProjects.get(0).setPosition(position); // Assuming all projects have the same position for simplicity
    }

    @Override
    public int getEmpID() {
        return Integer.parseInt(EmpID);
    }

    @Override
    public void setEmpID(int empID) {
        this.EmpID = String.format("%04d", empID);
    }
}

class Project {
    private String projectName;
    private String Description;

    public Project(String projectName, String description) {
        this.projectName = projectName;
        this.Description = description;
    }

    public String getProject() {
        return projectName + " : " + Description;
    }

    public String getPosition() {
        return projectName; // Assuming project name is also the position for simplicity
    }

    public void setPosition(String position) {
        this.projectName = position;
    }
}

public class Main {
    public static void main(String[] args) {
        Employee tom = new Employee("Tom", 30, "0001");
        Employee tim = new Employee("Tim", 25, "0002");

        Project webA = new Project("Web A", "Developing a web application");
        Project mobileAppA = new Project("Mobile app A", "Developing a mobile app");

        tom.AddProject(webA);
        tom.AddProject(mobileAppA);

        Project webB = new Project("Web B", "Developing another web application");

        tim.AddProject(webB);

        tom.ShowDetails();
        System.out.println("\n***************\n");
        tim.ShowDetails();
    }
}