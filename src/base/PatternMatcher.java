package base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {
    public static void main(String[] args) {
        Pattern p=Pattern.compile("\\d+");
        Matcher m=p.matcher("22bb23");
        System.out.println(m.matches());
        Matcher m2=p.matcher("2223");
        System.out.println(m2.matches());
    }
}
