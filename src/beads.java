import java.io.*;

public class beads {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

        int n = Integer.parseInt(in.readLine());
        String s = in.readLine();

        int max = 0;

        for (int i = 0; i < n; i++) {
            // go right
            int rShift = 0;
            int rStart = 0;
            while (s.charAt((i + rStart) % n) == s.charAt((i + rShift) % n) && rShift < n) {
                if (s.charAt((i + rStart) % n) == 'w')
                    rStart++;
                rShift++;
            }
            // go left
            int lShift = 0;
            int lStart = 0;
            while (s.charAt((((i - lStart - 1) % n) + n) % n) == s.charAt((((i - lShift - 1) % n) + n) % n) && lShift < n) {
                if (s.charAt((((i - lStart - 1) % n) + n) % n) + n == 'w')
                    rStart++;
                lShift++;
            }

            // set max
            if (rShift + lShift > max) {
                max = rShift + lShift;
            }
        }
        out.println(max);
        out.close();
    }
}
