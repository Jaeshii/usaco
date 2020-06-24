/*
ID: Jaeshi
LANG: JAVA
TASK: beads
*/

import java.io.*;

public class beads1 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

        int n = Integer.parseInt(in.readLine());
        String s = in.readLine();

        int max = 0;

        for (int i = 0; i < n; i++) {
            int rShift = 0;
            char rStart = s.charAt(i);
            char rCurr;
            if (rStart == 'w') {
                int rrShift = 0;
                char rrCurr;
                do {
                    rrCurr = s.charAt((i + rrShift) % n);
                    if ((rrCurr == 'r' || rrCurr == 'w') && rrShift <= n)
                        rrShift += 1;
                }
                while ((rrCurr == 'r' || rrCurr == 'w') && rrShift <= n);
                int brShift = 0;
                char brCurr;
                do {
                    brCurr = s.charAt((i + brShift) % n);
                    if ((brCurr == 'b' || brCurr == 'w') && brShift <= n)
                        brShift += 1;
                }
                while ((brCurr == 'b' || brCurr == 'w') && brShift <= n);
                rShift = rrShift >= brShift ? rrShift: brShift;


            } else {
                do {
                    rCurr = s.charAt((i + rShift) % n);
                    if ((rCurr == rStart || rCurr == 'w') && rShift <= n)
                        rShift += 1;
                }
                while ((rCurr == rStart || rCurr == 'w') && rShift <= n);
            }

            int lShift = -1;
            char lStart = s.charAt(((i + lShift) % n + n) % n);
            char lCurr;

            if (lStart == 'w') {
                int rlShift = 0;
                char rlCurr;
                do {
                    rlCurr = s.charAt(((i + rlShift) % n + n) % n);
                    if ((rlCurr == 'r' || rlCurr == 'w') && Math.abs(rlShift) - 1 <= n)
                        rlShift -= 1;
                }
                while ((rlCurr == 'r' || rlCurr == 'w') && Math.abs(rlShift) - 1 <= n);
                int blShift = 0;
                char blCurr;
                do {
                    blCurr = s.charAt(((i + blShift) % n + n) % n);
                    if ((blCurr == 'b' || blCurr == 'w') && Math.abs(blShift) - 1 <= n)
                        blShift -= 1;
                }
                while ((blCurr == 'b' || blCurr == 'w') && Math.abs(blShift) - 1 <= n);
                lShift = rlShift >= blShift ? rlShift: blShift;


            } else {
                do {
                    lCurr = s.charAt(((i + lShift) % n + n) % n);
                    if ((lCurr == lStart || lCurr == 'w') && Math.abs(lShift) - 1 <= n)
                        lShift -= 1;
                }
                while ((lCurr == lStart || lCurr == 'w') && Math.abs(lShift) - 1 <= n);
            }

            if (rShift + Math.abs(lShift) - 1 > max) {
                max = rShift + Math.abs(lShift) - 1;
            }

        }

        out.println(max);
        out.close();
    }


}
