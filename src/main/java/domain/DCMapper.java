package domain;

import java.util.LinkedList;
import java.util.List;

public class DCMapper {
    public static List<DC> dcs;

    public static List<DC> getAllDCs() {
        if (dcs == null) {
            dcs = new LinkedList<DC>();
            dcs.add(new DC(0, "Melbourne", 0, 20));
            dcs.add(new DC(1, "Sydney", 1, 30));
            dcs.add(new DC(2, "Brisbane", 2, 10));
        }
        return dcs;
    }

    public static DC findDC(int DCID) {
        for (DC dc : getAllDCs()) {
            if (dc.getDCID() == (DCID)) {
                return dc;
            }
        }
        return null;
    }
}
