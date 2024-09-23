package numplay;

import java.util.stream.Stream;
import java.util.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Lv1");
        BaseballGame BaseballGame = new BaseballGame();

        //정답이 될 숫자 랜덤 생성
        ArrayList<String> CorrectNumList = new ArrayList<>(List.of("1", "2", "3", "4", "5", "6", "7", "8", "9"));//값 담아서 리스트 생성
        Collections.shuffle(CorrectNumList);//리스트 섞기
        CorrectNumList.subList(3, 9).clear();//리스트 주소 0,1,2 남기고 삭제

        //정답(CorrectNumList)전달하고 게임 시작
        BaseballGame.setCorrectNum(CorrectNumList);
        BaseballGame.play();
    }
}