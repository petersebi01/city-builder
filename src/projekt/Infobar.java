/* Péter Sebestyén */

package projekt;

import javax.swing.*;
import java.awt.*;

public class Infobar extends JPanel {

    private JLabel moneyLbl;
    private JLabel populationLbl;

    public Infobar(){

        moneyLbl = new JLabel("Pénz: 0");
        populationLbl = new JLabel("Lakósság: 0");

        this.setLayout(new FlowLayout());

        this.add(moneyLbl);
        this.add(populationLbl);
    }

    public void setMoneyLbl(int money){
        moneyLbl.setText("Pénz: " + money);
    }

    public void setPopulationLbl(int population){
        populationLbl.setText("Lakósság: " + population);
    }
}
