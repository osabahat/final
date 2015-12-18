package base;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.RateDomainModel;
import base.RateDAL;

public class Rate_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetRate() {
		RateDomainModel rdm = new RateDomainModel();

		rdm.setRateID(1);
		assertTrue(rdm.getRateID() == 1);

	}

	@Test
	public void testRate1() {
		RateDAL rate1 = new RateDAL();
		RateDomainModel rdm1 = new RateDomainModel();

		rdm1.setInterestRate(.05);

		assertTrue(rate1.getRate(600) == rdm1.getInterestRate());
	}

	@Test
	public void testRate2() {
		RateDAL rate2 = new RateDAL();
		RateDomainModel rdm2 = new RateDomainModel();

		rdm2.setInterestRate(.045);

		assertTrue(rate2.getRate(650) == rdm2.getInterestRate());
	}
	@Test
	public void testRate3() {
		RateDAL rate3 = new RateDAL();
		RateDomainModel rdm3 = new RateDomainModel();

		rdm3.setInterestRate(.04);

		assertTrue(rate3.getRate(700) == rdm3.getInterestRate());
	}
	@Test
	public void testRate4() {
		RateDAL rate4 = new RateDAL();
		RateDomainModel rdm4 = new RateDomainModel();

		rdm4.setInterestRate(.0375);

		assertTrue(rate4.getRate(750) == rdm4.getInterestRate());
	}
	@Test
	public void testRate5() {
		RateDAL rate5 = new RateDAL();
		RateDomainModel rdm5 = new RateDomainModel();

		rdm5.setInterestRate(.035);

		assertTrue(rate5.getRate(80) == rdm5.getInterestRate());
	}
}
