package boj.p10k.p10900;


import java.util.Scanner;


public class P10984 {

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
while(n-- > 0) {
int m = sc.nextInt();
int gradeSum = 0;
float scoreSum = 0;
for(int i = 0; i < m; i++) {
int a = sc.nextInt();
double b = sc.nextDouble();
gradeSum += a;
scoreSum += a * b;
            }
System.out.println(gradeSum + " " + Math.round(scoreSum*10/gradeSum)/10.0);
        }
    }	
}
