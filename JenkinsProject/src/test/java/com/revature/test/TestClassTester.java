package com.revature.test;

import static org.junit.Assert.*;
import org.junit.Test;
public class TestClassTester {
	@Test
	public void test() {
		assertEquals("should return true", true, (new TestClass().test()));
	}

}
