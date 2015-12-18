package UnitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ch.makery.address.model.Rate;
import domain.RateDomainModel;

public class MortgageTest {

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
	public void test() {
		RateDomainModel rdm = new RateDomainModel();

		rdm.setRateID(1);
		assertTrue(rdm.getRateID() == 1);
	}

	@Test
	public void testMortgageApproved() {
		Rate rdm1 = new Rate();
		
		rdm1.setInterestRate(.04);
		
		double pmt1 = rdm1.getPayment(360, 300000, 30);
		
		System.out.print("payment 1: " + pmt1);
		
		assertTrue(rdm1.approval(pmt1, 50000, 0) == true);
		
		
		
	}
	
	@Test
	public void testMortgageDeniedIncome() {
		Rate rdm2 = new Rate();
		
		rdm2.setInterestRate(.04);
		
		double pmt2 = rdm2.getPayment(360, 300000, 30);
		
		System.out.print("\npayment 2: " + pmt2 );
		
		assertTrue(rdm2.approval(pmt2, 1000, 0) == false);
	}
	
	@Test
	public void testMortgageDeniedIncExp() {
		Rate rdm3 = new Rate();
		
		rdm3.setInterestRate(.04);
		
		double pmt3 = rdm3.getPayment(360, 300000, 30);
		
		System.out.print("\npayment 3: " +pmt3);
		
		assertTrue(rdm3.approval(pmt3, 3000, 2999) == false);
	}
}
