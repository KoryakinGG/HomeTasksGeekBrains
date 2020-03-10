package Java2.Lesson1;


import java.awt.Color;
import java.awt.Graphics;

public class Background extends Sprite {
private float time;
private static final float AMPLITUDE = 255f / 2;
private Color color;

    @Override
    public void update(MainCanvas canvas, float deltaTime) {
       time += deltaTime;
       int red  = Math.round(AMPLITUDE + AMPLITUDE*(float) Math.sin(time/2));   // меняем красный цвет по синусоиде, только в 2 раза медленнее, иначе будет от белого к черному
       int green  = Math.round(AMPLITUDE + AMPLITUDE*(float) Math.sin(time/3)); // меняем зеленый цвет по синусоиде, только в 3 раза медленнее, иначе будет от белого к черному
       int blue  = Math.round(AMPLITUDE + AMPLITUDE*(float) Math.sin(time));
       color = new Color (red, green, blue);
    }

    @Override
    public void render(MainCanvas canvas, Graphics g) {
        canvas.setBackground(color);
    }
}