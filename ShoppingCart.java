public class ShoppingCart {


    public static double calculateTotal(double[] prices, String customerType) {
        double total = 0;


        for (double price : prices) {
            total += price;
        }


        switch (customerType.toUpperCase()) {
            case "PREMIUM":
                total *= 0.90;
                break;
            case "VIP":
                total *= 0.80;
                break;
            case "REGULAR":

                break;
            default:
                System.out.println("Unknown customer type. No discount applied.");
        }

        return total;
    }


    public static double findMostExpensive(double[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        double max = prices[0];
        for (double price : prices) {
            if (price > max) {
                max = price;
            }
        }
        return max;
    }
}