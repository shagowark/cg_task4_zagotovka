package math;

public class Matrix4Factories {
    public static Matrix4 scale(float x, float y, float z) {
        Matrix4 m = Matrix4.one();
        m.setAt(0, 0, x);
        m.setAt(1, 1, y);
        m.setAt(2, 2, y);
        return m;
    }

    public static Matrix4 scale(float s) {
        return scale(s, s, s);
    }

    public static Matrix4 rotationXYZ(double a, int idx) { // a - corner, idx - axis
        Matrix4 m = Matrix4.one();
        if (idx < 0 || idx > 2) {
            return m;
        }
        int a1 = (idx + 1) % 3;
        int a2 = (idx + 2) % 3;
        m.setAt(a1, a1, (float) Math.cos(a));
        m.setAt(a1, a2, (float) Math.sin(a));
        m.setAt(a2, a1, -(float) Math.sin(a));
        m.setAt(a2, a2, (float) Math.cos(a));
        return m;
    }

    public static enum Axis {X, Y, Z}

    public static Matrix4 rotationXYZ(double a, Axis q){
        return rotationXYZ(a, q == Axis.X ? 0 : q == Axis.Y ? 1 : 2);
    }

    public static Matrix4 translation(float dx, float dy, float dz){
        Matrix4 m = Matrix4.one();
        m.setAt(0, 3, dx);
        m.setAt(1, 3, dy);
        m.setAt(2, 3, dz);
        return m;
    }

    public static Matrix4 translation(Vector3 v){
        return translation(v.getX(), v.getY(), v.getZ());
    }

    public static Matrix4 centralProjection(float coef, int idx){
        Matrix4 m = Matrix4.one();
        if (idx < 0 || idx > 2){
            return m;
        }
        m.setAt(3, idx, 1/coef);
        return m;
    }

    public static Matrix4 centralProjection(float coef, Axis axis){ //todo
        Matrix4 m = Matrix4.one();
        if (idx < 0 || idx > 2){
            return m;
        }
        m.setAt(3, idx, 1/coef);
        return m;
    }
}
