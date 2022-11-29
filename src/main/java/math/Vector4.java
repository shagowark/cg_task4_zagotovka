package math;

public class Vector4 {
    private float[] values;

    public Vector4(float x, float y, float z, float w) {
        values = new float[]{x, y, z, w};
    }

    public Vector4(float x, float y, float z) {
        this(x, y, z, 0);
    }

    public Vector4(float[] a){
        this(a[0], a[1], a[2], a[3]);
    }

    public Vector4(Vector3 v, float w) {
        this(v.getX(), v.getY(), v.getZ(), w);
    }

    public Vector4(Vector3 v) {
        this(v, 0);
    }

    public static Vector4 zero() {
        return new Vector4(0, 0, 0, 0);
    }

    public Vector4 mul(float n){
        float[] a = new float[4];
        for (int i = 0; i < a.length; i++){
            a[i] = values[i] * n;
        }
        return new Vector4(a);
    }

    public Vector4 add(Vector4 v){
        float[] a = new float[4];
        for (int i = 0; i < a.length; i++){
            a[i] = at(i) + v.at(i);
        }
        return new Vector4(a);
    }

    private static final float EPS = 1e-8f;

    public Vector4 normolizedW() {
        if (Math.abs(getW()) < EPS) {
            return new Vector4(getX(), getY(), getZ(), 0f);
        }
        return new Vector4(getX() / getW(), getY() / getW(), getZ() / getW(), 1f);
    }

    public Vector3 asV3() {
        Vector4 v = normolizedW();
        return new Vector3(v.getX(), v.getY(), v.getZ());
    }

    public float getX() {
        return values[0];
    }

    public float getY() {
        return values[1];
    }

    public float getZ() {
        return values[2];
    }

    public float getW() {
        return values[3];
    }

    public float at(int idx) {
        return values[idx];
    }
}
