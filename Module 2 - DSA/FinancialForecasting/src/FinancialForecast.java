public class FinancialForecast {

    static double predictFutureValue(double currentValue,double growthRate,int years) {

        if (years == 0)
            return currentValue;

        return predictFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {

        double futureValue = predictFutureValue(10000, 0.10, 5);

        System.out.println("Future Value = " + futureValue);
    }
}