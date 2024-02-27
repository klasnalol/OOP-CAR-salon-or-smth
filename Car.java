// Product: Car
class Car {
    private int seats;
    private String engine;
    private boolean tripComputer;
    private boolean gps;

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setTripComputer(boolean tripComputer) {
        this.tripComputer = tripComputer;
    }

    public void setGPS(boolean gps) {
        this.gps = gps;
    }

    @Override
    public String toString() {
        return "Car{" +
                "seats=" + seats +
                ", engine='" + engine + '\'' +
                ", tripComputer=" + tripComputer +
                ", gps=" + gps +
                '}';
    }
}

// Product: Manual
class Manual {
    private String seatsManual;
    private String engineManual;
    private String tripComputerManual;
    private String gpsManual;

    public void setSeatsManual(String seatsManual) {
        this.seatsManual = seatsManual;
    }

    public void setEngineManual(String engineManual) {
        this.engineManual = engineManual;
    }

    public void setTripComputerManual(String tripComputerManual) {
        this.tripComputerManual = tripComputerManual;
    }

    public void setGPSManual(String gpsManual) {
        this.gpsManual = gpsManual;
    }

    @Override
    public String toString() {
        return "Manual{" +
                "seatsManual='" + seatsManual + '\'' +
                ", engineManual='" + engineManual + '\'' +
                ", tripComputerManual='" + tripComputerManual + '\'' +
                ", gpsManual='" + gpsManual + '\'' +
                '}';
    }
}

// Builder interface
interface Builder {
    void reset();
    void setSeats(int seats);
    void setEngine(String engine);
    void setTripComputer(boolean tripComputer);
    void setGPS(boolean gps);
}

// Concrete Builder: CarBuilder
class CarBuilder implements Builder {
    private Car car;

    CarBuilder() {
        this.reset();
    }

    public void reset() {
        this.car = new Car();
    }

    public void setSeats(int seats) {
        this.car.setSeats(seats);
    }

    public void setEngine(String engine) {
        this.car.setEngine(engine);
    }

    public void setTripComputer(boolean tripComputer) {
        this.car.setTripComputer(tripComputer);
    }

    public void setGPS(boolean gps) {
        this.car.setGPS(gps);
    }

    public Car getProduct() {
        return this.car;
    }
}

// Concrete Builder: ManualBuilder
class ManualBuilder implements Builder {
    private Manual manual;

    ManualBuilder() {
        this.reset();
    }

    public void reset() {
        this.manual = new Manual();
    }

    public void setSeats(int seats) {
        this.manual.setSeatsManual("Instructions for setting seats: " + seats);
    }

    public void setEngine(String engine) {
        this.manual.setEngineManual("Instructions for setting engine: " + engine);
    }

    public void setTripComputer(boolean tripComputer) {
        this.manual.setTripComputerManual("Instructions for setting trip computer: " + tripComputer);
    }

    public void setGPS(boolean gps) {
        this.manual.setGPSManual("Instructions for setting GPS: " + gps);
    }

    public Manual getProduct() {
        return this.manual;
    }
}

// Director
class Director {
    void constructSportsCar(Builder builder) {
        builder.reset();
        builder.setSeats(2);
        builder.setEngine("SportEngine");
        builder.setTripComputer(true);
        builder.setGPS(true);
    }

    void constructSUV(Builder builder) {
        builder.reset();
        builder.setSeats(5);
        builder.setEngine("SUVEngine");
        builder.setTripComputer(false);
        builder.setGPS(true);
    }
}
