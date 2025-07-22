// Abstract class: Demonstrates Abstraction
abstract class PaymentMethod {
    private String name; // Encapsulation

    // Constructor
    public PaymentMethod(String name) {
        this.name = name;
    }

    // Getter method (Encapsulation)
    public String getName() {
        return name;
    }

    // Abstract method
    public abstract void pay(double amount);
}

// Subclass: CreditCard (Inheritance + Polymorphism)
class CreditCard extends PaymentMethod {
    public CreditCard(String name) {
        super(name);
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card: " + getName());
    }
}

// Subclass: Cash (Inheritance + Polymorphism)
class Cash extends PaymentMethod {
    public Cash(String name) {
        super(name);
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Cash: " + getName());
    }
}

// Main class to test the payment system
public class PaymentSystem {
    public static void main(String[] args) {
        // Polymorphism: PaymentMethod references
        PaymentMethod credit = new CreditCard("Visa");
        PaymentMethod cash = new Cash("Wallet");

        credit.pay(50.0);  // Output: Paid 50.0 using Credit Card: Visa
        cash.pay(20.0);    // Output: Paid 20.0 using Cash: Wallet
    }
}
