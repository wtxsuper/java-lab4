import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Main {
    public static void main(String[] args) {
        // Размеры окна
        final int WIDTH = 300;
        final int HEIGHT = 300;
        JFrame fr = new JFrame("Движение точки");
        fr.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        final JPanel pan = new JPanel();
        JButton increaseButton = new JButton("Увеличить");
        JButton decreaseButton = new JButton("Уменьшить");
        fr.add(pan);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        final int START_DELAY = 50;
        Timer tm = new Timer(START_DELAY, new ActionListener() {
            int x = 150, y = 150;
            int xSpeed = 3;
            int ySpeed = 2;

            @Override
            public void actionPerformed(ActionEvent arg0) {
                Graphics2D gr = (Graphics2D) pan.getRootPane().getGraphics();
                pan.update(gr);
                // Диаметр круга
                int diameter = 20;
                gr.translate(x, y);
                // Рисование круга
                gr.fillOval(-diameter/2, -diameter/2, diameter, diameter);
                // Изменение координат
                x = x + xSpeed;
                y = y + ySpeed;
                // Проверка выхода за границы
                if (!(x > diameter/2 && x < fr.getWidth() - diameter/2)) {
                    xSpeed = -xSpeed;
                }
                if (!(y > diameter/2 + 50 && y < fr.getHeight() - diameter/2 - 50)) {
                    ySpeed = -ySpeed;
                }

            }
        });
        tm.start();
    }
}