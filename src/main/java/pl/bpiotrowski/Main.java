package pl.bpiotrowski;

import java.util.*;

public class Main {

    public static void main(String[] Args) {
        Scanner scanInt = new Scanner(System.in);
        Scanner scanStr = new Scanner(System.in);
        int clusters = scanInt.nextInt();
        int clusterSize = scanInt.nextInt();
        Map<String, Integer> files = new HashMap<>();
        String commad;

        while ((commad = scanStr.nextLine()) != null) {
            String[] args = commad.split(" ");
            switch (args[0]) {
                case "CREATE": {
                    files.put(args[1], 0);
                    break;
                }
                case "DELETE": {
                    files.remove(args[1]);
                    break;
                }
                case "WRITE": {
                    files.put(args[1], files.get(args[1]) + Integer.parseInt(args[2]));
                    break;
                }
                case "TRUNCATE": {
                    files.put(args[1], files.get(args[1]) - Integer.parseInt(args[2]));
                    break;
                }
            }
        }

        int bytes = 0;
        for (String s : files.keySet()) {
            bytes += files.get(s);
        }
        System.out.println(((clusters * clusterSize) - bytes) / clusterSize);
    }
}
