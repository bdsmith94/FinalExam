package pkgTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pkgCore.Retirement;

public class RetirementTest {

	@Test
	public void testPMT() {

		Retirement Retirement1 = new Retirement(40, 7, 20, 2, 10000, 2642);
		System.out.println(Retirement1.AmountToSave());
		assertEquals(554.13, Retirement1.AmountToSave(), 2);

	}

	@Test
	public void testPV() {

		Retirement Retirement2 = new Retirement(40, 7, 20, 2, 10000, 2642);
		System.out.println(Retirement2.TotalAmountSaved());
		assertEquals(1454485.55, Retirement2.TotalAmountSaved(), 2);
	}

}
