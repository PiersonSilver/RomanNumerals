import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RomanNumeralConverterTest {
    RomanNumeralConverter test = new RomanNumeralConverter();
    @Test
    public void romanNumeralTest185(){
        int input = 185;
        Assertions.assertEquals("CLXXXV", test.romanNumeralConvert(input));
    }
    @Test
    public void romanNumeralOutOfRangeTest(){
        int input = 4000;
        Assertions.assertEquals("input out of range (1 - 3,999)", test.romanNumeralConvert(input));
    }
    @Test
    public void romanNumeralTest9(){
        int input = 9;
        Assertions.assertEquals("IX", test.romanNumeralConvert(input));
    }
    @Test
    public void romanNumeralTest4(){
        int input = 4;
        Assertions.assertEquals("IV", test.romanNumeralConvert(input));
    }
    @Test
    public void romanNumeralTest3999(){
        int input = 3999;
        Assertions.assertEquals("MMMCMXCIX", test.romanNumeralConvert(input));
    }
}