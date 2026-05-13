package partc;

import parta.*;
import partb.*; 

public class HeavyLoadDecorator extends ShippingDecorator {

    public HeavyLoadDecorator(ShippingStrategy wrappedStrategy) {
        super(wrappedStrategy);
    }

    @Override
    public double calculate(double weight, double distance) {
        return super.calculate(weight, distance) + 15.0;
    }
}