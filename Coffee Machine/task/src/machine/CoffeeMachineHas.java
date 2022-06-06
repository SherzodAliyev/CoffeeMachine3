package machine;

import java.util.Scanner;

public class CoffeeMachineHas {

    private int hasWater = 400;
    private int hasMilk = 540;
    private int hasBeans = 120;
    private int hasDisposableCups = 9;
    private int hasMoney = 550;

    public int getHasWater() {
        return hasWater;
    }

    public void setHasWater(int hasWater) {
        this.hasWater = hasWater;
    }

    public int getHasMilk() {
        return hasMilk;
    }

    public void setHasMilk(int hasMilk) {
        this.hasMilk = hasMilk;
    }

    public int getHasBeans() {
        return hasBeans;
    }

    public void setHasBeans(int hasBeans) {
        this.hasBeans = hasBeans;
    }

    public int getHasDisposableCups() {
        return hasDisposableCups;
    }

    public void setHasDisposableCups(int hasDisposableCups) {
        this.hasDisposableCups = hasDisposableCups;
    }

    public int getHasMoney() {
        return hasMoney;
    }

    public void setHasMoney(int hasMoney) {
        this.hasMoney = hasMoney;
    }

    public void buy(String typeOfCoffee) {
        switch(typeOfCoffee) {
            case "1": // espresso 250 water, 16 beans, 4$
                this.hasWater -= 250;
                this.hasBeans -= 16;
                this.hasMoney += 4;
                this.hasDisposableCups--;
                break;
            case "2": // latte 350 water, 75 milk, 20 beans, 7$
                this.hasWater -= 350;
                this.hasMilk -= 75;
                this.hasBeans -= 20;
                this.hasMoney += 7;
                this.hasDisposableCups--;
                break;
            case "3": // cappucino 200 water, 100 milk, 12 beans, 6$
                this.hasWater -= 200;
                this.hasMilk -= 100;
                this.hasBeans -= 12;
                this.hasMoney += 6;
                this.hasDisposableCups--;
                break;
        }
    }

    public void fill() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        this.hasWater += scan.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        this.hasMilk += scan.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        this.hasBeans += scan.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        this.hasDisposableCups += scan.nextInt();
    }

    public void take() {
        System.out.printf("I gave you $%d", this.hasMoney);
        this.hasMoney = 0;
    }
}
