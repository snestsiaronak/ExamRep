package com.techmeskils.figuresfx.controller.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Flag extends Figure {
    private double height;

    private Flag(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_RECTANGLE, cx, cy, lineWidth, color);
    }

    public Flag(double cx, double cy, double lineWidth, Color color, double height) {
        this(cx, cy, lineWidth, color);
        this.height = height < 50 ? 50 : height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flag flag = (Flag) o;
        return Double.compare(flag.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.setFill(color);
        //gc.strokeRect(cx - 3 * height / 4, cy - height / 2, 3 * height/2, height);
        gc.fillRect(cx - 3 * height / 4, cy - height / 2, 3 * height / 2, height);
        gc.setStroke(Color.RED);
        gc.strokeRect(cx - 3 * height / 4, cy - height / 2, 3 * height / 2, height);
        gc.setFill(Color.RED);
        gc.fillRect(cx - 3 * height / 4, cy - height / 6, 3 * height / 2, height / 3);
    }
}
