package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.common.ErrorMessage;

public class InputView {

    private static final String DELIMITER = ",";

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return convertToInt(input);
    }

    public List<Integer> inputWinningLottoNumber() {
        String input = Console.readLine();
        return parseNumber(input);
    }

    public int inputBonusNumber() {
        String input = Console.readLine();
        return convertToInt(input);
    }

    private List<Integer> parseNumber(final String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(this::convertToInt)
                .toList();
    }

    private int convertToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_TYPE.getMessage());
        }
    }
}
