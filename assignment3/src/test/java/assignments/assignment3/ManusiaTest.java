package assignments.assignment3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ManusiaTest {
    @Test
    public void testTambahSembuh(){
        Ojol ojol = new Ojol("KangJek");
        
        ojol.tambahSembuh();

        assertEquals(1, Manusia.getJumlahSembuh());
    }
}