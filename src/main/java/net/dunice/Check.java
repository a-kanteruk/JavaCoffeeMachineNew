package net.dunice;

public class Check {
    static int milkMin = 50;
    static int milkMax = 1000;
    static int waterMin = 200;
    static int waterMax = 5000;
    static int coffeeMin = 50;
    static int coffeeMax = 1000;
    private static int counterMin = 0;

    static boolean checkMilk(int milk){
        if((milk < milkMin) || (milk > milkMax)){
            Logs.logMessage("Проверьте уровень молока");
            return false;
        }else{
            return true;
        }
    }

    static boolean checkWater(int water){
        if((water < waterMin) || (water > waterMax) ){
            Logs.logMessage("Проверьте уровень воды");
            return false;
        }else{
            return true;
        }
    }

    static boolean checkCoffee(int coffee){
        if((coffee < coffeeMin) || (coffee > coffeeMax)){
            Logs.logMessage("Проверьте уровень кофе");
            return false;
        }else{
            return true;
        }
    }

    static boolean checkClean(int counter){
        if (counter > counterMin){
            return true;
        }else{
            Logs.logMessage("Требуется очистка");
            return false;
        }
    }

    public static boolean checkAll(){
        boolean clean = checkClean(Resourses.getCounter());
        boolean coffee = checkCoffee(Resourses.getCoffee());
        boolean water = checkWater(Resourses.getWater());
        boolean milk = checkMilk(Resourses.getMilk());
        if (clean && coffee && water && milk){
            return true;
        }else{
            return false;
        }
    }
}
