package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<Ranking, Integer> analyze(final WinningLotto winningLotto) {
        Map<Ranking, Integer> result = new EnumMap<>(Ranking.class);
        lottos.forEach(lotto -> {
            int count = winningLotto.calculateMatchCount(lotto);
            Ranking rank = Ranking.from(count);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        });
        return result;
    }

    public List<Lotto> getSortedLottos() {
        return lottos.stream()
                .map(Lotto::sort)
                .toList();
    }
}
