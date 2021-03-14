package bridge;

public class Demo {

    public static void main(String[] args) {
        Shape shape = new Circle(new RasterRenderer());
        shape.draw();
        Shape shape1 = new Circle(new VectorRenderer());
        shape1.draw();
    }
}
