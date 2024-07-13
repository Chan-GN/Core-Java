package inheritance;

public class InheritanceDemo2 {
    public static void main(String[] args) {
        Frog frog = new Frog();
        // frog.name = "개구리"; // can't access
    }
}

class Amphibian {
    int weight;
    private String name;
}

class Frog extends Amphibian {

}