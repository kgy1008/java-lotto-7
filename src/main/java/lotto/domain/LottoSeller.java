package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.common.ErrorMessage;

public class LottoSeller {

    private static final int MONEY_UNIT = 1000;

    private final LottoMachine lottoMachine;

    public LottoSeller(final LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public Lottos sellTo(final int money) {
        int tryCount = calculateTryCount(money);
        List<Lotto> lottos = new ArrayList<>();
        while (tryCount-- > 0) {
            Lotto lotto = new Lotto(lottoMachine.generate());
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }

    private int calculateTryCount(final int money) {
        validateMoney(money);
        return money / MONEY_UNIT;
    }

    private void validateMoney(final int money) {
        if (money < 0 || money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY.getMessage());
        }
    }
}
