package lotto.config;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    public LottoController controller() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        return new LottoController(inputView, outputView);
    }
}
