package com.techmeskils.figuresfx.controller.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import java.util.Objects;

public class Smile extends Figure {
    private double radius;

    private Smile(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_SMILE, cx, cy, lineWidth, color);
    }

    public Smile(double cx, double cy, double lineWidth, Color color, double radius) {
        this(cx, cy, lineWidth, color);
        this.radius = radius < 50 ? 50 : radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Smile smile = (Smile) o;
        return Double.compare(smile.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.setFill(color);
        gc.fillOval(cx - radius, cy - radius, radius * 2, radius * 2);
        gc.strokeOval(cx - radius, cy - radius, radius * 2, radius * 2);
        gc.setStroke(Color.BLACK);
        gc.strokeOval(cx - radius / 2, cy - radius / 2, radius / 10, radius / 10);
        gc.strokeOval(cx + radius / 2, cy - radius / 2, radius / 10, radius / 10);
        gc.strokeArc(cx - radius / 2, cy - radius / 2, radius, radius, 225, 90, ArcType.OPEN);
    }
}
