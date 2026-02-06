public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.id = "001";
        s.name = "Somchai";
        s.gpa = 3.80;

        s.showInfo();

        if (s.isExcellent()) {
            System.out.println("นักศึกษาคนนี้เก่งมาก");
        } else {
            System.out.println("นักศึกษายังต้องพัฒนา");
        }
    }
}

