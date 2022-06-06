package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CoffeeMachineHas inMachine = new CoffeeMachineHas();
        actions(inMachine);
    }

    public static void actions(CoffeeMachineHas machine) {
        String choosenAction = "";
        boolean isContinue = true;
        while (isContinue) {
            System.out.println("Write action (buy, fill, take):");
            choosenAction = scanner.next();
            switch (choosenAction) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    String type = scanner.next();
                    if (canBuy(machine, type)) {
                        machine.buy(type);
                        System.out.println("I have enough resources, making you a coffee!");
                    }
                    break;
                case "fill":
                    machine.fill();
                    break;
                case "take":
                    machine.take();
                    break;
                case "remaining":
                    displayMachine(machine);
                    break;
                case "exit":
                    isContinue = false;
                    break;
            }
        }
    }

    public static void displayMachine(CoffeeMachineHas machine) {
        System.out.printf("The coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money\n\n", machine.getHasWater(), machine.getHasMilk(), machine.getHasBeans(),
                machine.getHasDisposableCups(), machine.getHasMoney());
    }

    public static boolean canBuy(CoffeeMachineHas machine, String str) {
        switch(str) {
            case "to main menu":
                return false;
            case "1": // espresso 250 water, 16 beans, 4$
                if (machine.getHasWater() < 250 && machine.getHasBeans() < 16) {
                    System.out.println("Sorry, not enough water and coffee beans!");
                    return false;
                } else if (machine.getHasWater() < 250) {
                    System.out.println("Sorry, not enough water!");
                    return false;
                } else if (machine.getHasBeans() < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                    return false;
                }
                return true;
            case "2": // latte 350 water, 75 milk, 20 beans, 7$
                return enoughResources(machine, 350, 75, 20);
            case "3": // cappucino 200 water, 100 milk, 12 beans, 6$
                return enoughResources(machine, 200, 100, 12);
        }
        return true;
    }

    public static boolean enoughResources(CoffeeMachineHas machine, int wat, int milk, int beans) {
        boolean notWater = machine.getHasWater() < wat;
        boolean notMilk = machine.getHasMilk() < milk;
        boolean notBeans = machine.getHasBeans() < beans;
        if (notWater && notMilk && notBeans) {
            System.out.println("Sorry, not enough water, milk and coffee beans!");
            return false;
        } else if (notWater && notMilk) {
            System.out.println("Sorry, not enough water and milk!");
            return false;
        } else if (notWater && notBeans) {
            System.out.println("Sorry, not enough water and coffee beans!");
            return false;
        } else if (notMilk && notBeans) {
            System.out.println("Sorry, not enough milk and coffee beans!");
            return false;
        } else if (notWater) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (notMilk) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (notBeans) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }
        return true;
    }
}
