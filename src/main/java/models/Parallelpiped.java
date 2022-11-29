package models;

import math.Vector3;
import third.IModel;
import third.Polyline3D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parallelpiped implements IModel {
    private Vector3 a, b;

    public Parallelpiped(Vector3 a, Vector3 b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public List<Polyline3D> getLines() {
        List<Polyline3D> result = new ArrayList<>();
        result.add(new Polyline3D(Arrays.asList(
                new Vector3(a.getX(), a.getY(), a.getZ()),
                new Vector3(a.getX(), b.getY(), a.getZ()),
                new Vector3(b.getX(), b.getY(), a.getZ()),
                new Vector3(b.getX(), a.getY(), a.getZ())
        ), true ));

        result.add(new Polyline3D(Arrays.asList(
                new Vector3(a.getX(), a.getY(), b.getZ()),
                new Vector3(a.getX(), b.getY(), b.getZ()),
                new Vector3(b.getX(), b.getY(), b.getZ()),
                new Vector3(b.getX(), a.getY(), b.getZ())
        ), true ));

        result.add(new Polyline3D(Arrays.asList(
                new Vector3(a.getX(), a.getY(), b.getZ()),
                new Vector3(a.getX(), b.getY(), b.getZ()),
                new Vector3(b.getX(), b.getY(), b.getZ()),
                new Vector3(b.getX(), a.getY(), b.getZ())
        ), true ));

        result.add(new Polyline3D(Arrays.asList(
                new Vector3(a.getX(), a.getY(), a.getZ()),
                new Vector3(a.getX(), a.getY(), b.getZ()),
                new Vector3(a.getX(), b.getY(), b.getZ()),
                new Vector3(a.getX(), b.getY(), a.getZ())
        ), true ));
        return null;
    }
}
