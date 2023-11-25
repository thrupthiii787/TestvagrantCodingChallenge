package TestVargant;

import java.util.ArrayList;

class Product {
    String name;
    double unitPrice;
    double gstPercentage;
    int quantity;

    public Product(String name, double unitPrice, double gstPercentage, int quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.gstPercentage = gstPercentage;
        this.quantity = quantity;
    }

    public double calculateTotalPrice() {
        return unitPrice * quantity;
    }

    public double calculateGSTAmount() {
        return calculateTotalPrice() * (gstPercentage / 100.0);
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        // Create products in the basket
        ArrayList<Product> basket = new ArrayList<>();
        basket.add(new Product("Leather Wallet", 1100, 18, 1));
        basket.add(new Product("Umbrella", 900, 12, 4));
        basket.add(new Product("Cigarette", 200, 28, 3));
        basket.add(new Product("Honey", 100, 0, 2));

        // Problem 1: Identify the product with the maximum GST amount
        Product maxGSTProduct = basket.get(0);
        double maxGSTAmount = maxGSTProduct.calculateGSTAmount();

        for (Product product : basket) {
            double currentGSTAmount = product.calculateGSTAmount();
            if (currentGSTAmount > maxGSTAmount) {
                maxGSTAmount = currentGSTAmount;
                maxGSTProduct = product;
            }
        }

        System.out.println("Product with Maximum GST Amount: " + maxGSTProduct.name);

        // Problem 2: Calculate the total amount to be paid to the shopkeeper
        double totalAmountToPay = 0;
        for (Product product : basket) {
            totalAmountToPay += product.calculateTotalPrice();
        }

        System.out.println("Total Amount to be Paid: " + totalAmountToPay);
    }
}