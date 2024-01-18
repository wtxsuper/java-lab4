import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        pan.add(increaseButton);
        pan.add(decreaseButton);
        fr.add(pan);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        final int DELAY = 100;
        final int[] speed = {3, 2};
        Timer tm = new Timer(DELAY, new ActionListener() {
            int x = 150, y = 150;

            @Override
            public void actionPerformed(ActionEvent arg0) {
                Graphics2D gr = (Graphics2D) pan.getRootPane().getGraphics();
                pan.update(gr);
                // Диаметр круга
                int diameter = 20;
                gr.translate(x, y);
                // Рисование круга
                gr.fillOval(-diameter / 2, -diameter / 2, diameter, diameter);
                // Изменение координат
                x = x + speed[0];
                y = y + speed[1];
                // Проверка выхода за границы
                if (!(x > diameter / 2 && x < pan.getWidth() - diameter / 2)) {
                    speed[0] = -speed[0];
                }
                if (!(y > diameter / 2 && y < pan.getHeight() - diameter / 2)) {
                    speed[1] = -speed[1];
                }

            }
        });
        tm.start();
        // Обработчик события кнопки увелечения
        increaseButton.addActionListener(e -> {
            if (speed[0] > 0) speed[0] += 2;
            else speed[0] -= 2;
            if (speed[1] > 0) speed[1] += 2;
            else speed[1] -= 2;
        });
        // Обрабочик события кнопки уменьшения
        decreaseButton.addActionListener(e -> {
            if (speed[0] > 0) speed[0] -= 2;
            else speed[0] += 2;
            if (speed[1] > 0) speed[1] -= 2;
            else speed[1] += 2;
        });
    }
}