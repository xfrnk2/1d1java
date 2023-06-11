package boj.p1k.p1400;


import java.util.*;
import java.io.*;

public class P1475 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int arr[] = new int[10];
        
		for(char c : br.readLine().toCharArray()) {
			int num = c - '0';
			
			if(num == 9) { 
				num = 6;
            }
			arr[num]++;
		}
        
		arr[6] = (arr[6] / 2) + (arr[6] % 2);
		
		Arrays.sort(arr); 
		
		System.out.println(arr[9]);
	}
}
