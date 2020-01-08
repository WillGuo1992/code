import java.net.InetAddress;
import java.net.UnknownHostException;

public class InterAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        String host = "www.google.com";
        InetAddress[] addresses = InetAddress.getAllByName(host);
        for (InetAddress ad : addresses) {
            System.out.println(ad.toString());
        }


    }
}
