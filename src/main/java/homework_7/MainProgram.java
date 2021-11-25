package homework_7;

public class MainProgram {
    public static void main(String[] args) {
        Cat testCat = new Cat(150);
        System.out.println(testCat);
        Dog testDog = new Dog(501);
        System.out.println(testDog);
        Tiger testTiger = new Tiger(560);
        System.out.println(testTiger);

        System.out.println();

        Cat testCat2 = new Cat();
        testCat2.swim(100);
        testCat2.run(200);
        System.out.println();
        Dog testDog2 = new Dog();
        testDog2.run(500);
        testDog2.swim(10);
        System.out.println();
        Tiger testTiger2 = new Tiger();
        testTiger2.run(900);
        testTiger2.swim(30);

    }
}
