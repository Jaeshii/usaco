/*
ID: Jaeshi
LANG: JAVA
TASK: ride
*/

import java.io.*;
import java.util.StringTokenizer;

public class ride {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        
        String s1 = f.readLine();
        String s2 = f.readLine();

        int product1 = 1;
        int product2 = 1;

        for (int i = 0; i < s1.length(); i++) {
            product1 *= (int) s1.charAt(i) - 64;
        }
        for (int i = 0; i < s2.length(); i++) {
            product2 *= (int) s2.charAt(i) - 64;
        }

        if (product1 % 47 == product2 % 47) {
            out.println("GO");
        } else {
            out.println("STAY");
        }

        out.close();                                  // close the output file
    }
}
