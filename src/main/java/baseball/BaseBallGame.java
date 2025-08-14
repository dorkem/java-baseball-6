package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallGame {
    private static final int DIGIT = 3;

    public void start(){
        String answer = generateAnswer();
        gameStart(answer);
    }

    private String generateAnswer(){
        System.out.println("숫자 야구 게임을 시작합니다.");

        String answer = "";
        boolean[] used = new boolean[10];

        int idx = 0;
        while(idx < DIGIT){
            int num = Randoms.pickNumberInRange(1, 9);
            if (!used[num]){
                answer += num;
                idx++;
                used[num] = true;
            }
        }
        return answer;
    }

    private void gameStart(String answer){
        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();

            if (userInput.length() != DIGIT) {
                throw new IllegalArgumentException();
            }

            int[] sb = countSB(answer, userInput);
            int strike = sb[0];
            int ball = sb[1];

            if (strike == DIGIT) {
                System.out.println(DIGIT + "스트라이크");
                System.out.println(DIGIT + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }

            String result = formatResult(ball, strike);
            System.out.println(result);
        }
    }

    private static int[] countSB(String answer, String userInput) {
        int strike = 0;
        int[] answerCount = new int[10];
        int[] guessCount = new int[10];

        for (int i = 0; i < DIGIT; i++) {
            int s = answer.charAt(i) - '0';
            int g = userInput.charAt(i) - '0';
            if (s == g) strike++;
            answerCount[s]++;
            guessCount[g]++;
        }

        int common = 0;
        for (int i = 0; i < 10; i++) common += Math.min(answerCount[i], guessCount[i]);

        int ball = common - strike;
        return new int[]{strike, ball};
    }

    private String formatResult(int ball, int strike) {
        if (ball == 0 && strike == 0) return "낫싱";
        String result = "";
        if (ball > 0) result += ball + "볼";
        if (strike > 0) result += (result.isEmpty() ? "" : " ") + strike + "스트라이크";
        return result;
    }
}
