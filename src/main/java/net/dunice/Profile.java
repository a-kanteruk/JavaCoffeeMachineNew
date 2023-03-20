package net.dunice;
import java.util.Scanner;

public class Profile {

    private String name;
    private int capCount;
    private int espCount;
    static int id = 1;

    public Profile(String name, int capCount, int espCount) {
        this.name = name;
        this.capCount = capCount;
        this.espCount = espCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapCount() {
        return capCount;
    }

    public void setCapCount(int capCount) {
        this.capCount = capCount;
    }

    public int getEspCount() {
        return espCount;
    }

    public void setEspCount(int espCount) {
        this.espCount = espCount;
    }

    public static void createProfile(){
        Scanner scanner = new Scanner(System.in);
        String name;
        int cappuccinoCap;
        int espressoCap;

        System.out.print("Введите имя профиля: ");
        name = scanner.nextLine();
        System.out.print("Введите количество кружек 'Каппучино' профиля: ");
        cappuccinoCap = scanner.nextInt();
        System.out.print("Введите количество кружек 'Эспрессо' профиля: ");
        espressoCap = scanner.nextInt();

        Resourses.setProfileMap(id, new Profile(name, cappuccinoCap, espressoCap));
        id++;
    }
}
