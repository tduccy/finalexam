public abstract class ShippingDecorator implements ShippingStrategy {
    private ShippingStrategy wrappedStrategy;

    public ShippingDecorator(ShippingStrategy wrappedStrategy) {
        this.wrappedStrategy = wrappedStrategy;
    }

    @Override
    public double calculate(double weight, double distance) {
        return wrappedStrategy.calculate(weight, distance);
    }
}