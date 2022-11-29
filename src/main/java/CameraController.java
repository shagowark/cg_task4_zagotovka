import math.Matrix4;
import math.Matrix4Factories;
import math.Vector3;
import math.Vector4;
import screen.ScreenConverter;
import screen.ScreenPoint;
import third.Camera;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class CameraController implements MouseListener, MouseMotionListener, MouseWheelListener {
    private Camera camera;
    private boolean left, right, middle;
    private ScreenConverter sc;
    private ScreenPoint prev = null;

    public static interface RepaintListener{
        void repaint();
    }

    private RepaintListener repaintListener = null;

    public RepaintListener getRepaintListener() {
        return repaintListener;
    }

    public void setRepaintListener(RepaintListener repaintListener) {
        this.repaintListener = repaintListener;
    }

    public void onRepaint(){
        if (repaintListener != null){

        }
    }

    public CameraController(Camera c, ScreenConverter sc) {
        this.camera = c;
        this.sc = sc;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)){
            left = true;
        }
        if (SwingUtilities.isRightMouseButton(e)){
            right = true;
        }
        if (SwingUtilities.isMiddleMouseButton(e)){
            middle = true;
        }
        if (prev == null && (left || middle || right)){
            prev = new ScreenPoint(e.getX(), e.getY());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)){
            left = false;
        }
        if (SwingUtilities.isRightMouseButton(e)){
            right = false;
        }
        if (SwingUtilities.isMiddleMouseButton(e)){
            middle = false;
        }
        if (prev == null && (left || middle || right)){
            prev = new ScreenPoint(e.getX(), e.getY());
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (prev == null){
            return;
        }
        ScreenPoint cur = new ScreenPoint(e.getX(), e.getY());
        int dx = cur.getX() - prev.getX();
        int dy = cur.getY() - prev.getY();
        if (left){
            double da = dx * Math.PI / 180;
            double db = dy * Math.PI / 180;
            camera.modifyRotate(Matrix4Factories.rotationXYZ(da, Matrix4Factories.Axis.X)
                    .mul(Matrix4Factories.rotationXYZ(db, Matrix4Factories.Axis.Y)));
        }
        if (right){
            Vector3 z = new Vector4(sc.s2r(new ScreenPoint(0, 0)), 0);
            Vector3 c = new Vector4(sc.s2r(new ScreenPoint(dx, dy)), new ScreenPoint(0, 0));
            Vector3 delta = sc.s2r(new ScreenPoint(-dx, -dy));
            camera.modifyTranslate(Matrix4Factories.translation(delta));
        }

        prev = cur;
        onRepaint();

        if (middle){
            Vector4 z = new Vector4(sc.s2r(new ScreenPoint(0, 0)), 0);
            Vector4 c = new Vector4(sc.s2r(new ScreenPoint(dx, dy)), 0);
            float len //todo
            Vector3 delta = sc.s2r(new ScreenPoint(-dx, -dy));
            camera.modifyTranslate(Matrix4Factories.translation(delta));
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }
}
