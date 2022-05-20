
package lab1.template.Templ;



public class ThrowSquare extends ThrowShapeAlgorithm {

    public ThrowSquare(DynamicPaintingPanel panel) {
        super(panel);
    }

    @Override
    protected DrawableShape doCreateShape(int width, int height) {
        Square square = new Square(0, 0);
        square.setX(width - square.getWidth());
        square.setY(height - square.getHeight());
        return square;
    }

}
