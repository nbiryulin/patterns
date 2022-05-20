
package lab1.template.Templ;


public class ThrowShapeThread extends Thread {

    private final ThrowShapeAlgorithm algorithm;

    public ThrowShapeThread(ThrowShapeAlgorithm alg) {
        algorithm = alg;
    }

    @Override
    public void run() {
        algorithm.throwShape();
    }
}
