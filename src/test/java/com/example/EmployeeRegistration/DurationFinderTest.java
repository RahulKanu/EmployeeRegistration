package com.example.EmployeeRegistration;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.DurationFInder;

@RunWith(SpringRunner.class)
@WebMvcTest(value = DurationFInder.class, secure = false)
public class DurationFinderTest {

	
	@Test
	public void testDurationFinder() throws Exception {
		List<String> strList = new ArrayList<>();
		String evalStr = DurationFInder.calculateMax(strList);
		String expectedValue = "";
		JSONAssert.assertEquals(expectedValue,evalStr, false);
	}
	
	@Test
	public void testDurationFinderForElement() throws Exception {
		List<String> strList = new ArrayList<>();
		strList.add("1Y5M2D");
		strList.add("2Y3M5D");
		strList.add("4Y5M2D");
		strList.add("3Y6M2D");
		String evalStr = DurationFInder.calculateMax(strList);
		String expectedValue = "4Y5M2D";
		JSONAssert.assertEquals(expectedValue,evalStr, false);
	}

	
}