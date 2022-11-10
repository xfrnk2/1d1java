import java.io.*;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface P8595{
    static void main(String[]a) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        BigDecimal sum = new BigDecimal("0");
        String str = br.readLine();
        String regex = "([\\d]+)";
        Matcher matcher = Pattern.compile(regex).matcher(str);
        while(matcher.find()) {
          sum = sum.add(new BigDecimal(matcher.group()));
        }
        bw.write(sum+"");        
        bw.flush(); 
      }
}
