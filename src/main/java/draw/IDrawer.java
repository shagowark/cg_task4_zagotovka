package draw;

import third.Polyline3D;

import java.awt.*;
import java.util.Collection;
import java.util.Collections;

public interface IDrawer {
    void clear(Color c);
    void draw(Collection<Polyline3D> lines);
}
