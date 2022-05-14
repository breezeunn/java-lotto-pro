package lotto.ui;

import java.util.Scanner;

public class InputView {

    public static int getPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");

        Scanner sc = new Scanner(System.in);
        int purchasePrice;
        try {
            purchasePrice = sc.nextInt();
        } catch (Exception e) {
            throw new RuntimeException("The purchase price should contain only numbers.");
        }

        return purchasePrice;
    }

}
