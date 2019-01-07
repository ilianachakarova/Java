package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    int n = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        int sum  =0;
        String combination = "";
	    for (char a = 'B'; a<='L'; a+=2){
	        for(char b = 'f'; b>='a';b--){
	            for(char c = 'A'; c<='C'; c++){
	                for(int d = 1;d<=10; d++){
	                    for(int e = 10; e>=1; e--){
	                        counter++;

                            sum = a+b+c+d+e;
	                        if(counter==n){
                                System.out.printf("Ticket combination: %c%c%c%d%d%n", a,b,c,d,e);
                                System.out.printf("The price is: %d lv", sum);
                            }
                        }
                    }
                }
            }
        }


    }
}
