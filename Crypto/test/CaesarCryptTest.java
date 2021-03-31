import org.junit.Test;

import static org.junit.Assert.*;

public class CaesarCryptTest {

    @Test
    public void rotateStringTest0() {
        // Given
        String s1 = "ABCDEF";
        String s2 = "ABCDEF";

        // When
        CaesarCrypt cipher = new CaesarCrypt();
        String actual = cipher.rotate(s1, 'A');

        // Then
        assertTrue(actual.equals(s2));
    }

    @Test
    public void rotateStringTest1() {
        // Given
        String s1 = "ABCDEF";
        String s2 = "DEFABC";

        // When
        CaesarCrypt cipher = new CaesarCrypt();
        String actual = cipher.rotate(s1, 'D');

        // Then
        assertTrue(actual.equals(s2));
    }

    @Test
    public void rotateStringTest2() {
        // Given
        String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s2 = "NOPQRSTUVWXYZABCDEFGHIJKLM";

        // When
        CaesarCrypt cipher = new CaesarCrypt();
        String actual = cipher.rotate(s1, 'N');
        System.out.println(s1);
        System.out.println(actual);
        // Then
        assertTrue(actual.equals(s2));
    }

    @Test
    public void cryptTest1() {
        // Given
        CaesarCrypt cipher = new CaesarCrypt();

        String Q1 = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
        String A1 = "QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD";

        String Q2 = "QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD";
        String A2 = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";

        // When
        String actual = cipher.encrypt(Q1);
        System.out.println(Q1);
        System.out.println(A1);
        // Then
        assertTrue(actual.equals(A1));

        // When
        String actual2 = cipher.decrypt(Q2);
        System.out.println(Q2);
        System.out.println(A2);
        // Then
        assertTrue(actual2.equals(A2));
    }
    @Test
    public void cryptTest2() {
        // Given
        CaesarCrypt cipher = new CaesarCrypt();

        String Q1 = "Why did the chicken cross the road?";
        System.out.println(Q1);

        // When
        String actual = cipher.decrypt(cipher.encrypt(Q1));
        System.out.println(actual);
        // Then
        assertTrue(actual.equals(Q1));
    }

}