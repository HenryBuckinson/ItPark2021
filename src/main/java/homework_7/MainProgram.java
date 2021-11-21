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

        Cat testCat_2 = new Cat();
        testCat_2.swim(100);
        testCat_2.run(200);
        System.out.println();
        Dog testDog_2 = new Dog();
        testDog_2.run(500);
        testDog_2.swim(10);
        System.out.println();
        Tiger testTiger_2 = new Tiger();
        testTiger_2.run(900);
        testTiger_2.swim(30);

    }
}
