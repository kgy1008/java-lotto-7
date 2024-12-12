package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(final Lotto lotto, final int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public int calculateMatchCount(final Lotto target) {
        List<Integer> winningNumbers = new ArrayList<>(lotto.getNumbers());
        winningNumbers.add(bonusNumber);
        return (int) target.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean isContainBonusNumber(final Lotto lotto) {
        return lotto.isContain(bonusNumber);
    }
}
