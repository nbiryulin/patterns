
package lab1.template.Templ;


public class ThrowShapeThread extends Thread {

    private final ThrowAlgorithm algorithm;

    public ThrowShapeThread(ThrowAlgorithm alg) {
        algorithm = alg;
    }

    @Override
    public void run() {
        algorithm.throwShape();
    }
}
