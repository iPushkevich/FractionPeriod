package by.pushkevich;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        runApp();
    }


    static void getResult(String line) {
        int n = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '/') n = i;
        }
        int leftN = Integer.parseInt(line.substring(0, n));
        int rightN = Integer.parseInt(line.substring(n + 1));

        if (leftN % rightN == 0) System.out.println(leftN / rightN);

        else {
            List<String> list = new ArrayList<>();
            String out = "";
            out += leftN / rightN + ".";
            leftN = leftN % rightN;
            boolean crash = true;
            int start = 0;
            String tmp = "";

            while (crash) {
                if (leftN == 0) {
                    tmp = out;
                    break;
                }
                int y = leftN * 10 / rightN;
                leftN = leftN * 10 - (leftN * 10 / rightN) * rightN;
                String x = (leftN + "." + y);
                if (!list.contains(x)) {
                    out += y;
                    list.add(x);
                    crash = true;
                } else {
                    start = list.indexOf(x);
                    int br = out.indexOf(".") + 1 + start;
                    tmp = out.substring(out.indexOf(".") + 1 + start);
                    tmp = out.substring(0, br) + "(" + tmp + ")";
                    crash = false;
                }
            }
            System.out.println(tmp);
        }
    }

    static void runApp() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = reader.readLine();
            getResult(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
