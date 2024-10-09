package ch02_pjt_01;
public class MyCalculator {

//    CalAdd, CalMul 등 객체를 전부 매개변수로 받는 것이 아닌 인터페이스를 통해 편리하게 구현
public void calculate(int fNum, int sNum, ICalculator calculator) {
        int value = calculator.doOperation(fNum, sNum);       // 연산 실행
        System.out.println("result : " + value);
    }
}