package ch02_pjt_01;
public class MainClass {
    public static void main(String[] args) {	
//    	인터페이스로 통일하여 각 메소드들을 구분해서 쓰지않아도 되니 편리함

        MyCalculator calculator = new MyCalculator();		
        calculator.calculate(10, 5, new CalAdd());
        calculator.calculate(10, 5, new CalSub());
        calculator.calculate(10, 5, new CalMul());
        calculator.calculate(10, 5, new CalDiv());
    }
}