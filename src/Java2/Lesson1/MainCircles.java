package Java2.Lesson1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;               //координаты в пикселях экрана где откроется окно по горизонтали
    private static final int POS_Y = 200;               //координаты в пикселях экрана где откроется окно по горизонтали
    private static final int WINDOW_WIDTH = 800;        //ширина фрайма (окна)
    private static final int WINDOW_HEIGHT = 600;       //высота фрейма (окна)

    private Sprite[] sprites = new Sprite[1];          //массив шариков
    private int spritesCount;                          //переменная для шариков, количество шариков
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();                         //запуск программы, запускает сам себя
            }
        });
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);    //включает в окне закрытие программы по крестику
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);       //метод имеющий в себе значения
        setTitle("Circles");                                        // метод для название которое будет у окна
        initApplication();

        MainCanvas canvas = new MainCanvas(this);           //передаем MainCircles в MainCanvas, через параметр this
        add(canvas);                                                 //добавляем canvas на фрейм (окно)
        setVisible(true);                                           //метод чтобы окно было видимым
        canvas.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseReleased (MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    addSprite(new Ball(e.getX(), e.getY()));
                }else if (e.getButton() == MouseEvent.BUTTON3){
                    removeSprite();
                }
            }
        });
    }

    private void addSprite (Sprite s) {
        if (spritesCount == sprites.length) {
            Sprite[] temp = new Sprite[sprites.length * 2];
            System.arraycopy(sprites, 0, temp, 0, sprites.length);
            sprites = temp;
        }
        sprites[spritesCount++] = s;
    }
    private void removeSprite (){
        if (spritesCount > 1) {spritesCount --;}
    }

    private void initApplication() {                    //инициализируем спрайты в массиве
        sprites[0] = new Background();
        spritesCount++;
    }

    public void onCanvasRepainted(MainCanvas canvas, Graphics g, float deltaTime) {    //когда отрисовалась канва, что делать дальше
        update(canvas, deltaTime); //обновление объектов на канве, движение например
        render(canvas, g);      //прорисовка объектов на канве, размер, цвет например
    }

    private void update(MainCanvas canvas, float deltaTime) {   //обновляем все спрайты
        for (int i = 0; i < spritesCount; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {   //отрисовываем все спрайты
        for (int i = 0; i < spritesCount; i++) {
            sprites[i].render(canvas, g);
        }
    }
}
