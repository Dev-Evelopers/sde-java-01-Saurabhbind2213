import java.util.*;
// Abstract class
abstract class Car {
    protected boolean isSedan;
    protected String seats;

    public Car(boolean isSedan, String seats) {
        this.isSedan = isSedan;
        this.seats = seats;
    }

    public boolean getIsSedan() {
        return isSedan;
    }

    public String getSeats() {
        return seats;
    }

    public abstract String getMileage();
}

// WagonR class
class WagonR extends Car {
    private int mileage;

    public WagonR(int mileage) {
        super(false, "4");  // WagonR is not sedan and has 4 seats
        this.mileage = mileage;
    }

    @Override
    public String getMileage() {
        return mileage + " kmpl";
    }
}

// HondaCity class
class HondaCity extends Car {
    private int mileage;

    public HondaCity(int mileage) {
        super(true, "4"); // HondaCity is sedan and has 4 seats
        this.mileage = mileage;
    }

    @Override
    public String getMileage() {
        return mileage + " kmpl";
    }
}

// InnovaCrysta class
class InnovaCrysta extends Car {
    private int mileage;

    public InnovaCrysta(int mileage) {
        super(false, "6"); // InnovaCrysta is not sedan and has 6 seats
        this.mileage = mileage;
    }

    @Override
    public String getMileage() {
        return mileage + " kmpl";
    }
}

// Main class
public class JavaQuesstion_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int carType = sc.nextInt();  // 0 for WagonR, 1 for HondaCity, 2 for InnovaCrysta
        int mileage = sc.nextInt();  // mileage input
        sc.close();

        Car car = null;

        switch (carType) {
            case 0:
                car = new WagonR(mileage);
                System.out.print("A WagonR is ");
                break;
            case 1:
                car = new HondaCity(mileage);
                System.out.print("A HondaCity is ");
                break;
            case 2:
                car = new InnovaCrysta(mileage);
                System.out.print("An InnovaCrysta is ");
                break;
            default:
                System.out.println("Invalid car type");
                return;
        }

        System.out.println((car.getIsSedan() ? "Sedan" : "not Sedan") +
                           ", is " + car.getSeats() + "-seater, and has a mileage of around " +
                           car.getMileage() + ".");
    }
}

    

