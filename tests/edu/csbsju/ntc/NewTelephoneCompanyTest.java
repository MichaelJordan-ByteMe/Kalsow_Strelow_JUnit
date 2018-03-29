package edu.csbsju.ntc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NewTelephoneCompanyTest {

	NewTelephoneCompany ntc;
	@Before
	public void setUp() throws Exception {
		ntc = new NewTelephoneCompany();
	}

	@Test (expected = UnsupportedOperationException.class)
	public void testInvalidStartTimeNegative() {
		ntc.setStartTime(-5);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test (expected = UnsupportedOperationException.class)
	public void testInvalidStartTimeNegativeOne() {
		ntc.setStartTime(-1);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test (expected = UnsupportedOperationException.class)
	public void testInvalidStartTimeOver2400() {
		ntc.setStartTime(2544);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test (expected = UnsupportedOperationException.class)
	public void testInvalidStartTime2400() {
		ntc.setStartTime(2400);
		ntc.setDuration(10);
		ntc.computeCharge();
	}

	@Test (expected = UnsupportedOperationException.class)
	public void testInvalidStartTime2401() {
		ntc.setStartTime(2401);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test (expected = UnsupportedOperationException.class)
	public void testInvalidStartTimeMinsOver59() {
		ntc.setStartTime(1578);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test (expected = UnsupportedOperationException.class)
	public void testInvalidStartTimeMinsEqual60() {
		ntc.setStartTime(1160);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test (expected = UnsupportedOperationException.class)
	public void testInvalidStartTimeMins1161() {
		ntc.setStartTime(1161);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test (expected = UnsupportedOperationException.class)
	public void testInvalidStartTime799() {
		ntc.setStartTime(799);
		ntc.setDuration(-5);
		ntc.computeCharge();
	}
	
	@Test (expected = UnsupportedOperationException.class)
	public void testInvalidDuration0() {
		ntc.setStartTime(1800);
		ntc.setDuration(00);
		ntc.computeCharge();
	}
	
	@Test (expected = UnsupportedOperationException.class)
	public void testInvalidDurationNeg1() {
		ntc.setStartTime(1801);
		ntc.setDuration(-1);
		ntc.computeCharge();
	}
	
	@Test
	public void testDiscountStartAndDiscountDuration() {
		ntc.setStartTime(500);
		ntc.setDuration(100);
		assertTrue(ntc.computeCharge() == 1768.0);
	}
	
	@Test
	public void testDiscountStart759AndDiscountDuration() {
		ntc.setStartTime(1801);
		ntc.setDuration(61);
		assertTrue(ntc.computeCharge() == 1078.48);
	}
	
	@Test
	public void testDiscountStart1959AndDiscountDuration61() {
		ntc.setStartTime(1959);
		ntc.setDuration(61);
		assertTrue(ntc.computeCharge() == 1078.48);
	}
	
	@Test
	public void testDiscountStart2359AndDiscountDuration() {
		ntc.setStartTime(2359);
		ntc.setDuration(65);
		assertTrue(ntc.computeCharge() == 1149.2);
	}
	
	@Test
	public void testDiscountStartOnly0() {
		ntc.setStartTime(0);
		ntc.setDuration(60);
		assertTrue(ntc.computeCharge() == 1248.0);
	}
	
	@Test
	public void testDiscountStart400Only() {
		ntc.setStartTime(400);
		ntc.setDuration(59);
		assertTrue(ntc.computeCharge() == 1227.2);
	}
	
	@Test
	public void testDiscountStart759Only() {
		ntc.setStartTime(759);
		ntc.setDuration(1);
		assertTrue(ntc.computeCharge() == 20.8);
	}
	
	@Test
	public void testDiscountStart1800Only() {
		ntc.setStartTime(1800);
		ntc.setDuration(10);
		assertTrue(ntc.computeCharge() == 208.0);
	}
	
	@Test
	public void testDiscountStart1801Only() {
		ntc.setStartTime(1801);
		ntc.setDuration(10);
		assertTrue(ntc.computeCharge() == 208.0);
	}
	
	@Test
	public void testDiscountStart2359Only() {
		ntc.setStartTime(2359);
		ntc.setDuration(10);
		assertTrue(ntc.computeCharge() == 208.0);
	}
	
	@Test
	public void testDiscountDuration65Only() {
		ntc.setStartTime(800);
		ntc.setDuration(65);
		assertTrue(ntc.computeCharge() == 2298.4);
	}
	
	@Test
	public void testDiscountDuration61Only() {
		ntc.setStartTime(900);
		ntc.setDuration(61);
		assertTrue(ntc.computeCharge() == 2156.96);
	}
	
	@Test
	public void testNoDiscountStart1000() {
		ntc.setStartTime(1000);
		ntc.setDuration(40);
		assertTrue(ntc.computeCharge() == 1664.0);
	}
	
	@Test
	public void testNoDiscountStart800() {
		ntc.setStartTime(800);
		ntc.setDuration(1);
		assertTrue(ntc.computeCharge() == 41.6);
	}
	
	@Test
	public void testNoDiscountStart801() {
		ntc.setStartTime(801);
		ntc.setDuration(59);
		assertTrue(ntc.computeCharge() == 2454.4);
	}
	
	
	@Test
	public void testNoDiscountStart1759() {
		ntc.setStartTime(1759);
		ntc.setDuration(60);
		assertTrue(ntc.computeCharge() == 2496.0);
	}
}
