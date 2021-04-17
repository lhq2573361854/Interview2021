package com.tianling;

import java.util.Scanner;

/**
 * @author Tianling
 * @email 859073143@qq.com
 * @since 2021/4/8 9:48
 */
public class Main {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int sum = Integer.parseInt(scanner.nextLine());
        int currentSum = str.charAt(0) - 'a' + 1;
        int len = 0;
        int i = 0;
        int j = 0;
        while (true){
            if(j > i || j == str.length() - 1){
                break;
            }

            if(currentSum == sum){
                len =  Math.max(len,i - j + 1);

            }
            if(i < str.length() - 1 &&  currentSum + (str.charAt(i + 1) - 'a' + 1 ) <= sum ){
                i++;
                currentSum += (str.charAt(i) - 'a' + 1);
            }else if(i < str.length() - 1 && j == i){
                currentSum -= (str.charAt(j) -'a' + 1) ;
                j++;
                i++;
                currentSum += (str.charAt(j) -'a' + 1) ;
            } else{
                currentSum -= (str.charAt(j) -'a' + 1) ;
                j++;
            }
        }
        System.out.println(len);



    }



}
