package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiResult = getMaxNumber(pobi);
        if (pobiResult == -1) return -1;
        int crongResult = getMaxNumber(crong);
        if (crongResult == -1) return -1;

        if (pobiResult > crongResult) return 1;
        else if (pobiResult < crongResult) return 2;
        return 0;
    }

    public static int getMaxNumber(List<Integer> li) {
        if(li.size() != 2) return -1;
        if (li.get(0) - li.get(1) != -1) return -1;
        List<Integer> result = new ArrayList<>();

        for (Integer integer : li) {
            if (integer <= 1 && integer >= 400) return -1;
            int sum = 0;
            int mul = 1;
            while (integer >= 10) {
                int now = integer % 10;
                sum += now;
                mul *= now;
                integer /= 10;
            }
            result.add(sum + integer);
            result.add(mul * integer);
        }

        result.sort((a, b) -> a - b);
        return result.get(3);
    }
}