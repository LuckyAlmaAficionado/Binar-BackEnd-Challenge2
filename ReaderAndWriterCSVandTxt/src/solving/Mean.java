package solving;

import java.text.DecimalFormat;
import java.util.List;

public class Mean {
    public static float getMean(List<Integer> data) {
        float result = 0;
        for(Integer x : data) result += x;
        return result / data.size();
    }
}
