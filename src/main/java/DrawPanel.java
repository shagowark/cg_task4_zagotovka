import draw.IDrawer;
import draw.SimpleEdgeDrawerImpl;
import math.Matrix4;
import math.Matrix4Factories;
import math.Vector3;
import models.Line3D;
import models.Parallelpiped;
import screen.ScreenConverter;
import third.Camera;
import third.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel {
    private ScreenConverter sc;
    private Scene scene;
    private Camera camera;
    private CameraController cameraController;


    private Point last = null;

    public DrawPanel() {
        sc = new ScreenConverter(800, 600, -1, 1, 2, 2);
        camera = new Camera();
        scene = new Scene(new Color(234, 229, 229));
        scene.getModels().add(new Line3D(
                new Vector3(0,0,0),
                new Vector3(1, 0, 0)));
        scene.getModels().add(new Line3D(
                new Vector3(0,0,0),
                new Vector3(0, 1, 0)));
        scene.getModels().add(new Line3D(
                new Vector3(0,0,0),
                new Vector3(0, 0, 1)));
        scene.getModels().add(new Parallelpiped(
                new Vector3(0.2f, 0.2f, 0.2f),
                new Vector3(0.2f, 0.2f, 0.2f)
        ));

        cameraController = new CameraController(camera, sc);
        cameraController.setRepaintListener(new CameraController.RepaintListener() {
            @Override
            public void repaint() {
                DrawPanel.this.repaint();
            }
        });
        this.addMouseMotionListener();
        this.addMouseListener();
        this.addMouseWheelListener();

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                last = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                last = null;
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point cur = e.getPoint();
                if (last != null){
                    int dx = cur.x - last.x;
                    int dy = cur.y - last.y;
                    double da = dx * Math.PI / 180;
                    double db = dy * Math.PI / 180;
                    camera.modifyRotate(Matrix4Factories.rotationXYZ(da, Matrix4Factories.Axis.X)
                            .mul(Matrix4Factories.rotationXYZ(db, Matrix4Factories.Axis.Y)));
                }
                last = cur;
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        sc.setSize(getWidth(), getHeight());
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D gr = bi.createGraphics();
        IDrawer d = new SimpleEdgeDrawerImpl(gr, sc);
        //
        scene.draw(camera, d);
        //
        g.drawImage(bi, 0, 0, null);
        gr.dispose();
    }
}
