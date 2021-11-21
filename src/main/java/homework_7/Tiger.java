package homework_7;

public class Tiger {
    private int distance;
    private String result = "";

    public Tiger(int distance) {
        this.distance = distance;
        swimming();
        running();
    }

    public Tiger() {

    }

    private void swimming() {
        if (distance > 100) {
            result += "Тигр не проплывёт расстояние в " + distance + " метров(а).";
        } else {
            result += "Тигр проплывёт расстояние в " + distance + " метров(а).";
        }
    }

    private void running() {
        if (distance > 1000) {
            result += " Также не пробежит такую дистанцию.";
        } else {
            result += " Также пробежит такую дистанцию";
        }
    }

    public void swim(int distance) {
        if (distance > 100) {
            System.out.println("Тигр не проплывёт расстояние в " + distance + " метров(а).");
        } else {
            System.out.println("Тигр успешно проплывёт расстояние в " + distance + " метров(а).");
        }
    }

    public void run(int distance) {
        if (distance > 1000) {
            System.out.println("Тигр не пробежит дистанцию в " + distance + " метров(а)");
        } else {
            System.out.println("Тигр успешно пробежит дистанцию в " + distance + " метров(а)");
        }
    }

    @Override
    public String toString() {
        return "Итог таков: " + result;
    }
}
