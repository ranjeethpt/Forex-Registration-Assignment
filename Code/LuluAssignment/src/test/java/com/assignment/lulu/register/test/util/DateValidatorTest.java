package com.assignment.lulu.register.test.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.assignment.lulu.register.util.DateValidator;


public class DateValidatorTest {
	private DateValidator dateValidator;
	 
	@Before
	public void init() {
		dateValidator = DateValidator.getInstance();
	}
 
	@Test
	public void testDateIsNull() {
		assertFalse(dateValidator.validate(null));
	}
 
	@Test
	public void testDayIsInvalid() {
		assertFalse(dateValidator.validate("02/32/2012"));
	}
 
	@Test
	public void testMonthIsInvalid() {
		assertFalse(dateValidator.validate("20/31/2012"));
	}
 
	@Test
	public void testYearIsInvalid() {
		assertFalse(dateValidator.validate("20/31/19991"));
	}
 
	@Test
	public void testDateFormatIsInvalid() {
		assertFalse(dateValidator.validate("2012/02/20"));
	}
 
	@Test
	public void testDateFeb29_2012() {
		assertTrue(dateValidator.validate("02/29/2012"));
	}
 
	@Test
	public void testDateFeb29_2011() {
		assertFalse(dateValidator.validate("02/29/2011"));
	}
 
	@Test
	public void testDateFeb28() {
		assertTrue(dateValidator.validate("02/28/2011"));
	}
 
	@Test
	public void testDateIsValid_1() {
		assertTrue(dateValidator.validate("01/31/2012"));
	}
 
	@Test
	public void testDateIsValid_2() {
		assertTrue(dateValidator.validate("04/30/2012"));
	}
 
	@Test
	public void testDateIsValid_3() {
		assertTrue(dateValidator.validate("05/31/2012"));
	}
 
}
