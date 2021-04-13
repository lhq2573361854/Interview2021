package com.tianling.dfs;

/**
 * @author Tianling
 * @email 859073143@qq.com
 * @since 2021/4/13 16:22
 */
public class EightQueens {
    int len  = 8;
    int[] arr = new int[len + 1];
    public void solution(){
        int i =  1;
        while(i >= 1 ){
            arr[i] ++ ;
            // 放不了的话
            while (arr[i] <= len && !place(i)){
                arr[i] ++;
            }
            if(arr[i] <= len){
                if( i == len){
                    for (int j = 1; j <= len; j++) {
                        System.out.print(arr[j] + " ");
                    }
                    System.out.println();
                }else{
                    i++;
                    arr[i] = 0;
                }
            }else{
                i --;
            }
        }
    }

    public boolean place(int i){
        int j = 1;
        if(i == 1){
            return true;
        }
        while(j < i){
            if((arr[i] == arr[j]) || (Math.abs(arr[i] - arr[j]) == Math.abs(i-j))){
                return false;
            }
            j++;
        }

        return true;
    }

    public static void main(String[] args) {
    }

}







