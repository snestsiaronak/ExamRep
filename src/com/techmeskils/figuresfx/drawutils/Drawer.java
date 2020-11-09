package com.techmeskils.figuresfx.drawutils;

import com.techmeskils.figuresfx.controller.figures.Figure;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Drawer<T extends Figure & Drawable> {
    private ArrayList<Figure> figures;

    public Drawer(ArrayList<Figure> figures) {
        this.figures = figures;
    }

    public ArrayList<Figure> getFigures() {
        return figures;
    }

    public void setFigures(ArrayList<Figure> figures) {
        this.figures = figures;
    }

    public void draw(GraphicsContext gc) {
        for (Figure figure : figures) {
            if (figure != null) figure.draw(gc);
        }
    }
}
