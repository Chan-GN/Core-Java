public class GradeManagement1 {
    public static void main(String[] args) {
        int[][] scores = {
                {67, 89, 100},
                {77, 99, 56},
                {100, 99, 88}
        };

        for (int i = 0; i < scores.length; i++) { // 전체 학생 Loop
            int tot = 0;
            for (int j = 0; j < scores[i].length; j++) {
                tot += scores[i][j];
            }
            double avg = tot / 3.;
            char grade = (avg >= 90) ? 'A' : (avg >= 80) ? 'B' :
                    (avg >= 70) ? 'B' : (avg >= 60) ? 'B' : 'F';

            System.out.println(i + "번째 학생의 평균은 " +
                    String.format("%.2f", avg) + "점이고, " +
                    grade + "학점입니다.");
        }
    }
}
