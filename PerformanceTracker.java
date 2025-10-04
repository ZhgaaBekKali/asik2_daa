package asik2_daa;

import java.util.*;

public class PerformanceTracker {
    private Map<String, List<Long>> timeMetrics;
    private Map<String, List<Integer>> operationMetrics;

    public PerformanceTracker() {
        timeMetrics = new HashMap<>();
        operationMetrics = new HashMap<>();
    }

    public void trackTime(String operation, long time) {
        timeMetrics.computeIfAbsent(operation, k -> new ArrayList<>()).add(time);
    }

    public void trackOperations(String operation, int comparisons, int swaps) {
        String key = operation + "_comparisons";
        operationMetrics.computeIfAbsent(key, k -> new ArrayList<>()).add(comparisons);

        key = operation + "_swaps";
        operationMetrics.computeIfAbsent(key, k -> new ArrayList<>()).add(swaps);
    }

    public void printMetrics() {
        System.out.println("=== Performance Metrics ===");
        for (String op : timeMetrics.keySet()) {
            List<Long> times = timeMetrics.get(op);
            double avgTime = times.stream().mapToLong(Long::longValue).average().orElse(0);
            System.out.printf("%s: avg time = %.3f ms (samples: %d)%n", op, avgTime, times.size());
        }

        for (String op : operationMetrics.keySet()) {
            List<Integer> ops = operationMetrics.get(op);
            double avgOps = ops.stream().mapToInt(Integer::intValue).average().orElse(0);
            System.out.printf("%s: avg = %.1f operations%n", op, avgOps);
        }
    }
}