package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<Ranking, Integer> analyze(final WinningLotto winningLotto) {
        Map<Ranking, Integer> result = initResult();
        lottos.forEach(lotto -> {
            int count = winningLotto.calculateMatchCount(lotto);
            boolean isShotBonus = winningLotto.isContainBonusNumber(lotto);
            Ranking rank = Ranking.from(count, isShotBonus);
            result.put(rank, result.get(rank) + 1);
        });
        return result;
    }

    private Map<Ranking, Integer> initResult() {
        Map<Ranking, Integer> result = new EnumMap<>(Ranking.class);
        for (Ranking rank : Ranking.values()) {
            result.put(rank, 0);
        }
        return result;
    }

    public double calculateProfit(final Map<Ranking, Integer> result) {
        int initialMoney = lottos.size() * LOTTO_PRICE;
        long winningMoney = calculateWinningPrice(result);
        return ((double) winningMoney / initialMoney) * 100;
    }

    private long calculateWinningPrice(final Map<Ranking, Integer> result) {
        return result.keySet().stream()
                .mapToLong(ranking -> (long) ranking.getPrize() * result.get(ranking))
                .sum();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
