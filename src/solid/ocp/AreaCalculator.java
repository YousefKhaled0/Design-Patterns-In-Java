package solid.ocp;

public class AreaCalculator { // Easy to add new shapes no need for modifications.
    public double Area(Shape[] shapes) {
        double area = 0;
        for (Shape shape : shapes) {
            area += shape.area();
        }
        return area;
    }
}
