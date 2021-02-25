/* Péter Sebestyén */

package projekt;

import projekt.AbstractFactory.City;
import projekt.AbstractFactory.DesertWorld;
import projekt.AbstractFactory.GreenWorld;
import projekt.Flyweight.Toolbar;
import projekt.Mediator.DrawingMediator;
import projekt.Mediator.GameState;
import projekt.Mediator.Mediator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class Window {

    public Window(){

        JFrame frame = new JFrame("City");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Object[] options = {"Start green world", "Start desert world"};
        int choise = JOptionPane.showOptionDialog(null, "Choose a world", "Welcome", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        Mediator drawingMediator = new DrawingMediator();
        Toolbar toolbar = new Toolbar(drawingMediator);
        drawingMediator.registerToolbar(toolbar);
        Infobar infobar = new Infobar();
        City city = new City(drawingMediator);
        drawingMediator.registerCity(city);
        GameState gameState = new GameState(drawingMediator, infobar);
        drawingMediator.registerInfobar(gameState);

        if (choise == -1) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        } else if (choise == 0) {
            GreenWorld greenWorld = new GreenWorld();
            city.createNewWorld(greenWorld);
        } else {
            DesertWorld desertWorld = new DesertWorld();
            city.createNewWorld(desertWorld);
            System.out.println(choise);
        }

        city.setPreferredSize(new Dimension(3000,2000));

        JScrollPane scrollPane = new JScrollPane(city);

        frame.getContentPane().add(BorderLayout.WEST, toolbar);
        frame.getContentPane().add(BorderLayout.NORTH, infobar);
        frame.getContentPane().add(BorderLayout.CENTER, scrollPane);
        frame.setBounds(100, 0, 1600, 1000);
        frame.setVisible(true);
    }
}
