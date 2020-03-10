package Java2.Lesson1;


import java.awt.*;

public class Ball extends Sprite {              //конкретный спрайт мячик
    private final Color color = new Color(        //у мячика появлятся цвет, т.е. у каждого создаваемого мячика свой цвет
            (int) (Math.random() * 255),
            (int) (Math.random() * 255),
            (int) (Math.random() * 255)
    );
    private float vX = (float) (100f + (Math.random() * 200f)); //каждый мячик двигается со своей скоростью по оси х
    private float vY = (float) (100f + (Math.random() * 200f)); //каждый мячик двигается со своей скоростью по оси у

    Ball() {                                                    //конструктор мячика
        halfHeight = 20 + (float) (Math.random() * 50f);        // у каждого мячика своя высота от 20 пикселей до 70 пискселей
        halfWidth = halfHeight;                                 //ширина мячика равна высоте мячика
    }

    public Ball(int x, int y) {
        this();
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(MainCanvas canvas, float deltaTime) {    //обновление мячика (метод из класса Sprite), берет в параметрах время движения и где рисуется
        x += vX * deltaTime;                            //смещаем шарик по Х, для этого берем скорость и время
        y += vY * deltaTime;                            //смещаем шарик по У, для этого берем скорость и время
        if (getLeft() < canvas.getLeft()) {             //смотрим чтобы мячик не убегал за левую границу окна, если getLeft спрайта меньше чем getLeft канвы, то
            setLeft(canvas.getLeft());                  //устанавливаем getLeft спрайта getLeft границы
            vX = -vX;                                   //разворачиваем спрайт обратно
        }
        if (getRight() > canvas.getRight()) {
            setRight(canvas.getRight());
            vX = -vX;
        }
        if (getTop() < canvas.getTop()) {
            setTop(canvas.getTop());
            vY = -vY;
        }
        if (getBottom() > canvas.getBottom()) {
            setBottom(canvas.getBottom());
            vY = -vY;
        }
    }

    @Override
    public void render(MainCanvas canvas, Graphics g) {      // отрисовка каждого конкретного мячика
        g.setColor(color);                                   // берет свой цвет
        g.fillOval((int) getLeft(), (int) getTop(),          // берет свой размер
                (int) getWidth(), (int) getHeight());
    }
}
