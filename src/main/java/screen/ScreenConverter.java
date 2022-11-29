package screen;

import math.Vector3;

public class ScreenConverter {
    private int width, height;
    private double xr, yr, wr, hr;

    public ScreenConverter(int width, int height, double xr, double yr, double wr, double hr) {
        this.width = width;
        this.height = height;
        this.xr = xr;
        this.yr = yr;
        this.wr = wr;
        this.hr = hr;
    }

    public ScreenPoint r2s(Vector3 p){
        double x = (p.getX() - xr) / wr * width;
        double y = (yr - p.getY()) / hr * height;
        return new ScreenPoint((int) x, (int) y);
    }

    public Vector3 s2r(ScreenPoint sp, float z){
        double x = xr + sp.getX() * wr / width;
        double y = yr - sp.getY() * hr / height;
        return new Vector3((float)x, (float) y, z);
    }

    public Vector3 s2r(ScreenPoint sp){
        return s2r(sp, 0f);
    }

    public void setSize(int w, int h){
        width = w;
        height = h;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getXr() {
        return xr;
    }

    public void setXr(double xr) {
        this.xr = xr;
    }

    public double getYr() {
        return yr;
    }

    public void setYr(double yr) {
        this.yr = yr;
    }

    public double getWr() {
        return wr;
    }

    public void setWr(double wr) {
        this.wr = wr;
    }

    public double getHr() {
        return hr;
    }

    public void setHr(double hr) {
        this.hr = hr;
    }
}
