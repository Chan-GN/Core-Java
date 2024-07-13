package inheritance;

public class InheritanceDemo3 {
    public static void main(String[] args) {
        Student student = new Student();
        student.age = 3;
        System.out.println(student.age);

        System.out.println(Student.age);

        /*
         * 위와 같이 접근이 가능하긴 하지만 혼란을 방지하기 위해
         * static 멤버에 접근할 때는 항상 해당 멤버를 정의한 클래스 이름을 사용하는 것이 좋다.
         */
        System.out.println(Person.age);
    }
}

class Person {
    static int age = 28;
    String name = "백예린";
}

class Student extends Person {

}