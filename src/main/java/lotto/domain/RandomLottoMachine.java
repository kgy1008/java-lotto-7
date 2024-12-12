package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoMachine implements LottoMachine {

    private static final int MIN_LOTTO = 1;
    private static final int MAX_LOTTO = 45;
    private static final int LOTTO_COUNT = 6;

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO, MAX_LOTTO, LOTTO_COUNT);
    }
}
