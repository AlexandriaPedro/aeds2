import java.util.*;
import javax.script.*;

public class tp01q05 {
    public static boolean evaluateExpression(String expression, Map<String, Boolean> variables) throws ScriptException {
        /*
        * Evaluates a boolean expression using the provided variable values.
        */
        for (Map.Entry<String, Boolean> entry : variables.entrySet()) {
            expression = expression.replace(entry.getKey(), entry.getValue().toString());
        }

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
        
        return (Boolean) engine.eval(expression);
    }

    public static void main(String[] args) throws Exception {
        /*
        * Main method to read input, evaluate boolean expressions, and output results.
        */
        String line = MyIO.readLine();
        while (line != null && !line.isEmpty()) {
            String[] parts = line.trim().split("\\s+", 2);
            int n = Integer.parseInt(parts[0]);
            String[] inputs = parts[1].split(" ", n + 1);

            Map<String, Boolean> variables = new HashMap<>();

            for (int i = 0; i < n; i++) {
                variables.put(Character.toString((char) ('A' + i)), inputs[i].equals("1"));
            }

            boolean result = evaluateExpression(inputs[n], variables);
            MyIO.println(result ? "SIM" : "NÃO");
            
            line = MyIO.readLine();
        }
    }
}
