/* Péter Sebestyén */

package projekt.Mediator;

import projekt.Infobar;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class GameState implements Component {

    private Mediator mediator;
    private Infobar infobar;
    private int money;
    private int population;
    private int tax;
    private int monthlyCost;
    private Timer timer;
    private Timer timer2;
    private Timer timer3;

    public GameState(Mediator mediator, Infobar infobar){

        this.mediator = mediator;
        this.infobar = infobar;

        money = 100000;
        population = 0;

        timer = new Timer();
        timer2 = new Timer();
        timer3 = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                monthlyCost = getMonthlyCostOfBuildings();
                money = money - monthlyCost;
                printOut();

                if (money < 0){

                    timer3.scheduleAtFixedRate(new TimerTask() {
                        @Override
                        public void run() {
                            if (money < -100000){
                                timer.cancel();
                                timer2.cancel();
                                timer3.cancel();

                                JFrame frame = new JFrame();
                                JOptionPane.showMessageDialog(frame, "Game Over");

                            }
                        }
                    }, 0, 10000);
                }
            }
        }, 0, 800);

        timer2.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                tax = getTax();
                money = money + tax;
                printOut();
            }
        }, 0, 2500);

    }

    @Override
    public int getTax() {
        return mediator.getCityTax();

    }

    public int getMonthlyCostOfBuildings(){
        return mediator.getCosts();
    }

    //kiszámolja a jelenlegi pénz összeget
    @Override
    public void setMoney(int moneySent) {
        money = money - moneySent;
        printOut();
    }

    @Override
    public void setPopulation(int newPopulation){
        population = newPopulation;
    }

    public void printOut(){
        infobar.setMoneyLbl(money);
        infobar.setPopulationLbl(population);
    }
}
