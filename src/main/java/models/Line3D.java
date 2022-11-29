package models;

import math.Vector3;
import third.IModel;
import third.Polyline3D;

import java.util.ArrayList;
import java.util.List;

public class Line3D implements IModel {
    private Vector3 p1, p2;

    public Line3D(Vector3 p1, Vector3 p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public List<Polyline3D> getLines() {
        List<Vector3> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        Polyline3D p = new Polyline3D(points, false);
        List<Polyline3D> answer = new ArrayList<>();
        answer.add(p);
        return answer;
    }
}
