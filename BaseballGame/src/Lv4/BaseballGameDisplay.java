package Lv4;

public class BaseballGameDisplay {
    public int displayHint(int strike, int ball, String answerNumStr, int gameLevel) {
        //힌트 및 정답 출력
        if (strike == 0 && ball == 0) {
            System.out.println("아웃입니다");
            return 0;
        }
        else if ((strike > 0 || ball > 0) && !(strike == gameLevel)) {
            System.out.println(strike + "스트라이크 " + ball + "볼입니다");
            strike = 0;
            ball = 0;
            return 0;
        }
        else {
            System.out.println("정답입니다! " + answerNumStr);
            return 1;
        }
    }
}
