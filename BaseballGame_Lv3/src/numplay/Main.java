package numplay;

import java.util.stream.Stream;
import java.util.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Lv3");
        BaseballGame BaseballGame = new BaseballGame();

        ArrayList<Integer> gameCountList = new ArrayList<>();

        int gameCountIndex=0;
        int tryCount = 0;
        while (true) {

            System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
            System.out.println("1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기");
            int gameStartNum = sc.nextInt();
            sc.nextLine();

            if (gameStartNum == 1) {
                System.out.println("< 게임을 시작합니다 >");
                //정답이 될 숫자 랜덤 생성
                //ArrayList<String> CorrectNumList = new ArrayList<>(List.of("1", "2", "3"));//값 담아서 리스트 생성
                ArrayList<String> CorrectNumList = new ArrayList<>(List.of("1", "2", "3", "4", "5", "6", "7", "8", "9"));//값 담아서 리스트 생성
                Collections.shuffle(CorrectNumList);//리스트 섞기
                CorrectNumList.subList(3, 9).clear();//리스트 주소 0,1,2 남기고 삭제

                //정답(CorrectNumList)전달하고 게임 시작
                BaseballGame.setCorrectNum(CorrectNumList);
                tryCount  = BaseballGame.play();
                gameCountList.add(tryCount);

                gameCountIndex++;

            }
            else if (gameStartNum == 2) {
                System.out.println("<게임 기록 보기>");
                if(gameCountList.size() == 0) {
                    System.out.println("게임 기록이 없습니다");
                }
                for(int i=0; i<gameCountList.size(); i++) {
                    System.out.println(i+1 + "번째 게임 : 시도 횟수 -- " + gameCountList.get(i));
                }

            }
            else if (gameStartNum == 3) {
                System.out.println("=====숫자 야구 게임을 종료합니다=====");
                break;
            }
            else {
                System.out.println("올바른 숫자를 입력해주세요!");
            }
        }
    }
}