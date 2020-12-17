package aoc.points;

import javax.vecmath.Point3i;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AOCPoint4i extends Point3i implements Comparable<AOCPoint4i> {
    public int w;
    public AOCPoint4i(int x, int y, int z, int w) {
        super(x, y, z);

        this.w = w;
    }

    public List<AOCPoint4i> neighbours() {
        List<AOCPoint4i> pList = new ArrayList<>();
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                for (int z = -1; z < 2; z++) {
                    for (int w = -1; w<2; w++) {
                        AOCPoint4i e = new AOCPoint4i(this.x + x, this.y + y, this.z + z, this.w +w);
                        if (!e.equals(this)) {

                            pList.add(e);
                        }
                    }

                }
            }
        }
        return pList;
    }

    @Override
    public int compareTo(AOCPoint4i p) {
        return this.x == p.x? this.y == p.y? this.z == p.z?
            Integer.compare(this.w, p.w):
            Integer.compare(this.z, p.z):
            Integer.compare(this.y, p.y):
            Integer.compare(this.x, p.x);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AOCPoint4i that = (AOCPoint4i) o;
        return w == that.w;
    }

}
