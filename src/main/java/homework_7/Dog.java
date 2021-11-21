package homework_7;

public class Dog {
    private int distance;
    private String result = "";

    public Dog(int distance) {
        this.distance = distance;
        swimming();
        running();
    }

    public Dog() {

    }

    private void swimming() {
        if (distance > 10) {
            result += "Собака не проплывёт расстояние в " + distance + " метров(а).";
        } else {
            result += "Собака проплывёт расстояние в " + distance + " метров(а).";
        }
    }

    private void running() {
        if (distance > 500) {
            result += " Также не пробежит такую дистанцию.";
        } else {
            result += " Также пробежит такую дистанцию";
        }
    }

    public void swim(int distance) {
        if (distance > 10) {
            System.out.println("Собака не проплывёт расстояние в " + distance + " метров(а).");
        } else {
            System.out.println("Собака успешно проплывёт расстояние в " + distance + " метров(а).");
        }
    }

    public void run(int distance) {
        if (distance > 500) {
            System.out.println("Собака не пробежит дистанцию в " + distance + " метров(а).");
        } else {
            System.out.println("Собака успешно пробежит дистанцию в " + distance + " метров(а).");
        }
    }

    @Override
    public String toString() {
        return "Итог таков: " + result;
    }
}
