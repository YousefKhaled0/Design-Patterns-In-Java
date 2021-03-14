package facade;

public class ShapeMaker {
    private Square square;
    private Circle circle;
    private Rectangle rectangle;

    public ShapeMaker() {
        square = new Square();
        circle = new Circle();
        rectangle = new Rectangle();
    }

    void drawCircle() {
        circle.draw();
    }

    void drawSquare() {
        square.draw();
    }

    void drawRectangle(){
        rectangle.draw();
    }

    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }

}
