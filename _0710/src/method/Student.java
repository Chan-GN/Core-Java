package method;

public class Student {
    // 학번, 국어, 영어, 수학, 총점, 평균, 평점 => 필드(Field), 속성(Attribute, Property, State)
    private String stuId, name;
    private int kor;
    private int eng;
    private int math;
    private int tot;
    private double avg;
    private char grade;

    public void printStudentInfo() {
        System.out.println("학번 = '" + stuId + '\'' +
                ", 이름 = '" + name + '\'' +
                ", 국어 = " + kor +
                ", 영어 = " + eng +
                ", 수학 = " + math +
                ", 총점 = " + tot +
                ", 평균 = " + avg +
                ", 학점 = " + grade);
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getTot() {
        return tot;
    }

    public void setTot(int tot) {
        this.tot = tot;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }
}