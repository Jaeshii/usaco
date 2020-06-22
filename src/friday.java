/*
ID: Jaeshi
LANG: JAVA
TASK: friday
*/

import java.io.*;

public class friday {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

        int N = Integer.parseInt(in.readLine());
        int D = 0;
//        int offset;
        int[] weekdays = {0, 0, 0, 0, 0, 0, 0};


        for (int year = 0; year < N; year++) {
            for (int month = 0; month < 12; month++) {
                // select correct number of days per month
                int numDays;
                if (month == 3 || month == 5 || month == 8 || month == 10)
                    numDays = 30;
                else if (month == 0 || month == 2 || month == 4 || month == 6 || month == 7 || month == 9 || month == 11)
                    numDays = 31;
                else
                    if ((1900 + year) % 400 == 0)
                        numDays = 29;
                    else if ((1900 + year) % 4 == 0 && (1900 + year) % 100 != 0)
                        numDays = 29;
                    else
                        numDays = 28;
                // iterate through days in month, adding them to D (total number of days)
                for (int day = 1; day <= numDays; day++) {
                    if (day == 13)
                        weekdays[D % 7]++;
                    D++;
                }
//
//                if (month == 3 || month == 5 || month == 7 || month == 10) {
//                    for (int day = 1; day <= 30; day++) {
//                        if (day == 13)
//                            weekdays[D % 7]++;
//                        D++;
//                    }
//                } else if (month == 0 || month == 2 || month == 4 || month == 6 || month == 8 || month == 9 || month == 11) {
//                    for (int day = 1; day <= 31; day++) {
//                        if (day == 13)
//                            weekdays[D % 7]++;
//                        D++;
//                    }
//                } else {
//                    if ((1900 + N) % 100 == 0)
//                         offset = 1;
//                    else if ((1900 + N) % 4 == 0)
//                        offset = -1;
//                    else
//                        offset = 0;
//                    for (int day = 1; day <= 28 + offset; day++) {
//                        if (day == 13)
//                            weekdays[D % 7]++;
//                        D++;
//                    }
//                }
            }
        }

//        for (int i = 5; i < weekdays.length + 5; i++) {
//            out.print(weekdays[i % 7] + " ");
//        }
        out.println(weekdays[5] + " " + weekdays[6] + " " + weekdays[0] + " " + weekdays[1] + " " + weekdays[2] + " " + weekdays[3] + " " + weekdays[4]);
        out.close();
    }

}
