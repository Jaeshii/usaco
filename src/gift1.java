/*
ID: Jaeshi
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.StringTokenizer;

class gift1 {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

        // populate array
        int numFriends = Integer.parseInt(f.readLine());
        Friend[] friends = new Friend[numFriends];
        for (int i = 0; i < numFriends; i++) {
            friends[i] = new Friend(f.readLine());
        }
        // for each gifter, divide up the amount among friends and adjust balances accordingly
        String gifter;
        while ((gifter = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int amount = Integer.parseInt(st.nextToken());
            int numRecievers = Integer.parseInt(st.nextToken());
            if (numRecievers == 0) {
                continue;
            }
            int receiverAmount = amount / numRecievers;
            int leftOverAmount = amount % numRecievers;

            // subtract from gifter's balance
            int index = 0;
            for (index = 0; index < friends.length; index++) {
                if (friends[index].getName().equals(gifter)) {
                    friends[index].withdraw(amount);
                    friends[index].deposit(leftOverAmount);
                    break;
                }
            }

            // add to recievers' balance
            for (int i = 0; i < numRecievers; i++) {
                String receiver = f.readLine();
                int index1 = 0;
                for (index1 = 0; index1 < friends.length; index1++) {
                    if (friends[index1].getName().equals(receiver)) {
                        friends[index1].deposit(receiverAmount);
                        break;
                    }
                }
            }
        }

        // output
        for (Friend friend : friends) {
            System.out.println(friend.toString());
            out.println(friend.getName() + " " + friend.getBalance());
        }
        out.close();
    }
}

class Friend {
    private String name;
    private int balance;

    public Friend(String name) {
        this.name = name;
        balance = 0;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public String toString() {
        return (name + ": " + balance);
    }
}