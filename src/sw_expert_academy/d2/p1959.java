package sw_expert_academy.d2;

import java.util.*;
import java.io.*;


class p1959
{
    
    private static int[] swap (int[] array1, int[] array2) {
    	return array1;
    }    
    
    private static int getMaximumValue (int[] array1, int[] array2) {
        int ans = 0;
        for (int i = 0; i < array2.length - array1.length + 1; i ++) {
            int s = 0;
        	for (int j = 0; j < array1.length; j ++) {
				s += array1[j] * array2[i + j];
            }
            ans = Math.max(ans, s);
        }
        return ans;
    }
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < t; i ++) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
            	st = new StringTokenizer(br.readLine());
            	int array1[] = new int[n];
            	int array2[] = new int[m];
            
            	for (int j = 0; j < n; j ++) {
                	array1[j] = Integer.parseInt(st.nextToken());
                }
            	st = new StringTokenizer(br.readLine());
            	for (int j = 0; j < m; j ++) {
                	array2[j] =Integer.parseInt(st.nextToken());
                }
                if (n > m) {
                    array2 = swap(array1, array1 = array2);
                    }
                int ans = getMaximumValue(array1, array2);
            	System.out.println(String.format("#%d %d", i + 1, ans));
        	}
		}
	}
