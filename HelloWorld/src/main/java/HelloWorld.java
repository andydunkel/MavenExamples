import org.apache.commons.lang3.math.NumberUtils;

public class HelloWorld {
    public static void main(String arg[]) {
        var test = NumberUtils.toInt("100");
        System.out.println("Hello World: " + test);
    }
}