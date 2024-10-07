package ch02_pjt_01;

public class MyCalculator {

	public void calAdd(int fNum, int sNum)
	{
		ICalculator calc = new CalAdd();
		int value = calc.doOperation(fNum, sNum);
		System.out.println("결과: " + value);
	}
	
	public void calSub(int fNum, int sNum)
	{
		ICalculator calc = new CalSub();
		int value = calc.doOperation(fNum, sNum);
		System.out.println("결과: " + value);
	}
	
	public void calMul(int fNum, int sNum)
	{
		ICalculator calc = new CalMul();
		int value = calc.doOperation(fNum, sNum);
		System.out.println("결과: " + value);
	}
	
	public void calDiv(int fNum, int sNum)
	{
		ICalculator calc = new CalDiv();
		int value = calc.doOperation(fNum, sNum);
		System.out.println("결과: " + value);
	}
	
	
}
