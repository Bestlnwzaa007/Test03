public class Student {
    private String name;
    private int score;
    private String grade;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
        this.grade = calculateGrade(score);
    }

    private String calculateGrade(int score) {
        if (score >= 80) return "A";
        else if (score >= 70) return "B";
        else if (score >= 60) return "C";
        else if (score >= 50) return "D";
        else return "F";
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getGrade() {
        return grade;
    }
}