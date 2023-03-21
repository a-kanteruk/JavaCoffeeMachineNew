package net.dunice;

import java.util.InputMismatchException;
import static net.dunice.Main.scanner;

public class AmountCupOfCoffee {
    public static void amountCups(){
        try {
            System.out.print("Введите нужное количество: ");
            MenuCoffeeMachine.setAmount(scanner.nextInt());
            Logs.logMessage("Вы ввели: " + MenuCoffeeMachine.getAmount());
        }catch(InputMismatchException exChoiceAmount){
            Logs.logMessage("Неправильный ввод данных.");
            MenuCoffeeMachine.setAmount(0);
            scanner.nextLine();
        }
    }
}
