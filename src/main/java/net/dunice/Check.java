package net.dunice;

public class Check {
    static boolean checkMilk(int milk){
        if((milk < 50) || (milk > 1000)){
            Logs.logMessage("Проверьте уровень молока");
            return false;
        }else{
            return true;
        }
    }

    static boolean checkWater(int water){
        if((water < 200) || (water > 5000) ){
            Logs.logMessage("Проверьте уровень воды");
            return false;
        }else{
            return true;
        }
    }

    static boolean checkCoffee(int coffee){
        if((coffee < 50) || (coffee > 1000)){
            Logs.logMessage("Проверьте уровень кофе");
            return false;
        }else{
            return true;
        }
    }

    static boolean checkClean(int counter){
        if (counter > 0){
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
