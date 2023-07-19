package boj.p10k.p10800;


import java.io.*;
import java.util.*;

public class P10823 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder statementStr = new StringBuilder();

        List<Integer> list = new ArrayList<>();
        String input;
        while ((input = in.readLine()) != null) {
            statementStr.append(input);
        }

        StringTokenizer st = new StringTokenizer(statementStr.toString(), ",");
        while (st.hasMoreTokens()) {
            list.add(Integer.valueOf(st.nextToken()));
        }

        System.out.println(list.stream().mapToInt(Integer::intValue).sum());
    }

}
