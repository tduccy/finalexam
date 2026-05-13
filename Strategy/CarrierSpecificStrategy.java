package Strategy;

public class CarrierSpecificStrategy implements ShippingStrategy{
    @Override
    public double calculate(double weight, double distance){
        return (weight * 2) + (distance * 0.5) + 15;
    }
}
