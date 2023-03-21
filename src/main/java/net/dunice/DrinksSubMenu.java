package net.dunice;

import java.util.InputMismatchException;
import static net.dunice.Main.scanner;

public class DrinksSubMenu {
    private static int userSubMenuChoice;
    private static int recipeUserChoice;
    static boolean flag;
    public static void menu() {

        while (flag) {
            try {
                System.out.println("""
                        Введите необходимую опцию:\s
                        1 - Приготовить 1 порцию выбранного напитка,
                        2 - Приготовить 3 порции выбранного напитка,
                        3 - Указать нужное количество порций,
                        """);
                userSubMenuChoice = scanner.nextInt();
                Logs.logMessage("Ваш выбор - " + userSubMenuChoice);

                switch (userSubMenuChoice) {
                    case 1:
                        MenuCoffeeMachine.setAmount(1);
                        flag = false;
                        break;
                    case 2:
                        MenuCoffeeMachine.setAmount(3);
                        flag = false;
                        break;
                    case 3:
                        AmountCupOfCoffee.amountCups();
                        flag = false;
                        break;
                    default:
                        Logs.logMessage("Выбрана неверная опция.");
                }
            }catch (InputMismatchException exSubMenu){
                Logs.logMessage("Неправильный ввод данных");
                scanner.nextLine();
            }
        }
    }
    public static void recipeDrink() {
        try {
            System.out.print("Выберете напиток: ");
            System.out.println("1 - Капучино, 2 - Эспрессо.");
            recipeUserChoice = scanner.nextInt();
            switch (recipeUserChoice) {
                case 1:
                    System.out.println(Drinks.CAPPUCCINO.getRecipe());
                    break;
                case 2:
                    System.out.println(Drinks.ESPRESSO.getRecipe());
                    break;
                default:
                    Logs.logMessage("Выбрана неверная опция.");
            }
        }catch(InputMismatchException exRecipe){
            Logs.logMessage("Неправильный ввод данных");
            scanner.nextLine();
        }
    }

}
