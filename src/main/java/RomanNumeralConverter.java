import java.util.HashMap;

public class RomanNumeralConverter {
    public String romanNumeralConvert(int input){
        if(input > 3999 || input < 1){
            return "input out of range (1 - 3,999)";
        }
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
        return convertRN(values, romanNumerals, symbolCounts);
    }


    private int symbolCounter(int input, int value){
        int count = 0;
        while(input >= value){
            count += 1;
            input -= value;
        }
        return count;
    }

    private String convertRN(int[] values, HashMap<Integer, String> numerals, HashMap<String, Integer> counts){
        StringBuilder converted = new StringBuilder();
        for(int i = values.length-1 ; i >= 0 ; i--){
            if(counts.get(numerals.get(values[i])) == 4){
                if(counts.get(numerals.get(values[i-1])) == 1){
                    converted.append(numerals.get(values[i - 2])).append(numerals.get(values[i]));
                    counts.replace(numerals.get(values[i-1]), 0);
                }else{
                    converted.append(numerals.get(values[i - 1])).append(numerals.get(values[i]));
                }
            }else{
                for(int c = counts.get(numerals.get(values[i])); c > 0; c--){
                    converted.append(numerals.get(values[i]));
                }
            }
        }
        converted.reverse();
        return converted.toString();
    }
}