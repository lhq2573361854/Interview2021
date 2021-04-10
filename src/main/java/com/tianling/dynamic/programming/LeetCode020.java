package com.tianling.dynamic.programming;

import java.util.Stack;

/**
 * @author Tianling
 * @email 859073143@qq.com
 * @since 2021/4/10 20:08
 */
public class LeetCode020 {
    public boolean isValid(String s) {
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(characters.isEmpty()){
                characters.push(s.charAt(i));
            } else if(s.charAt(i) == ')' &&  characters.peek() == '('){
                characters.pop();
            }else if(s.charAt(i) == '}' &&  characters.peek() == '{'){
                characters.pop();
            }else if(s.charAt(i) == ']' &&  characters.peek() == '['){
                characters.pop();
            }else {
                characters.push(s.charAt(i));
            }

        }
        return characters.empty();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode020().isValid("(){}}{"));

    }
}
