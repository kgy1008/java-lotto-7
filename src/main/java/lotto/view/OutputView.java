package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
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
        lottos.forEach(lotto -> System.out.printf(getSortedNumber(lotto) + "%n"));
    }

    private List<Integer> getSortedNumber(final Lotto lotto) {
        List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
        Collections.sort(numbers);
        return numbers;
    }

    public void printRank(final Map<Ranking, Integer> result) {
        for (Map.Entry<Ranking, Integer> entry : result.entrySet()) {
            if (entry.getKey() != Ranking.NONE) {
                System.out.printf("%s - %d개%n", entry.getKey().getDescription(), entry.getValue());
            }
        }
    }

    public void printProfit(final double profit) {
        String roundingProfit = String.format("%.1f", profit);
        System.out.printf("총 수익률은 %s%%입니다.", roundingProfit);
    }
}
