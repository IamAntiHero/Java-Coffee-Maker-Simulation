public class CoffeeMakerApp {
    public static void main(String[] args) {
        CoffeeMaker coffeeMaker = new CoffeeMaker("HomeBrew 3000", 1000);
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        boolean running = true;
        
        System.out.println("Welcome to Coffee Maker Console Application!");
        
        while (running) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Turn ON");
            System.out.println("2. Turn OFF");
            System.out.println("3. Fill Water Tank");
            System.out.println("4. Set Coffee Strength");
            System.out.println("5. Brew Coffee");
            System.out.println("6. Show Status");
            System.out.println("7. Exit");
            System.out.print("Your choice: ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (choice) {
                    case 1:
                        coffeeMaker.turnOn();
                        break;
                        
                    case 2:
                        coffeeMaker.turnOff();
                        break;
                        
                    case 3:
                        System.out.print("Enter amount in ml: ");
                        int amount = scanner.nextInt();
                        scanner.nextLine();
                        coffeeMaker.fillWater(amount);
                        break;
                        
                    case 4:
                        System.out.print("Enter coffee strength (mild, medium, strong): ");
                        String strength = scanner.nextLine();
                        coffeeMaker.setCoffeeStrength(strength);
                        break;
                        
                    case 5:
                        coffeeMaker.operate();
                        break;
                        
                    case 6:
                        coffeeMaker.showStatus();
                        break;
                        
                    case 7:
                        System.out.println("Thank you for using the Coffee Maker App!");
                        running = false;
                        break;
                        
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                
            } catch (java.util.InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                scanner.nextLine(); 
            }
        }
        
        scanner.close();
    }
}