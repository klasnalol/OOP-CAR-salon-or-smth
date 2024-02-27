import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("specific car with specific parts? yes/no");
        String choice = scanner.nextLine().toLowerCase();

        if (choice.equals("yes")) {
            buildSpecificCar(scanner);
        } else if (choice.equals("no")) {
            useDirector();
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    private static void buildSpecificCar(Scanner scanner) {
        CarBuilder carBuilder = new CarBuilder();

        System.out.print("number of seats ");
        int seats = scanner.nextInt();
        carBuilder.setSeats(seats);

        scanner.nextLine(); // consume newline
        System.out.print("engine ");
        String engine = scanner.nextLine();
        carBuilder.setEngine(engine);

        System.out.print("trip computer? true/false ");
        boolean tripComputer = scanner.nextBoolean();
        carBuilder.setTripComputer(tripComputer);

        System.out.print("GPS? true/false ");
        boolean gps = scanner.nextBoolean();
        carBuilder.setGPS(gps);

        Car car = carBuilder.getProduct();
        System.out.println("Your specific car: " + car);
    }

    private static void useDirector() {
        System.out.println("Building pre-made cars using the Director...");

        Director director = new Director();

        CarBuilder carBuilder = new CarBuilder();
        director.constructSportsCar(carBuilder);
        Car sportsCar = carBuilder.getProduct();
        System.out.println("Sports Car: " + sportsCar);

        ManualBuilder manualBuilder = new ManualBuilder();
        director.constructSUV(manualBuilder);
        Manual suvManual = manualBuilder.getProduct();
        System.out.println("SUV Manual: " + suvManual);
    }
}
