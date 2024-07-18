package lambda;

@FunctionalInterface
interface Say {

    void something();

}

@FunctionalInterface
interface SomeInterface {

    int getIntValue();

}

public class LambdaDemo3 {

    public static void main(String[] args) {
        Person person = new Person();

        person.greeting(new Say() {
            @Override
            public void something() {
                System.out.println("I'm a person");
            }
        });

        person.greeting(() -> {
            System.out.println("I'm a person");
            System.out.println("I'm a person");
        });

        person.doSomething(() -> {
            System.out.println("Get 100");
            return 100;
        });
    }

}

class Person {

    public void greeting(Say say) {
        say.something();
    }

    public void doSomething(SomeInterface someInterface) {
        int intValue = someInterface.getIntValue();
        System.out.println(intValue);
    }

}