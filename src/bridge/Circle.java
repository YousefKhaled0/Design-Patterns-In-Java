package bridge;

public class Circle extends Shape {

    public Circle(Renderer renderer) {
        super(renderer);
    }

    @Override
    public void draw() {
        System.out.println(String.format("Drawing %s", renderer.whatToRenderAs()));
    }
}
