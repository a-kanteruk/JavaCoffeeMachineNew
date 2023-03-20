package net.dunice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AmountCupOfCoffee {
    static Scanner scanner = new Scanner(System.in);

    public static void amountCups(){
        try {
            System.out.print("Введите нужное количество: ");
            MenuCoffeeMachine.amount = scanner.nextInt();
            Logs.logMessage("Вы ввели: " + MenuCoffeeMachine.amount);
        }catch(InputMismatchException exChoiceAmount){
            exChoiceAmount.getMessage();
            Logs.logMessage("Неправильный ввод данных.");
            MenuCoffeeMachine.amount = 0;
            scanner.nextLine();
        }
    }
}
