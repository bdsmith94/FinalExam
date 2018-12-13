package pkgCore;

import org.apache.poi.ss.formula.functions.FinanceLib;

public class Retirement {

	private int iYearsToWork;
	private double dAnnualReturnWorking;
	private int iYearsRetired;
	private double dAnnualReturnRetired;
	private double dRequiredIncome;
	private double dMonthlySSI;
	
	//Constructor for Retirement
	public Retirement() {
		
	}
	
	public Retirement(int iY2W, double dARW, int iYR, double dARR, double dRI, double dMSSI) {
		super();
		this.iYearsToWork = iY2W;
		this.dAnnualReturnWorking = dARW;
		this.iYearsRetired = iYR;
		this.dAnnualReturnRetired = dARR;
		this.dRequiredIncome = dRI;
		this.dMonthlySSI = dMSSI;
	}
	
	//Setters and Getters for Retirment's Attributes
	public int getYearsToWork() {
		return iYearsToWork;
	}
	
	public void setiYearsToWork(int iYearsToWork) {
		this.iYearsToWork = iYearsToWork;
	}
	
	public double getdAnnualReturnWorking() {
		return dAnnualReturnWorking;
	}

	public void setdAnnualReturnWorking(double dAnnualReturnWorking) {
		this.dAnnualReturnWorking = dAnnualReturnWorking;
	}

	public int getiYearsRetired() {
		return iYearsRetired;
	}

	public void setiYearsRetired(int iYearsRetired) {
		this.iYearsRetired = iYearsRetired;
	}

	public double getdAnnualReturnRetired() {
		return dAnnualReturnRetired;
	}

	public void setdAnnualReturnRetired(double dAnnualReturnRetired) {
		this.dAnnualReturnRetired = dAnnualReturnRetired;
	}

	public double getdRequiredIncome() {
		return dRequiredIncome;
	}

	public void setdRequiredIncome(double dRequiredIncome) {
		this.dRequiredIncome = dRequiredIncome;
	}

	public double getdMonthlySSI() {
		return dMonthlySSI;
	}

	public void setdMonthlySSI(double dMonthlySSI) {
		this.dMonthlySSI = dMonthlySSI;
	}
	
	//AmountToSave Determines the amount to save each month based on TotalAmountSaved, YearsToWork, 
	//and Annual Return While Working.
	public double AmountToSave()
	{
		double monthlyReturn = dAnnualReturnWorking / 1200;
		int monthsToWork = iYearsToWork * 12;
		int amount = 0;
		double TotalAmountSaved = TotalAmountSaved();
		boolean tf = false;
		
		double pmt = FinanceLib.pmt(monthlyReturn, monthsToWork, amount, TotalAmountSaved, tf);
		
		return pmt*(-1); 
	}
	
	public double TotalAmountSaved()
	{
		//TotalAmountSave determines the TotalAmountSaved based on Montly SSI, Required Income,
		//Annual Return during Retirment, and number of years retired
		
		double monthlyReturn = dAnnualReturnRetired / 1200;
		double monthsRetired = iYearsRetired * 12;
		double amountEarned = dRequiredIncome - dMonthlySSI;
		int amount = 0;
		boolean tf = false;
		
		double pv = FinanceLib.pv(monthlyReturn, monthsRetired, amountEarned, amount, tf);
		
		return pv*(-1);
		
		
	}
}
