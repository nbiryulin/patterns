
package lab1.template.Templ;

import java.awt.*;

public interface DrawableShape {

    int getX();

    int getY();

    void setX(int value);

    void setY(int value);

    int getWidth();

    int getHeight();

    void draw(Graphics g);
}
