package com.techmeskils.figuresfx.controller.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Trapezoid extends Figure {
    private double sideA;
    private double height;

    private Trapezoid(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_TRAPEZOID, cx, cy, lineWidth, color);
    }

    public Trapezoid(double cx, double cy, double lineWidth, Color color, double sideA, double height) {
        this(cx, cy, lineWidth, color);
        this.sideA = sideA < 10 ? 10 : sideA;
        this.height = height < 10 ? 10 : height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trapezoid trapezoid = (Trapezoid) o;
        return Double.compare(trapezoid.sideA, sideA) == 0 &&
                Double.compare(trapezoid.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideA, height);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        double[] pointsX = new double[]{cx - sideA / 3, cx + sideA / 3, cx + sideA / 2, cx - sideA / 2};
        double[] pointsY = new double[]{cy - height / 2, cy - height / 2, cy + height / 2, cy + height / 2};
        gc.strokePolygon(pointsX, pointsY, 4);
    }
}
