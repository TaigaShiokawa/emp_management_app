package model.test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.RegisterPasswordFlag;

public class RegisterPasswordFlagTest {

	@Test
    public void testPasswordLengthGreaterThan8() {
        RegisterPasswordFlag registerPasswordFlag = new RegisterPasswordFlag("password123");
        assertFalse("8文字以上", registerPasswordFlag.flag);
    }

    @Test
    public void testPasswordLengthLessThan8() {
        RegisterPasswordFlag registerPasswordFlag = new RegisterPasswordFlag("pass");
        assertTrue("8文字未満", registerPasswordFlag.flag);
    }

}
