public class Student {
    private String stuId;
    private String name;
    private int kor, eng, math, edp, tot;
    private double avg;
    private char grade;

    public Student(String stuId, String name, int kor, int eng, int math, int edp) {
        this.stuId = stuId;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.edp = edp;
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

    public int getEdp() {
        return edp;
    }

    public void setEdp(int edp) {
        this.edp = edp;
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