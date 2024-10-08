package Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BaseballGame {
    Scanner sc = new Scanner(System.in);

    BaseballGameDisplay GameDisplay = new BaseballGameDisplay();

    private ArrayList<String> CorrectNumList = new ArrayList<>();
    int strike = 0;
    int ball = 0;

    public void setCorrectNum(ArrayList CorrectNumList) {
        this.CorrectNumList = CorrectNumList;
    }

    public int play() {
        loopOut:
        while (true) {
            strike=0;
            ball=0;
            //정답과 비교할 숫자 입력
            System.out.print("0을 제외한 서로 다른 3자리 숫자를 입력하세요 : ");
            String answerNumStr = sc.nextLine();

            //비교 숫자 리스트 생성
            String[] answerNumArr = answerNumStr.split("");
            ArrayList<String> answerNumList = new ArrayList<String>(Arrays.asList(answerNumArr));

            //입력 받은 숫자 올바른지 판별
            boolean check_answerNum = validateInput(answerNumStr);
            if (!check_answerNum) {
                continue loopOut;
            }

            //strike or ball 체크
            for (int i = 0; i < CorrectNumList.size(); i++) {
                if (answerNumList.get(i).equals(CorrectNumList.get(i))) {
                    strike++;
                    if (strike == 3) {
                        break;
                    }
                }

                for (int j = 0; j < CorrectNumList.size(); j++) {
                    if (answerNumList.get(i).equals(CorrectNumList.get(j)) && i != j) {
                        ball++;
                    }
                }
            }

            //힌트 및 정답 출력
            int result = GameDisplay.displayHint(strike, ball, answerNumStr);
            if(result == 1) {
                break;
            }
        }
        System.out.println("끝!");
        return 1;
    }

    //입력 받은 숫자 올바른지 판별
    protected boolean validateInput(String answerNumStr) {
        for (int i = 0; i < answerNumStr.length(); i++) {
            //숫자가 아닐 경우
            if (answerNumStr.charAt(i) < '1' || answerNumStr.charAt(i) > '9') {
                System.out.println("올바르지 않은 입력값입니다.");
                return false;
            }
            for (int j = 0; j < i; j++) {
                //중복된 숫자가 있는 경우
                if (answerNumStr.charAt(i) == answerNumStr.charAt(j)) {
                    System.out.println("올바르지 않은 입력값입니다.");
                    return false;
                }
            }
        }
        //3자리 아닐 경우
        if (!(answerNumStr.length() == 3)) {
            System.out.println("올바르지 않은 입력값입니다.");
            return false;
        }

        return true;
    }
}
