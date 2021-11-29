package homework_8_firstExercise_alternate;

public class MainProgram {
    public static void main(String[] args) {
        Animals[] obj = new Animals[]{new Cat(), new Cow(), new Dog(), new Elephant()};
        System.out.println("Каждое животное издаёт уникальный звук: ");
        for (Animals i : obj){
            i.voice();
        }
    }
}
