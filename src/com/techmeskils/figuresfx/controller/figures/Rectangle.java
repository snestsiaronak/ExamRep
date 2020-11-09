package com.techmeskils.figuresfx.controller.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Rectangle extends Figure {
    private double wight;
    private double height;

    private Rectangle(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_RECTANGLE, cx, cy, lineWidth, color);
    }

    public Rectangle(double cx, double cy, double lineWidth, Color color, double wight, double height) {
        this(cx, cy, lineWidth, color);
        this.wight = wight < 10 ? 10 : wight;
        this.height = height < 10 ? 10 : height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.wight, wight) == 0 &&
                Double.compare(rectangle.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wight, height);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokeRect(cx - wight / 2, cy - height / 2, wight, height);
    }
}
