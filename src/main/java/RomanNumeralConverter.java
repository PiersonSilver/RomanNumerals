import java.util.HashMap;

public class RomanNumeralConverter {
    /*
    I = 1
    V = 5
    X = 10
    L = 50
    C = 100
    D = 500
    M = 1000
     */
    public String romanNumeralConvert(int input){
        if(input > 3999 || input < 1){
            return "input out of range";
        }
        StringBuilder converted = new StringBuilder();
        HashMap<Integer, String> romanNumerals = new HashMap<>()
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
            symbolCounts.put(romanNumerals.get(v), symbolCounter(input, v));
            input -= v * symbolCounter(input, v);
        }
        for(int i = values.length-1 ; i >= 0 ; i--){
            if(symbolCounts.get(romanNumerals.get(values[i])) == 4){
                if(symbolCounts.get(romanNumerals.get(values[i-1])) == 1){
                    converted.append(romanNumerals.get(values[i - 2])).append(romanNumerals.get(values[i]));
                    symbolCounts.replace(romanNumerals.get(values[i-1]), 0);
                }else{
                    converted.append(romanNumerals.get(values[i - 1])).append(romanNumerals.get(values[i]));
                }
            }else{
                for(int c = symbolCounts.get(romanNumerals.get(values[i])); c >0; c--){
                    converted.append(romanNumerals.get(values[i]));
                }
            }
        }
        converted.reverse();
        return converted.toString();
    }
    private int symbolCounter(int input, int value){
        int count = 0;
        while(input >= value){
            count += 1;
            input -= value;
        }
        return count;
    }
}