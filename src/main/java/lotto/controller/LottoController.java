package lotto.controller;

import java.util.function.Supplier;
import lotto.domain.LottoSeller;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoSeller lottoSeller;

    public LottoController(final InputView inputView, final OutputView outputView, final LottoSeller lottoSeller) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoSeller = lottoSeller;
    }

    public void run() {
        Lottos lottos = buyLotto();
        outputView.printLotto(lottos.getSortedLottos());
    }

    private Lottos buyLotto() {
        return rerunTemplate(() -> {
            int money = inputView.inputMoney();
            return lottoSeller.sellTo(money);
        });
    }

    private <T> T rerunTemplate(final Supplier<T> action) {
        while (true) {
            try {
                return action.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void rerunTemplate(final Runnable action) {
        while (true) {
            try {
                action.run();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
