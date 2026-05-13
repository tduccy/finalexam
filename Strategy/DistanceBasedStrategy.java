package Strategy;

public class DistanceBasedStrategy implements ShippingStrategy{
    @Override
    public double calculate(double weight, double distance){
        return distance * 0.75;
    }
}
