package oop;

public class ConstructorDemo2 {
    public static void main(String[] args) {
        MyDate someDay = new MyDate();
        System.out.println(someDay.getYear());
        System.out.println(someDay.getMonth());
        System.out.println(someDay.getDay());
    }
}

class MyDate {
    private int year, month, day;

    public MyDate() { // Default Constructor Overriding
        this.year = 1970;
        this.month = 1;
        this.day = 1;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}