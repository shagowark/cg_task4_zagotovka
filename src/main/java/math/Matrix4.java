package math;

public class Matrix4 {
    private float[] matrix;

    public Matrix4(float[][] m){
        matrix = new float[16];
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                matrix[i*4 + j] = m[i][j];
            }
        }
    }

    private Matrix4(float[] arr){
        matrix = arr;
    }

    public float getAt(int r, int c){
        return matrix[r*4 + c];
    }

    public void setAt(int r, int c, float v){
        matrix[r * 4 + c] = v;
    }

    public static Matrix4 zero(){
        return new Matrix4(new float[16]);
    }

    public static Matrix4 one(){
        Matrix4 m = zero();
        for (int i = 0; i < 4; i++){
            m.setAt(i,i,1);
        }
        return m;
    }


    public Matrix4 mul(float n){
        float[] a = new float[16];
        for (int i = 0; i < a.length; i++){
            a[i] = matrix[i] * n;
        }

        return new Matrix4(a);
    }

    public Vector4 mul(Vector4 v){
        float[] a = new float[4];
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                a[i] += getAt(i, j) * v.at(j);
            }
        }
        return new Vector4(a[0], a[1], a[2], a[3]);
    }

    public Matrix4 mul(Matrix4 m){
        Matrix4 r = zero();
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                for (int k = 0; k < 4; k++){
                    r.setAt(i, j, r.getAt(i, j) + getAt(i, k) * m.getAt(k,j));
                }
            }
        }
        return r;
    }


}
