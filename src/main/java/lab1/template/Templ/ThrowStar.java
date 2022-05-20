
package lab1.template.Templ;




public class ThrowStar extends ThrowShapeAlgorithm {

    public ThrowStar(DynamicPaintingPanel panel) {
        super(panel);
    }

    @Override
    protected DrawableShape doCreateShape(int width, int height) {
        Star star = new Star(0, 0);
        star.setX(width - star.getWidth());
        star.setY(height - star.getHeight());
        return star;
    }

}
