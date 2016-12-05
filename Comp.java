import java.util.Comparator;

/**
 * Created by User on 24.11.2016.
 */
public class Comp implements Comparator<String> {

    @Override
    public int compare(String a, String b) {
        String aStr, bStr;
        aStr=a;
        bStr=b;
        return aStr.compareTo(bStr);
    }
}