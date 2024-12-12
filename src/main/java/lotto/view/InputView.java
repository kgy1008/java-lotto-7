package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.ErrorMessage;

public class InputView {

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return convertToInt(input);
    }

    public String inputWinningLottoNumber() {
        return Console.readLine();
    }

    public int inputBonusNumber() {
        String input = Console.readLine();
        return convertToInt(input);
    }

    private int convertToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_TYPE.getMessage());
        }
    }
}
