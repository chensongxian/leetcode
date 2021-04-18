package valid_parentheses;

import java.util.*;

import static javax.swing.UIManager.put;

/**
 * @Description: TODO
 * @author: lucachen
 * @Date: 2021-04-16
 */
public class Solution {
    /**
     * 暴力破解
     *
     * 时间复杂度为 n^2
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        String big = "{}";
        String middle = "[]";
        String small  = "()";

        String replaceStr = s;
        for (int i = 0; i < s.length() /2; i++) {
            if (replaceStr.contains(big)) {
                replaceStr = replaceStr.replace(big ,"");
                continue;
            }
            if (replaceStr.contains(middle)) {
                replaceStr = replaceStr.replace(middle, "");
                continue;
            }
            if (replaceStr.contains(small)) {
                replaceStr = replaceStr.replace(small, "");
                continue;
            }
        }
        if ("".equals(replaceStr)) {
            return true;
        }
        return false;
    }

    /**
     *
     *
     * 时间复杂度为 n
     * @param s
     * @return
     */
    public boolean isValid1(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> strMap = new HashMap<>();
        strMap.put(')', '(');
        strMap.put(']', '[');
        strMap.put('}', '{');

        char[] chars = s.toCharArray();
        Deque<Character> deque = new LinkedList();
        for (char ch : chars) {
            if (deque.isEmpty()) {
                deque.push(ch);
            } else {
                Character first = deque.peekFirst();
                if (strMap.get(ch).equals(first)) {
                    deque.pollFirst();
                } else {
                    deque.push(ch);
                }
            }
        }
        if (deque.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     *
     *
     * 时间复杂度为 n
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Deque<Character> deque = new LinkedList();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (pairs.containsKey(c)) {
                if (deque.isEmpty() || !deque.peek().equals(pairs.get(c))) {
                    return false;
                }
                deque.pop();
            } else {
                deque.push(c);
            }
        }
        if (deque.isEmpty()) {
            return true;
        }
        return false;
    }
}
