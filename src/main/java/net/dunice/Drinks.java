package net.dunice;

public enum Drinks {
    CAPPUCCINO("капучино", 150, 10, 30),
    ESPRESSO("эспрессо", 140, 15, 0);
    String name;
    int water;
    int coffee;
    int milk;

    Drinks(String name, int water, int coffee, int milk) {
        this.name = name;
        this.water = water;
        this.coffee = coffee;
        this.milk = milk;
    }

    public String getRecipe() {
        return "Название '" + name + '\'' +
                        ", Количество воды = " + water +
                        ", Количество кофе = " + coffee +
                        ", Количество молока = " + milk;
    }

    public static void createDrink(Drinks drink){
        if (MenuCoffeeMachine.getAmount() > 0) {
            for (int i = 1; i <= MenuCoffeeMachine.getAmount(); i++) {
                if (Check.checkAll()) {
                    Resourses.setNewLevel(drink);
                    Logs.logMessage("Ваш " + drink.name + " готов.");
                } else {
                    Logs.logMessage("Порция " + drink.name + " не была приготовлена");
                    break;
                }
            }
        }
    }
}
