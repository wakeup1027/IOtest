package com.io.test.sysin;

import java.math.BigDecimal;
import java.util.Scanner;

public class demo {
	
	public static BigDecimal factorial(int n){   
        BigDecimal result = new BigDecimal(1);  
        BigDecimal a;  
        for(int i = 2; i <= n; i++){  
            a = new BigDecimal(i);//将i转换为BigDecimal类型  
            result = result.multiply(a);//不用result*a，因为BigDecimal类型没有定义*操作</span><span>  
        }  
        return result;  
    } 
	
	public static BigDecimal factorial(BigDecimal n){  
        BigDecimal bd1 = new BigDecimal(1);//1  
        if(n.equals(new BigDecimal(1))){  
            return bd1;  
        }  
        else  
            return n.multiply(factorial(n.subtract(bd1)));//n*f(n-1)  
    }

	public static void main(String[] args) {
		/*Scanner sc = new Scanner(System.in);  
        int a = sc.nextInt();//读取控制台输入的整数  
        System.out.println(a + "!=" + factorial(a));*/
        
        Scanner sc = new Scanner(System.in);  
        BigDecimal a = sc.nextBigDecimal();  
        BigDecimal result = factorial(a);     
        System.out.println(a + "!=" +result);  
	}

}
