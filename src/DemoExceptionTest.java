import sun.rmi.runtime.Log;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DemoExceptionTest {
    public static void main(String[] args) throws DemoException {
        testException(5);
    }

    public static void testException(int t) throws DemoException {
        Logger.getGlobal().info("guozhichao=>chaozhiguo");
        Logger.getLogger("com.mycompany.myapp").log(Level.WARNING, "Reading image", "adgfawe");
        assert t < 0;
//        if (t > 0) {
//            throw new DemoException();
//        }
    }
}
