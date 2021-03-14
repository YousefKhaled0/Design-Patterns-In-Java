package strategy;

public class RealDiscriminantStrategy implements DiscriminantStrategy {
    @Override
    public double calculateDiscriminant(double a, double b, double c) {
        double dis = (b * b) - (4 * a * c);
        return dis < 0 ? Double.NaN : dis;
    }
}
