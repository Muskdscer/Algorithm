package com.example.algorithm.dp;

import org.apache.logging.log4j.util.Strings;

public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        String[] strings = (N + "").split("");
        int start = strings.length;
        for (int i = strings.length -1; i > 0; i++) {
            if (Integer.parseInt(strings[i - 1]) > Integer.parseInt(strings[i])) {
                strings[i -1] = (Integer.parseInt(strings[i - 1]) - 1) + "";
                start = i;
            }
        }

        for (int i = start; i < strings.length; i++) {
            strings[i] = "9";
        }

        return Integer.parseInt(String.join("",strings));
    }
}
