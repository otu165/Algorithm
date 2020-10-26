package silver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BJ_2750 {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        while(n-- > 0) {
            list.add(Integer.parseInt(br.readLine()));
        }

        list.sort(Integer::compareTo);

        for(int l : list) {
            bw.write(l + "\n");
        }

        bw.flush();
        bw.close();
    }
}
