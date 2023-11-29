/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JOptionPane;

public class Store {
    public static void main(String[] args) {
        
        String[] products = {"Earphones - $10.0", "Airpods pro - $20.0", "Airpods - $15.0", "Headphones - $25.0", "Smart Watch - $30.0"};
        double[] prices = {10.0, 20.0, 15.0, 25.0, 30.0};

        while (true) {
            double totalCost = 0.0;
            int uniqueProductCount = 0;
            boolean[] isProductSelected = new boolean[products.length]; 
            StringBuilder[] boughtProducts = new StringBuilder[products.length]; 
            for (int i = 0; i < products.length; i++) {
                boughtProducts[i] = new StringBuilder();
            }

            while (true) {
               
                String selectedProduct = (String) JOptionPane.showInputDialog(null,
                        "Select a product:",
                        "Mini Store",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        products,
                        products[0]);

                String quantityString = JOptionPane.showInputDialog(null,
                        "Enter quantity:",
                        "Mini Store",
                        JOptionPane.QUESTION_MESSAGE);

                int quantity = Integer.parseInt(quantityString);

                int productIndex = java.util.Arrays.asList(products).indexOf(selectedProduct);
                double itemPrice = prices[productIndex] * quantity;

                totalCost += itemPrice;

                boughtProducts[productIndex].append(selectedProduct).append(" x").append(quantity).append("\n");

                if (!isProductSelected[productIndex]) {
                    isProductSelected[productIndex] = true;
                    uniqueProductCount++;
                }

                int continueShopping = JOptionPane.showConfirmDialog(null,
                        "Do you want to buy more items?",
                        "Mini Store",
                        JOptionPane.YES_NO_OPTION);

                if (continueShopping != JOptionPane.YES_OPTION) {
                    break; 
                }
            }

            double discount = (uniqueProductCount >= 3) ? 0.1 : 0.0;
            double discountedTotal = totalCost - (totalCost * discount);

            while (true) {
               
                String cashString = JOptionPane.showInputDialog(null,
                        "Enter the amount of cash you have:",
                        "Mini Store",
                        JOptionPane.QUESTION_MESSAGE);

                double cash = Double.parseDouble(cashString);

                double change = cash - discountedTotal;

                if (cash >= discountedTotal) {
                    
                    StringBuilder receiptMessage = new StringBuilder("Bought Products:\n");
                    for (StringBuilder product : boughtProducts) {
                        if (product.length() > 0) {
                            receiptMessage.append(product);
                        }
                    }

                    receiptMessage.append("\nTotal Cost: $").append(totalCost)
                            .append("\nDiscount Applied: ").append((discount * 100)).append("%")
                            .append("\nDiscounted Total: $").append(discountedTotal)
                            .append("\nCash: $").append(cash)
                            .append("\nChange: $").append(change);

                    JOptionPane.showMessageDialog(null,
                            receiptMessage.toString(),
                            "Mini Store - Receipt",
                            JOptionPane.INFORMATION_MESSAGE);

                    break;
                } else {
                  
                    JOptionPane.showMessageDialog(null,
                            "Insufficient cash. Please enter a higher amount.",
                            "Mini Store - Insufficient Cash",
                            JOptionPane.WARNING_MESSAGE);
                }
            }

            int continueShopping = JOptionPane.showConfirmDialog(null,
                    "Do you want to make another purchase?",
                    "Mini Store",
                    JOptionPane.YES_NO_OPTION);

            if (continueShopping != JOptionPane.YES_OPTION) {
                break; 
            }
        }
    }
}

