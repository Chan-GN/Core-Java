package oop;

public class InitBlock {
    private double weight;
    private char grade;

    // Initialization Block
    {
        this.weight = 100.;
        this.grade = 'A';
        System.out.println("Initialization Block");
    }

    /*
        public InitBlock() {
            this.weight = 62.4;
            this.grade = 'B';
        }
    */

    public static void main(String[] args) {
        InitBlock initBlock = new InitBlock();
        InitBlock initBlock2 = new InitBlock();
        System.out.println(initBlock.weight + "kg");
        System.out.println(initBlock.grade);
    }
}
