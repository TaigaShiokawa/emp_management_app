package model.test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.LoginpageFlag;

public class LoginpageFlagTest {

	@Test
	public void postNumberGreaterThan2() {
		LoginpageFlag loginFlag = new LoginpageFlag(3);
		assertTrue("係長以上", loginFlag.flag);
	}
	@Test
	public void postNumberLessThan2() {
		LoginpageFlag loginFlag = new LoginpageFlag(2);
		assertFalse("係長未満", loginFlag.flag);
	}
}
