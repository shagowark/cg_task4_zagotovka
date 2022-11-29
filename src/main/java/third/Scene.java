package third;

import draw.IDrawer;
import math.Vector3;
import math.Vector4;
import screen.ScreenConverter;
import screen.ScreenPoint;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Scene {
    public Scene(Color background) {
        this.background = background;
    }

    private Color background;
    private List<IModel> models = new ArrayList<>();

    public List<IModel> getModels() {
        return models;
    }

    public Color getBackground() {
        return background;
    }

    public void setBackground(Color background) {
        this.background = background;
    }

    public void setModels(List<IModel> models) {
        this.models = models;
    }



    public void draw(/*Graphics2D gr, ScreenConverter sc,*/
                     ICamera camera,
                     IDrawer drawer) {

        List<Polyline3D> toDraw = new LinkedList<>();
        for (IModel m : models){
            for (Polyline3D p : m.getLines()){
                List<Vector3> points = new LinkedList<>();
                for (Vector3 v : p.getPoints()){
                    points.add(camera.w2s(v));
                }
                toDraw.add(new Polyline3D(points, p.isClosed()));
            }
        }
        drawer.clear(background);
        drawer.draw(toDraw);
    }



}
