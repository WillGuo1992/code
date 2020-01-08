import com.sun.istack.internal.NotNull;

import java.util.*;
import java.util.regex.Pattern;

/**
 * This is a main function <em>Guo</em> zhichao <strong>Is good man</strong>
 * @author Will Guo
 * @version 1.1

 */
public class Main2 {
    private static final String REGX = "^(?=.)M{1,3}?(?:CM\tC?D\tD?C{1,3})?(?:XC\tXL\tL\tL?X{1,3})?(?:IX\tI?V\tV?I{1,3})?$";
    private static final Pattern ROMAN = Pattern.compile("\n" +
            "^(?=.)M{1,3}?(?:CM\tC?D\tD?C{1,3})?(?:XC\tXL\tL\tL?X{1,3})?(?:IX\tI?V\tV?I{1,3})?$\n");

    /**
     * @throws Exception
     * @param s
     * @return boolean
     */
    static boolean isRomanNumber(String s) {
        return ROMAN.matcher(s).matches();
    }

    /**
     *
     * @param args
     */
    public static void main1(String[] args) {
        Date date = new Date();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        System.out.println(year);
    }

    public static void main2(String[] args) {
        Date begin = new Date();
        for (int i = 0; i < 10000; i++) {
            boolean result = isRomanNumber("qwertyuui");
        }

        Date end = new Date();
        System.out.println(end.getTime() - begin.getTime());
        System.out.println("--------");
        begin = new Date();
        for (int i = 0; i < 10000; i++) {
            boolean result = "qwertyuui".matches(REGX);
        }

        end = new Date();
        System.out.println(end.getTime() - begin.getTime());
    }

    public static void main(String[] args) throws InterruptedException {
        Date begin = new Date();
        Long sum = 0L;
        for (Long i = (long)Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
            sum += i;
            Thread.sleep(1000);
        }

        Date end = new Date();
        System.out.println(end.getTime() - begin.getTime());
    }

    public static double max(@NotNull double... args) {
        double minmum = Double.MIN_VALUE;
        for (double data : args) {
            double da = (Double) data;
            if (da > minmum) {
                minmum = da;
            }
        }
        return minmum;

    }

    public static void main4(String[] args) {
        System.out.println(max(123.23,131231,123.123,454,234));
        Size size = Size.SMALL;
    }

    public enum Size {
        SMALL,
        MEDIUM;
    }

}
