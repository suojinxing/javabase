package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class T1 {
    private static final Logger logger = Logger.getLogger(String.valueOf(T1.class));

    /**
     * 给定一个数组nums和值target，在数组中找到两个数相加=target，输出他们的下标
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] n = new int[]{1,2};
        int[] nums = {2, 11, 7, 9, 5, 3, 10};
        int target = 20;
        findSpecificIndex2(nums, target);
    }

    public static void findSpecificIndex(int[] nums, int target) {
        // 将值和索引存储起来
        Map valToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            valToIndex.put(nums[i], i);
        }
        // 从小到大排列数组
        Arrays.sort(nums);
        logger.info(Arrays.toString(nums));

        // 比最小的数还小，肯定不行！
        if (target < nums[0]) {
            logger.warning("数组中没有指定的数");
            return;
        }

        // 记录边界值——nums[i]<=target的那个索引值
        int boundary = -1;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                boundary = i;
            }
        }
        logger.info(String.format("缩进的取值范围在 [0,%s]", boundary));

        for (int i = 0; i <= boundary; i++) {
            int difference = target - nums[i];
            for (int j = i + 1; j <= boundary; j++) {
                if (difference == nums[j]) {
                    System.out.println(String.format("找到了！下标是[%s,%s]", valToIndex.get(nums[i]), valToIndex.get(nums[j])));
                }
            }
        }
    }

    public static void findSpecificIndex2(int[] nums, int target) {
        // 将值和索引存储起来
        Map valToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            valToIndex.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (difference == nums[j]) {
                    System.out.println(String.format("找到了！下标是[%s,%s]", valToIndex.get(nums[i]), valToIndex.get(nums[j])));
                }
            }
        }
    }
}
