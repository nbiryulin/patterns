
package lab1.template.Templ;



public abstract class ThrowShapeAlgorithm {

    protected DrawableShape shape = null;
    protected DynamicPaintingPanel panel = null;

    private int dx = -1;
    private int dy = -1;

    private int x = 0;
    private int y = 0;

    public ThrowShapeAlgorithm(DynamicPaintingPanel panel) {
        this.panel = panel;
    }

    public void throwShape() {
        int width = panel.getDimention().width;
        int height = panel.getDimention().height;

        shape = doCreateShape(width, height);
        addShapeToPanel();
        x = shape.getX();
        y = shape.getY();

        Side touchingSide;

        while (true) {
            updateCoordinates();
            updateShape();

            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                System.out.print(ex.getMessage());
            }

            touchingSide = getTouchingSide();
            if (touchingSide != Side.NO_SIDE) {
                updateMovement(touchingSide);
            }
        }
    }

    protected abstract DrawableShape doCreateShape(int width, int height);

    protected void addShapeToPanel() {
        panel.addShape(shape);
    }

    protected Side getTouchingSide() {
        int width = panel.getDimention().width;
        int height = panel.getDimention().height;

        if (x == 0) {
            if (y == 0) {
                return Side.TOPLEFT;
            }
            if (y == height - shape.getHeight()) {
                return Side.BOTTOMLEFT;
            }
            return Side.LEFT;
        }
        if (y == 0) {
            if (x == width - shape.getWidth()) {
                return Side.TOPRIGHT;
            }
            return Side.TOP;
        }
        if (x == width - shape.getWidth()) {
            if (y == height - shape.getHeight()) {
                return Side.BOTTOMRIGHT;
            }
            return Side.RIGHT;
        }
        if (y == height - shape.getHeight()) {
            return Side.BOTTOM;
        }

        return Side.NO_SIDE;
    }

    protected void updateCoordinates() {
        x = x + dx;
        y = y + dy;
    }

    protected void updateShape() {
        shape.setX(x);
        shape.setY(y);
        panel.revalidate();
        panel.repaint();
    }

    protected void updateMovement(Side side) {
        if ((side == Side.BOTTOM) || (side == Side.TOP)) {
            dy = -1 * dy;
        } else if ((side == Side.LEFT) || (side == Side.RIGHT)) {
            dx = -1 * dx;
        } else {
            dx = -1 * dx;
            dy = -1 * dy;
        }
    }
}
