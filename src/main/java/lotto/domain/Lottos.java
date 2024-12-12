package lotto.domain;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getSortedLottos() {
        return lottos.stream()
                .map(Lotto::sort)
                .toList();
    }
}
