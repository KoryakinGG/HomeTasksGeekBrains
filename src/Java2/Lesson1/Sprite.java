package Java2.Lesson1;


import java.awt.*;

public abstract class Sprite {       //делаем спрайт
    protected float x;                  //координаты спрайты по х
    protected float y;                  // координаты справйта по у
    protected float halfWidth;          // полуширина
    protected float halfHeight;         // полувысота
//устанавливаем для спрайта границы
    protected float getLeft() {
        return x - halfWidth;
    }    //взять левую границу

    protected void setLeft(float left) {
        x = left + halfWidth;
    }   // сеттер на установку значения левой границы

    protected float getRight() {
        return x + halfWidth;
    }  //взять правую границу

    protected void setRight(float right) {
        x = right - halfWidth;
    } //установить правую границу

    protected float getTop() {
        return y - halfHeight;
    }  // взять верхнюю границу

    protected void setTop(float top) {
        y = top + halfHeight;
    }  // установить верхнюю границу

    protected float getBottom() {
        return y + halfHeight;
    }  // взять нижнюю границу

    protected void setBottom(float bottom) {
        y = bottom - halfHeight;
    } // установить нижнюю границу

    protected float getWidth() {
        return 2f * halfWidth;
    } // ширина спрайта

    protected float getHeight() {
        return 2f * halfHeight;
    } // высота спрайта

    public void update(MainCanvas canvas, float deltaTime) {   //любой объект программы будет уметь себя обновлять
    }

    public void render(MainCanvas canvas, Graphics g) {   // и рисовать
    }

}
