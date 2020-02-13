package assignment1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HammingCodeTest {
    @Test public void testEncodeSample1() {
        HammingCode hammingCode = new HammingCode();
        assertEquals(hammingCode.encode("10011010"), "011100101010");
    }
    
    @Test public void testEncodeSample2() {
        HammingCode hammingCode = new HammingCode();
        assertEquals(hammingCode.encode("1011001"), "10100111001");
    }
    
    @Test public void testDecodeSample1() {
        HammingCode hammingCode = new HammingCode();
        assertEquals(hammingCode.decode("011100101110"), "10011010");
    }
    
    @Test public void testDecodeSample2() {
        HammingCode hammingCode = new HammingCode();
        assertEquals(hammingCode.decode("01110110101"), "1001101");
    }
    
    @Test public void testEncodeZero() {
        HammingCode hammingCode = new HammingCode();
        assertEquals(hammingCode.encode("0"), "000");
    }
    
    @Test public void testEncodeOne() {
        HammingCode hammingCode = new HammingCode();
        assertEquals(hammingCode.encode("1"), "111");
    }
    
    @Test public void testEncodeLengthPowerOfTwo() {
        HammingCode hammingCode = new HammingCode();
        assertEquals(hammingCode.encode("1101"), "1010101");
    }
    
    @Test public void testEncodeRandom() {
        HammingCode hammingCode = new HammingCode();
        assertEquals(hammingCode.encode("00110"), "100001100");
    }
    
    @Test public void testEncodeLongLength() {
        HammingCode hammingCode = new HammingCode();
        assertEquals(hammingCode.encode("011010111011101"), "00001101101110111101");
    }
    
    @Test public void testDecodeToLengthOne() {
        HammingCode hammingCode = new HammingCode();
        assertEquals(hammingCode.decode("000"), "0");
    }
    
    @Test public void testDecodeToLengthOneWithErrorAtR() {
        HammingCode hammingCode = new HammingCode();
        assertEquals(hammingCode.decode("101"), "1");
    }
    
    @Test public void testDecodeToLengthPowerOfTwo() {
        HammingCode hammingCode = new HammingCode();
        assertEquals(hammingCode.decode("1010101"), "1101");
    }
    
    @Test public void testDecodeWithErrorAtData() {
        HammingCode hammingCode = new HammingCode();
        assertEquals(hammingCode.decode("00001101101110111101"), "011010111011101");
    }
}
