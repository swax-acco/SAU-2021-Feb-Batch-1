package calculator;

import java.math.BigDecimal;
import java.util.*;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class calculator {
    public static ScriptEngineManager mgr = new ScriptEngineManager();
    public static ScriptEngine engine = mgr.getEngineByName("JavaScript");
    public static int stringCalculator(String inp) {
        try {
            return (int) Math.ceil(new BigDecimal(engine.eval(inp).toString()).doubleValue());
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static void main(String arg[]) {
        ArrayList<String> input = new ArrayList<String>();
        input.add("-5 + 8 * 6");
        input.add("(55+9)%9");
        input.add("20 + -3 * 5 / 8");
        input.add("5 + 15/3 * 2 - 8 % 3");
        for(int i = 0; i < input.size(); i++)
        System.out.println(stringCalculator(input.get(i)));
    }
}