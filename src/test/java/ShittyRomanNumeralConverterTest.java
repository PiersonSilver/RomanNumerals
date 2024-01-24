import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShittyRomanNumeralConverterTest {
    ShittyRomanNumeralConverter poopTest = new ShittyRomanNumeralConverter();
    @Test
    public void shitTest3999(){
        int input = 3999;
        Assertions.assertEquals("MMMCMXCIX", poopTest.shittyRomanNumeralConvert(input));
    }
    @Test
    public void shitTest9(){
        int input = 9;
        Assertions.assertEquals("IX", poopTest.shittyRomanNumeralConvert(input));
    }
}