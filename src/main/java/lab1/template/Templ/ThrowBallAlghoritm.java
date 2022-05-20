
package lab1.template.Templ;


public class ThrowBallAlghoritm extends ThrowAlgorithm {

    public ThrowBallAlghoritm(DynamicPaintingPanel panel) {
        super(panel);
    }

    @Override
    protected DrawableShape doCreateShape(int width, int height) {
        Ball ball = new Ball(0, 0);
        ball.setX(width - ball.getWidth());
        ball.setY(height - ball.getHeight());
        return ball;
    }

}
