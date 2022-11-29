package third;

import math.Vector3;

import java.util.List;

public class Polyline3D {
    private List<Vector3> points;
    private boolean closed;

    public Polyline3D(List<Vector3> points, boolean closed) {
        this.points = points;
        this.closed = closed;
    }

    public List<Vector3> getPoints() {
        return points;
    }

    public boolean isClosed() {
        return closed;
    }







}
