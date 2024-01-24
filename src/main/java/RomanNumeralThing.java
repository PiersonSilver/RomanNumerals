import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class RomanNumeralThing {
    public static void main(String[] args) {
        System.out.println(romanNumerals2(429));
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
    public static String romanNumerals2(int input){
        StringBuilder converted = new StringBuilder();
        HashMap<Integer, String> romanNumeralSymbols = new HashMap<>()
        {{
            put(1000, "M");
            put(500, "D");
            put(100, "C");
            put(50, "L");
            put(10, "X");
            put(5, "V");
            put(1, "I");
        }};

        HashMap<String, Integer> symbolCounts = new HashMap<>();

        int[] values = {1000, 500, 100, 50, 10, 5, 1};
        for(int v : values){
            symbolCounts.put(romanNumeralSymbols.get(v), convert(input, v));
            input -= v * convert(input, v);
        }
        System.out.println(symbolCounts);
        for(int i = values.length-1 ; i >= 0 ; i--){
            if(symbolCounts.get(romanNumeralSymbols.get(values[i])) == 4){
                if(symbolCounts.get(romanNumeralSymbols.get(values[i-1])) == 1){
                    converted.append(romanNumeralSymbols.get(values[i-2]) + romanNumeralSymbols.get(values[i]));
                    symbolCounts.replace(romanNumeralSymbols.get(values[i-1]), 0);
                }else{
                    converted.append(romanNumeralSymbols.get(values[i-1]) + romanNumeralSymbols.get(values[i]));
                }
            }else{
                for(int c = symbolCounts.get(romanNumeralSymbols.get(values[i])); c >0; c--){
                    converted.append(romanNumeralSymbols.get(values[i]));
                }
            }
        }
        System.out.println(symbolCounts);
        converted.reverse();
        return converted.toString();
    }
    public static int convert(int input, int value){
        int count = 0;
        while(input >= value){
            count += 1;
            input -= value;
        }
        return count;
    }
    public static String romanNumerals(int input){
        HashMap<Integer, String> romanNumeralSymbols = new HashMap<>()
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
        if(converted.contains("VIIII")){
            converted = converted.replace("VIIII", "IX");
        }
        if(converted.contains("IIII")){
            converted = converted.replace("IIII", "IV");
        }
        if(converted.contains("LXXXX")){
            converted = converted.replace("LXXXX", "XC");
        }
        if(converted.contains("XXXX")){
            converted = converted.replace("XXXX", "XL");
        }
        if (converted.contains("DCCCC")){
            converted = converted.replace("DCCCC", "CM");
        }
        if (converted.contains("CCCC")){
            converted = converted.replace("CCCC", "CD");
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
