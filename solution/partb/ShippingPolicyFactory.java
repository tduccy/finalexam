import parta.*;

public class ShippingPolicyFactory {

    public static ShippingStrategy getStrategy(String type, double weight) {

        ShippingStrategy strategy;

        if (type.equals("Flat Rate")) {
            strategy = new FlatRateStrategy();

        } else if (type.equals("Weight-Based")) {
            strategy = new WeightBasedStrategy();

        } else if (type.equals("Distance-Based")) {
            strategy = new DistanceBasedStrategy();

        } else {
            strategy = new CarrierSpecificStrategy();
        }

        // Decorator Pattern
        if (weight > 20) {
            strategy = new HeavyLoadDecorator(strategy);
        }

        return strategy;
    }
}