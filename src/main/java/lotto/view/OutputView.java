package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    public void printErrorMessage(final String message) {
        System.out.println(message);
    }

    public void printLotto(final List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        lottos.forEach(lotto -> System.out.printf(lotto.getNumbers() + "%n"));
    }
}
