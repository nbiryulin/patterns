
package lab1.template.Templ;




public class ThrowStarAlghoritm extends ThrowAlgorithm {

    public ThrowStarAlghoritm(DynamicPaintingPanel panel) {
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
