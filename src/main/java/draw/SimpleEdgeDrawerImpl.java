package draw;

import math.Vector3;
import screen.ScreenConverter;
import screen.ScreenPoint;
import third.Polyline3D;

import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SimpleEdgeDrawerImpl implements IDrawer{
    private Graphics2D g2d;
    private ScreenConverter sc;

    public SimpleEdgeDrawerImpl(Graphics2D g2d, ScreenConverter sc) {
        this.g2d = g2d;
        this.sc = sc;
    }

    @Override
    public void clear(Color c) {
        g2d.setColor(c);
        g2d.fillRect(0, 0, sc.getWidth(), sc.getHeight());
    }

    @Override
    public void draw(Collection<Polyline3D> lines) {
        g2d.setColor(Color.BLACK);
        for (Polyline3D p: lines){
            drawPolyline(g2d, sc, p);
        }
    }

    private static void drawPolyline(Graphics2D g, ScreenConverter sc, Polyline3D p){
        List<ScreenPoint> list = new LinkedList<>();
        for (Vector3 v : p.getPoints()){
            list.add(sc.r2s(v));
        }
        if (p.isClosed()){
            list.add(list.get(0));
        }

        if (list.size() == 0 ){
            return;
        }
        Iterator<ScreenPoint> itr = list.iterator();
        ScreenPoint prev = itr.next();
        if (!itr.hasNext()){
            g.fillRect(prev.getX(), prev.getY(), 1, 1);
            return;
        }
        while (itr.hasNext()){
            ScreenPoint current = itr.next();
            g.drawLine(prev.getX(), prev.getY(), current.getX(), current.getY());
            prev = current;
        }
    }

}
