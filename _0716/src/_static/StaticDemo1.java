package _static;

public class StaticDemo1 {

    public static void main(String[] args) {
        Tiger[] tigers = new Tiger[4];
        for (int i = 0; i < tigers.length; i++) {
            tigers[i] = new Tiger();
        }
        for (Tiger t : tigers)
            System.out.println("a = " + t.a + ", b = " + Tiger.b);
    }

}

class Tiger {

    static int b;
    int a;

    public Tiger() {
        a++;
        b++;
    }

}