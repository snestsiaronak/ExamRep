package com.techmeskils.figuresfx.controller.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Triangle extends Figure {
    private double side;

    private Triangle(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_TRIANGLE, cx, cy, lineWidth, color);
    }

    public Triangle(double cx, double cy, double lineWidth, Color color, double side) {
        this(cx, cy, lineWidth, color);
        this.side = side < 10 ? 10 : side;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.side, side) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(side);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        double[] pointsX = new double[]{cx - side / 2, cx, cx + side / 2};
        double[] pointsY = new double[]{cy + side * Math.sqrt(3) / 6, cy - side * Math.sqrt(3) / 3, cy + side * Math.sqrt(3) / 6};
        gc.strokePolygon(pointsX, pointsY, 3);
    }
}
