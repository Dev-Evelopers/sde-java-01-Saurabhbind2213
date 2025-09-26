import java.util.*;
public class JavaQuesstion_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc. nextInt();
        System.out.println("Testing Addition");
        Adder adder = new Adder();
        int sum = adder.add(a, b);
        System.out.println("Sum ="+ sum);
        
        System.out.println("Testing Multiplication");
        Multiplier multipler = new Multiplier();
        int product = multipler.multiply(a, b, adder);
        System.out.println("Product ="+ product);
        sc.close();

        
    }
}

class Adder {
    public int add(int x, int y) {
        return x + y;
    }
}

class Multiplier {
    public int multiply(int x, int y, Adder adder) {
        int result = 0;
        for (int i = 0; i < y; i++) {
            result = adder.add(result, x);
        }
        return result;
    }
}
