// Write a java program to implement interval scheduling
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Interval[] intervals = {
            new Interval(1, 3),
            new Interval(2, 4),
            new Interval(5, 7),
            new Interval(6, 8),
            new Interval(9, 11),
            new Interval(10, 12)
        };
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        List<Interval> selectedIntervals = new ArrayList<>();
        int lastEndTime = 0;
        for (Interval interval : intervals) 
        if (interval.start >= lastEndTime) {
            selectedIntervals.add(interval);
            lastEndTime = interval.end;
        }
        for (Interval interval : selectedIntervals) System.out.println(interval);
    }
}
class Interval {
    int start, end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public String toString() {return "[" + start + ", " + end + "]";}
}