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
        Map<Ranking, Integer> result = new EnumMap<>(Ranking.class);
        lottos.forEach(lotto -> {
            int count = winningLotto.calculateMatchCount(lotto);
            boolean isShotBonus = winningLotto.isContainBonusNumber(lotto);
            Ranking rank = Ranking.from(count, isShotBonus);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        });
        return result;
    }

    public List<Lotto> getSortedLottos() {
        return lottos.stream()
                .map(Lotto::sort)
                .toList();
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
}
