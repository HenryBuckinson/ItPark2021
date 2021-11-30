package homework_8_firstExercise;

public class MainProgram {
    public static void main(String[] args) {
        Animal animals = new Animal();
        animals.voice();
        Animal[] objArr = new Animal[]{new Cat(), new Dog(), new Cow(), new Elephant()};
        for (Animal i : objArr) {
            i.voice();
        }
    }
}
