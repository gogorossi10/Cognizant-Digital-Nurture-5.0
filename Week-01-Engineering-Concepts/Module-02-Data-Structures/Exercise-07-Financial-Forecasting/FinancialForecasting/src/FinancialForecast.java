public class FinancialForecast {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {

        if (years == 0) {
            return presentValue;
        }

        return (1 + growthRate) * calculateFutureValue(presentValue, growthRate, years - 1);
    }

}