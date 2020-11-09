package com.techmeskils.figuresfx.controller.figures;

import com.techmeskils.figuresfx.drawutils.Drawable;
import com.techmeskils.figuresfx.drawutils.Drawer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Figure implements Drawable {
    public static final int FIGURE_TYPE_CIRCLE = 0;
    public static final int FIGURE_TYPE_RECTANGLE = 1;
    public static final int FIGURE_TYPE_TRIANGLE = 2;
    public static final int FIGURE_TYPE_TRAPEZOID = 3;
    public static final int FIGURE_TYPE_SMILE = 4;
    public static final int FIGURE_TYPE_FLAG = 5;

    private int type;

    protected double cx;
    protected double cy;
    protected double lineWidth;
    protected Color color;

    public Figure(int type, double cx, double cy, double lineWidth, Color color) {
        this.type = type;
        this.cx = cx;
        this.cy = cy;
        this.lineWidth = lineWidth;
        this.color = color;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setCx(double cx) {
        this.cx = cx;
    }

    public void setCy(double cy) {
        this.cy = cy;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getLineWidth() {
        return lineWidth;
    }

    public Color getColor() {
        return color;
    }

    public void setLineWidth(double lineWidth) {
        this.lineWidth = lineWidth;
    }

    public abstract void draw(GraphicsContext gc);

}
