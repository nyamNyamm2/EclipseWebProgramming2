package ch02_pjt_01;
public class CalDiv implements ICalculator {
    @Override
    public int doOperation(int firstNum, int secondNum) {
        return secondNum != 0 ? (firstNum / secondNum) : 0;
    }
//    ICalculator 인터페이스 구현을 통해 편리하게 의존성 주입
}