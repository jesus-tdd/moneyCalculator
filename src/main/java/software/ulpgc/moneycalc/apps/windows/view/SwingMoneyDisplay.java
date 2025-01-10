package software.ulpgc.moneycalc.apps.windows.view;

import software.ulpgc.moneycalc.architecture.model.Money;
import software.ulpgc.moneycalc.architecture.view.MoneyDisplay;

import javax.swing.*;

public class SwingMoneyDisplay extends JPanel implements MoneyDisplay {
    private final JLabel label;

    public SwingMoneyDisplay() {
        this.add(label = createLabel());
    }

    private JLabel createLabel() {
        return new JLabel();
    }

    @Override
    public void show(Money money) {
        label.setText(money.amount()+ " " + money.currency().code());
    }
}
