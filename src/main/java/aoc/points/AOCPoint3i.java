package aoc.points;

import javax.vecmath.Point3i;
import java.util.ArrayList;
import java.util.List;

public class AOCPoint3i extends Point3i implements Comparable<AOCPoint3i> {

    public AOCPoint3i(int x, int y, int z) {
        super(x, y, z);
    }

    public List<AOCPoint3i> neighbours() {
        List<AOCPoint3i> pList = new ArrayList<>();
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                for (int z = -1; z < 2; z++) {

                    AOCPoint3i e = new AOCPoint3i(this.x + x, this.y + y, this.z + z);
                    if (!e.equals(this)) {

                        pList.add(e);
                    }
                }
            }
        }
        return pList;
    }

    @Override
    public int compareTo(AOCPoint3i p) {
        return this.x == p.x? this.y == p.y? Integer.compare(this.z, p.z):Integer.compare(this.y, p.y):Integer.compare(this.x, p.x);
    }
}
