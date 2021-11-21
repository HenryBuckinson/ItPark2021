package homework_7;

public class Cat {
    private int distance;
    private String result = "Жаль, но в условиях нашей задачи кот не умеет плавать. ";

    public Cat(int distance) {
        this.distance = distance;
        running();
    }

    public Cat() {

    }

    public void run(int distance) {
        if (distance > 200) {
            System.out.println("Кот не пробежит расстояние в " + distance + " метров(а).");
        } else {
            System.out.println("Кот успешно пробежит расстояние в " + distance + " метров(а).");
        }
    }

    public void swim(int distance) {
        System.out.println("Кот не умеет плавать.");
    }

    private void running() {
        if (distance > 200) {
            result += "Также не пробежит дистанцию в " + distance + " метров(а).";
        } else {
            result += "Однако пробежит " + distance + " метров(а).";
        }
    }

    @Override
    public String toString() {
        return "Итог таков: " + result;
    }
}
