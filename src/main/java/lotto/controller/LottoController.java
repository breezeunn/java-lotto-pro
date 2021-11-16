package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        inputView.printPriceMessage();
        Price price = getPrice();
        Lottos lottos = new Lottos(price);
        outputView.printLottos(lottos);
        inputView.printWinningLottoMessage();
        Lotto winningLotto = getWinningLotto();
        WinningStats winningStats = new WinningStats(lottos, winningLotto);
        ProfitRate profitRate = price.getProfitRate(winningStats);
        outputView.printWinningStats(winningStats);
        outputView.printProfitRate(profitRate);
    }

    private Price getPrice() {
        try {
            return new Price(inputView.inputPrice());
        } catch (Exception e) {
            inputView.printErrorMessage();
            return getPrice();
        }
    }

    private Lotto getWinningLotto() {
        try {
            return new Lotto(inputView.inputWinningLotto());
        } catch (Exception e) {
            inputView.printErrorMessage();
            return getWinningLotto();
        }
    }
}