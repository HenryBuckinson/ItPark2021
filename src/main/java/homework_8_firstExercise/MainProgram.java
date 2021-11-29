package homework_8_firstExercise;

public class MainProgram {
    public static void main(String[] args) {
        Animals o = new Animals();
        o.voice();
        Animals[] objArr = new Animals[]{new Cat(), new Dog(), new Cow(), new Elephant()};
        for (Animals i : objArr) {
            i.voice();
        }
    }
}
