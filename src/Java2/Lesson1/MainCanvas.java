package Java2.Lesson1;

import javax.swing.*;
import java.awt.*;

public class MainCanvas extends JPanel {

    long lastFrameTime;                         //объявление переменной
    private final MainCircles controller;       //объявляем контроллер

    MainCanvas(MainCircles controller) {            //выступает в ролли контроллера (управляющего программой)
        lastFrameTime = System.nanoTime();          //засекаем время начало отрисовки
        this.controller = controller;
    }

    @Override
    protected void paintComponent(Graphics g) {             //метод ДжейПанелки, при помощи которого мы рисуем, т.е. он обновляется и заново рисует все объекты
        super.paintComponent(g);                            //отрисовка происходит, тогда когда решает Swing

        long currentTime = System.nanoTime();                               //отчет времени со старта отрисовки
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;     //считаем дельту (разницу) времени в секундах между стартом отрисовки и самой отрисовкой
        controller.onCanvasRepainted(this, g, deltaTime);

        try {
            Thread.sleep(16);     //ставим промежуток времени чтобы paintComponent не так часто отрисовывался не 400 раз в сек,а было 60 fps
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lastFrameTime = currentTime;
        repaint();                                                  //говорим Swing еще раз поместить отрисовку в JVM
    }

    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }

}
