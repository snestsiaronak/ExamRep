package com.techmeskils.figuresfx.controller;

import com.techmeskils.figuresfx.Exception.FigureException;
import com.techmeskils.figuresfx.FiguriesFxApp;
import com.techmeskils.figuresfx.controller.figures.*;
import com.techmeskils.figuresfx.drawutils.Drawer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class MainScreenViewController implements Initializable {
    private static final Logger logger = Logger.getLogger(MainScreenViewController.class);
    private ArrayList<Figure> figures;
    private Random random;

    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        figures = new ArrayList<>();
        random = new Random((System.currentTimeMillis()));
    }

    private void addFigure(Figure figure) {
        figures.add(figure);
    }

    private Figure createFigure(double x, double y) throws FigureException {
        Figure figure = null;
        switch (random.nextInt(6)) {
            case Figure.FIGURE_TYPE_CIRCLE:
                figure = new Circle(x, y, Math.max(random.nextInt(3), 10), Color.BLUE, random.nextInt(50));
                break;
            case Figure.FIGURE_TYPE_RECTANGLE:
                figure = new Rectangle(x, y, random.nextInt(3), Color.GREEN, random.nextInt(100), random.nextInt(50));
                break;
            case Figure.FIGURE_TYPE_TRIANGLE:
                figure = new Triangle(x, y, random.nextInt(3), Color.RED, random.nextInt(100));
                break;
            case Figure.FIGURE_TYPE_TRAPEZOID:
                figure = new Trapezoid(x, y, random.nextInt(3), Color.PURPLE, random.nextInt(100), random.nextInt(50));
                break;
            case Figure.FIGURE_TYPE_SMILE:
                int tmp = random.nextInt(100);
                figure = new Smile(x, y, 2, Color.YELLOW, tmp);
                break;
            case Figure.FIGURE_TYPE_FLAG:
                figure = new Flag(x, y, 1, Color.WHITE, random.nextInt(100));
                break;
            default:
                System.out.println("Такой фигуры еще пока нет!");
                //throw new FigureException("Такой фигуры еще пока нет!");
        }
        return figure;
    }

    private void repaint() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Drawer<Figure> drawer = new Drawer<Figure>(figures);
        drawer.draw(canvas.getGraphicsContext2D());
    }

    @FXML
    private void onMouseClicked(MouseEvent mouseEvent) throws FigureException {
        addFigure(createFigure(mouseEvent.getX(), mouseEvent.getY()));
        clearFigure();
        repaint();
    }

    private void clearFigure(){
        if(figures.size()>15){
            figures.clear();
        }
    }
}
