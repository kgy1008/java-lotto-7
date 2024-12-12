package lotto.domain;

public class WinningLotto {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(final Lotto lotto, final int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public int calculateMatchCount(final Lotto target) {
        int count = 0;
        for (int number : target.getNumbers()) {
            if (lotto.isContain(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean isContainBonusNumber(final Lotto lotto) {
        return lotto.isContain(bonusNumber);
    }
}
