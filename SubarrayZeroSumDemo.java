import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

class SubarrayZeroSum {
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;

        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sumMap.containsKey(sum)) {
                for (int start : sumMap.get(sum)) {
                    result.add(new int[]{start + 1, i});
                }
            }

            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }

        return result;
    }
}

public class SubarrayZeroSumDemo {
    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        List<int[]> subarrays = SubarrayZeroSum.findZeroSumSubarrays(arr);

        System.out.println("Subarrays with zero sum:");
        for (int[] subarray : subarrays) {
            System.out.println("Start: " + subarray[0] + ", End: " + subarray[1]);
        }
    }
}
