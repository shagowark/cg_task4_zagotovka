package third;

import math.Matrix4;
import math.Matrix4Factories;
import math.Vector3;
import math.Vector4;

public class Camera implements ICamera {
    private Matrix4 translate, rotate, scale, projection;

    public Camera() {
        translate = Matrix4.one();
        rotate = Matrix4.one();
        scale = Matrix4.one();
        projection = Matrix4.one();
        projection = Matrix4Factories.centralProjection(5, Matrix4Factories.Axis.Z);
    }

    @Override
    public Vector3 w2s(Vector3 v) {
        return projection.mul(
                translate.mul(
                        rotate.mul(
                                scale.mul(
                                        new Vector4(v, 1)
                                )
                        )
                )
        ).asV3();
    }

    public void modifyRotate(Matrix4 m) {
        this.rotate = m.mul(this.rotate);
    }

    public void modifyTranslate(Matrix4 m) { // todo переделать
        this.rotate = m.mul(this.rotate);
    }
}
