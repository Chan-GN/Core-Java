package method;

public class Calculator {
    void calc(Student std) {
        std.setTot(std.getKor() + std.getEng() + std.getMath());
        std.setAvg(std.getTot() / 3.);

        std.setGrade((std.getAvg() >= 90) ? 'A' : (std.getAvg() >= 80) ? 'B' :
                (std.getAvg() >= 70) ? 'C' : (std.getAvg() >= 60) ? 'D' : 'F');
    }
}
