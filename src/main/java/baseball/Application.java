package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        while (true) {
            new BaseBallGame().start();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String cmd = Console.readLine().trim();

            if (cmd.equals("1")) {
                continue;
            } else if (cmd.equals("2")) {
                break;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
}
