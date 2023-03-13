package solving;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Median {
    public static float getMedian(List<Integer> data) {
        Collections.sort(data);
        // 3, 10, 2, 4, 5, 6, 7, 8, 2
        // 2, 2, 3, 4, 5, 6, 7, 8, 10
        if (data.size() % 2 != 0) return data.get(data.size()/2);
        return (data.get(data.size()/2) + data.get(data.size()/2-1)) / 2;
    }
}
