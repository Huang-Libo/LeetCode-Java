import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 *   左括号必须用相同类型的右括号闭合。
 *   左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串。
 *
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class _20_valid_parentheses {
    public static void main(String[] args) {
        String str = "{[]}";
        Solution solution = new Solution();
        System.out.println(solution.isValid(str));
    }

    public static class Solution {
        // 方法一：使用栈
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '{' || ch == '[' || ch =='(') {
                    stack.push(ch);
                } else {
                    if (stack.size() == 0) return false;
                    char top = stack.pop();
                    if ((ch == '}' && top == '{') || (ch == ']' && top == '[') || (ch == ')' && top == '(')) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }

    // 方法二：贴一个网友用 python 写的代码（从代码层面上来说很有创意；如果考虑时间复杂度，可能不太好）
    /*
    class Solution:
    def isValid(self, s):
        while '{}' in s or '()' in s or '[]' in s:
            s = s.replace('{}', '')
            s = s.replace('[]', '')
            s = s.replace('()', '')
        return s == ''
     */
}
