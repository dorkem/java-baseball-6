package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Scanner;

public class BaseBallGame {
    public void start(){
        int[] answer = generateAnswer();
        gameStart(answer);
    }

    private int[] generateAnswer(){
        System.out.println("숫자 야구 게임을 시작합니다.");

        int[] answer = new int[3];
        boolean[] used = new boolean[10];

        int idx = 0;
        while(idx < 3){
            int num = Randoms.pickNumberInRange(1, 9);
            if (!used[num]){
                answer[idx++] = num;
                used[num] = true;
            }
        }
        return answer;
    }

    private void gameStart(int[] answer){
        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            Scanner sc = new Scanner(System.in);
            String userAnswer = sc.nextLine();



            if (userAnswer.length() != 3) {
                throw new IllegalArgumentException();
            }
            //비교하는 로직
        }

    }
}
