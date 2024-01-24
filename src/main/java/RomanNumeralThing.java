import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class RomanNumeralThing {
    public static void main(String[] args) {
        System.out.println(romanNumerals(122));
    }
    /*
    I = 1
    V = 5
    X = 10
    L = 50
    C = 100
    D = 500
    M = 1000
     */
    public static String romanNumerals(int input){
        HashMap<Integer, String> romanNumeralSymbols = new HashMap<Integer, String>()
        {{
            put(1000, "M");
            put(500, "D");
            put(100, "C");
            put(50, "L");
            put(10, "X");
            put(5, "V");
            put(1, "I");

        }};
        String converted = "";
        Set<Integer> nums = romanNumeralSymbols.keySet();
        TreeSet<Integer> sorted = new TreeSet<>(nums);
        for(int value: sorted.descendingSet()){
            String[] idk = convertEach(romanNumeralSymbols, input, value);
            converted += idk[0];
            input = Integer.parseInt(idk[1]);
        }

        return converted;
    }

    public static String[] convertEach(HashMap<Integer, String> symbols, int input, int value){
        String[] output = {"", "", ""};
        int symbolCount = 0;
        while(input >= value){
            symbolCount += 1;
            input -= value;
            output[0] += symbols.get(value);
        }
        output[1] = String.valueOf(input);
        return output;
    }
}
