package lotto.config;

import lotto.controller.LottoController;
import lotto.domain.LottoMachine;
import lotto.domain.LottoSeller;
import lotto.domain.RandomLottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    public LottoController controller() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoSeller lottoSeller = lottoSeller();
        return new LottoController(inputView, outputView, lottoSeller);
    }

    private LottoSeller lottoSeller() {
        LottoMachine lottoMachine = new RandomLottoMachine();
        return new LottoSeller(lottoMachine);
    }
}
