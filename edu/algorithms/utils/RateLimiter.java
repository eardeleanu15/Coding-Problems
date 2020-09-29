package edu.algorithms.utils;

import java.util.Deque;
import java.util.LinkedList;

public class RateLimiter {

    public static final int LIMIT = 5;

    public static final Deque<Long> accessTimes = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 12; i++) {
            if (i != 0) {
                Thread.sleep(200);
            }
            String weather = getWeather();
            System.out.println("Iteration " + i + " Weather: " + weather);
        }
    }

    public static String getWeather() {
        if (!rateLimitReached()) {
            return "Sunny";
        }
        return "";
    }

    private static boolean rateLimitReached() {
        boolean result = true;
        long accessTime = System.currentTimeMillis();
        if (accessTimes.size() < LIMIT) {
            accessTimes.addLast(accessTime);
            result = false;
        } else {
            long lastAccessTime = accessTimes.getFirst();
            if (accessTime - lastAccessTime > 1000) {
                accessTimes.removeFirst();
                accessTimes.addLast(accessTime);
                result = false;
            }
        }
        return result;
    }

}
