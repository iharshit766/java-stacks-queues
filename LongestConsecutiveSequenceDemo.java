import java.util.HashSet;

class LongestConsecutiveSequence {
    public static int findLongestConsecutiveSequence(int[] arr) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : arr) {
            numSet.add(num);
        }
        
        int longestStreak = 0;
        
        for (int num : arr) {
            if (!numSet.contains(num - 1)) { // Check if it's the start of a sequence
                int currentNum = num;
                int currentStreak = 1;
                
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        
        return longestStreak;
    }
}

public class LongestConsecutiveSequenceDemo {
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        int longestSequence = LongestConsecutiveSequence.findLongestConsecutiveSequence(arr);
        System.out.println("Longest Consecutive Sequence Length: " + longestSequence);
    }
}
