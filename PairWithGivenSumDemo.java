import java.util.HashSet;

class PairWithGivenSum {
    public static boolean hasPairWithSum(int[] arr, int target) {
        HashSet<Integer> seen = new HashSet<>();
        
        for (int num : arr) {
            if (seen.contains(target - num)) {
                return true;
            }
            seen.add(num);
        }
        
        return false;
    }
}

public class PairWithGivenSumDemo {
    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 12, 15};
        int target = 19;
        
        boolean result = PairWithGivenSum.hasPairWithSum(arr, target);
        System.out.println(result ? "Pair found" : "No pair found");
    }
}
