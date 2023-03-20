package net.dunice;

public enum Drinks {
    CAPPUCCINO("Капучино", 150, 10, 30),
    ESPRESSO("Эспрессо", 140, 15, 0);
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

    public String getName() {
        return name;
    }

    public int getWater() {
        return water;
    }

    public int getCoffee() {
        return coffee;
    }

    public int getMilk() {
        return milk;
    }

    public String getRecipe() {
        return "Название '" + name + '\'' +
                        ", Количество воды = " + water +
                        ", Количество кофе = " + coffee +
                        ", Количество молока = " + milk;
    }
}
