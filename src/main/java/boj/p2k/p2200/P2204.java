package boj.p2k.p2200;


import java.util.*;
import java.io.*;


public class P2204 {
        public static void main(String [] args) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            while(true){
                String str = in.readLine();
                if(str.equals("0")){
                    break;
                }
                List<String> li = new ArrayList<>();
                for(int i=0; i < Integer.parseInt(str); i++){
                    li.add(in.readLine());
                }
                li.sort(String::compareToIgnoreCase);
                System.out.println(li.get(0));
            }
        }
    }
