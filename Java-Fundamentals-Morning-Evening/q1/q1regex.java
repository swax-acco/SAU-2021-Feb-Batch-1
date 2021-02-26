package q1;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class q1regex {
    public static void matchNReplace(String regex, String replacement, String str){
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        str = matcher.replaceAll(replacement);
        System.out.println(str);
    }
    public static void main(String[] args) {
        matchNReplace("abc", "xyz","abcdefghabcijklabc");
    }
}
