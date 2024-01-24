import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class ShittyRomanNumeralConverter {
    public String shittyRomanNumeralConvert(int input){
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

    public String[] convertEach(HashMap<Integer, String> symbols, int input, int value){
        String[] output = {"", ""};
        while(input >= value){
            input -= value;
            output[0] += symbols.get(value);
        }
        output[1] = String.valueOf(input);
        return output;
    }
}
