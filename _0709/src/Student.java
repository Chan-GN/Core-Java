public class Student {

    // 학번, 국어, 영어, 수학, 총점, 평균, 평점 => 필드(Field), 속성(Attribute, Property, State)
    String stuId, name;
    int kor;
    int eng;
    int math;
    int tot;
    double avg;
    char grade;

    @Override
    public String toString() {
        return "Student{" +
                "stuId='" + stuId + '\'' +
                ", name='" + name + '\'' +
                ", kor=" + kor +
                ", eng=" + eng +
                ", math=" + math +
                ", tot=" + tot +
                ", avg=" + avg +
                ", grade=" + grade +
                '}';
    }
}

