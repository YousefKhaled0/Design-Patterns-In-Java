package strategy;

class QuadraticEquationSolver {
    private DiscriminantStrategy strategy;

    public QuadraticEquationSolver(DiscriminantStrategy strategy) {
        this.strategy = strategy;
    }

    public Pair<Complex, Complex> solve(double a, double b, double c) {
        double denominator = 2 * a;
        double dis = strategy.calculateDiscriminant(a, b, c);
        if (dis == Double.NaN) {
            return new Pair<>(new Complex(Double.NaN, Double.NaN), new Complex(Double.NaN, Double.NaN));
        } else if (dis < 0) {
            dis = -dis;
            dis = Math.sqrt(dis);
            return new Pair<>(new Complex(-b / denominator, dis / denominator),
                    new Complex(-b / denominator, -dis / denominator));
        } else {
            double numerator1 = -b + Math.sqrt(dis);
            double numerator2 = -b - Math.sqrt(dis);
            return new Pair<>(new Complex(numerator1 / denominator, 0),
                    new Complex(numerator2 / denominator, 0));
        }
    }

    public static void main(String[] args) {
        QuadraticEquationSolver qs = new QuadraticEquationSolver(new RealDiscriminantStrategy());
    }
}
