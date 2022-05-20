package lab1.template.Templ;

import java.awt.*;
import java.awt.geom.Ellipse2D;


public class Ball implements DrawableShape {

    private final int width, height;
    private int x, y;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        width = 30;
        height = 30;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(x, y, width, height);

        g2d.setColor(Color.CYAN);
        g2d.fill(circle);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int value) {
        x = value;
    }

    @Override
    public void setY(int value) {
        y = value;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
