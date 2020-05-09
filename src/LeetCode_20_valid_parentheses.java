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
public class LeetCode_20_valid_parentheses {
    public static void main(String[] args) {
        LeetCode_20_valid_parentheses leetCode_20_valid_parentheses = new LeetCode_20_valid_parentheses();
        String str = "{[]}";
        System.out.println(leetCode_20_valid_parentheses.isValid(str));
    }

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

    // 方法二：贴一个网友用 python 写的代码，很有创意
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
