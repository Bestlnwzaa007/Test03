public class Student {
    String id;
    String name;
    double gpa;

    public void showInfo(){
        System.out.println("ID: "+ id);
        System.out.println("Name: "+ name);
        System.out.println("GPA (Updated): "+ gpa);
    }

    public boolean isExcellent() {
        return gpa >= 3.50;
        }
    
}
