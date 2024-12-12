package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Ranking;

public class OutputView {

    public void printErrorMessage(final String message) {
        System.out.println(message);
    }

    public void printLotto(final List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        lottos.forEach(lotto -> System.out.printf(lotto.getNumbers() + "%n"));
    }

    public void printRank(final Map<Ranking, Integer> result) {
        for (Map.Entry<Ranking, Integer> entry : result.entrySet()) {
            if (entry.getKey() != Ranking.NONE) {
                System.out.printf("%s - %d개%n", entry.getKey().getDescription(), entry.getValue());
            }
        }
    }

    public void printProfit(final double profit) {
        System.out.printf("총 수익률은 %.1f%입니다.", profit);
    }
}
