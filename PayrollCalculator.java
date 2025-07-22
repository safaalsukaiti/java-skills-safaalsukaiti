public class PayrollCalculator {

    // Method to calculate weekly pay based on employee type and hours
    public static double calculateWeeklyPay(String employeeType, double hoursWorked, double hourlyRate) {
        if (hoursWorked < 0 || hourlyRate < 0 || employeeType == null) {
            System.out.println("invalid input value.");
            return 0.0;
        }

        switch (employeeType.toUpperCase()) {
            case "FULL_TIME":
                if (hoursWorked > 40) {
                    return (40 * hourlyRate) + ((hoursWorked - 40) * hourlyRate * 1.5);
                } else {
                    return hoursWorked * hourlyRate;
                }

            case "PART_TIME":
                if (hoursWorked > 25) hoursWorked = 25;
                return hoursWorked * hourlyRate;

            case "CONTRACTOR":
                return hoursWorked * hourlyRate;

            case "INTERN":
                if (hoursWorked > 20) hoursWorked = 20;
                double discountedRate = hourlyRate * 0.8; // 20% discount
                return hoursWorked * discountedRate;

            default:
                System.out.println(" wrong employee type: " + employeeType);
                return 0.0;
        }
    }

    // Method to calculate tax deduction based on pay brackets
    public static double calculateTaxDeduction(double grossPay, boolean hasHealthInsurance) {
        double tax = 0.0;

        if (grossPay <= 500) {
            tax = grossPay * 0.10;
        } else if (grossPay <= 1000) {
            tax = grossPay * 0.15;
        } else if (grossPay <= 2000) {
            tax = grossPay * 0.20;
        } else {
            tax = grossPay * 0.25;
        }

        if (hasHealthInsurance) {
            tax -= 50;
            if (tax < 0) tax = 0;
        }

        return tax;
    }

    // Method to process multiple employees and find statistics
    public static void processPayroll(String[] employeeTypes, double[] hours, double[] rates, String[] names) {
        int length = Math.min(Math.min(employeeTypes.length, hours.length), Math.min(rates.length, names.length));
        double totalPay = 0;
        double maxPay = Double.MIN_VALUE;
        double minPay = Double.MAX_VALUE;
        String highestPaid = "";
        String lowestPaid = "";
        int overtimeCount = 0;

        System.out.println("\n--- Payroll Report ---");
        System.out.printf("%-10s %-12s %-10s %-10s %-10s %-10s\n", "Name", "Type", "Hours", "Rate", "Gross Pay", "Net Pay");

        for (int i = 0; i < length; i++) {
            double gross = calculateWeeklyPay(employeeTypes[i], hours[i], rates[i]);
            double tax = calculateTaxDeduction(gross, true);
            double net = gross - tax;

            System.out.printf("%-10s %-12s %-10.2f %-10.2f %-10.2f %-10.2f\n", names[i], employeeTypes[i], hours[i], rates[i], gross, net);

            if (gross > maxPay) {
                maxPay = gross;
                highestPaid = names[i];
            }

            if (gross < minPay) {
                minPay = gross;
                lowestPaid = names[i];
            }

            totalPay += gross;

            if (hours[i] > 40 && employeeTypes[i].equalsIgnoreCase("FULL_TIME")) {
                overtimeCount++;
            }
        }

        double avgPay = totalPay / length;
        System.out.println("\n--- Summary ---");
        System.out.println("Highest Paid Employee: " + highestPaid + " ($" + maxPay + ")");
        System.out.println("Lowest Paid Employee: " + lowestPaid + " ($" + minPay + ")");
        System.out.println("Average Gross Pay: $" + avgPay);
        System.out.println("Employees with Overtime: " + overtimeCount);
    }

    public static void main(String[] args) {
        // Test data:
        String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN", "FULL_TIME"};
        double[] hours = {45, 20, 35, 15, 50};
        double[] rates = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve"};

        // Individual test
        System.out.println("Test: Weekly Pay for Alice (Full-time, 45 hrs, $25/hr)");
        double pay = calculateWeeklyPay("FULL_TIME", 45, 25.0);
        System.out.println("Gross Pay: $" + pay);
        double tax = calculateTaxDeduction(pay, true);
        System.out.println("Tax Deduction: $" + tax);
        System.out.println("Net Pay: $" + (pay - tax));

        // Process full payroll
        processPayroll(types, hours, rates, names);
    }
}
