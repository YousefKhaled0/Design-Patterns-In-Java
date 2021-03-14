package adapter;

public class SquareToRectangleAdapter implements Rectangle {

    private Square square;

    public SquareToRectangleAdapter(Square square)
    {
        this.square = square;
    }

    @Override
    public int getWidth() {
        return square.getSide();
    }

    @Override
    public int getHeight() {
        return square.getSide();
    }

    @Override
    public int getArea() {
        return square.getSide() * square.getSide();
    }

    public static void main(String[] args) {
        Square square = new Square(10);
        SquareToRectangleAdapter squareToRectangleAdapter = new SquareToRectangleAdapter(square);
        System.out.println(squareToRectangleAdapter.getArea());
        System.out.println(squareToRectangleAdapter.getHeight());
        System.out.println(squareToRectangleAdapter.getWidth());
    }
}
