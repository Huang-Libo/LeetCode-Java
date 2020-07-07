import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 **/
public class _3_longest_substring_without_repeating_characters {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "cabdabcbb";
        System.out.println(solution.lengthOfLongestSubstring(str));
    }

    public static class Solution {
        // 解法：滑动窗口
        public int lengthOfLongestSubstring(String s) {
            int ans = 0, n = s.length();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0, j = 0; j < n; j++) {
                Character ch = s.charAt(j);
                if (map.containsKey(ch)) {
                    i = Math.max(i, map.get(ch) + 1); // 当前遇到的字符可能在之前被跳过了，所以索引可能会比 i 小
                }
                ans = Math.max(ans, j - i + 1);
                map.put(ch, j);
            }
            return ans;
        }
    }
}
