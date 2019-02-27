import java.util.function.Function;

public final class Lab2 {

    private interface Sorter {
        void sort(int[] list);
    }

    public class SortStats {

        private void swap(int[] list, int i1, int i2) {
            int tmp = list[i1];
            list[i1] = list[i2];
            list[i2] = tmp;
        }

        public double bubbleSort(int[] list) {
            return sort(list, Hw7::bubbleSort);
        }

        public double bubbleShort(int[] list) {
            return sort(list, Hw8::bubbleShort);
        }

        public double selectionSort(int[] list) {
            return sort(list, Hw8::selectionSort);
        }

        public double insertionSort(int[] list) {
            return sort(list, Hw8::insertionSort);
        }
        
        public double sort(int[] list, Sorter s) {
            Stopwatch timer = new Stopwatch();
            timer.start();
            s.sort(list);
            timer.stop();
            return timer.elapsedTime() * .000000001;
        }

        public void runSort(String name, int loop, Function<int[], Double> sorter) {
            double[] times = new double[loop];
            int res = 10;
            for(int i = 0; i < loop; i++) {
                times[i] = sorter.apply(genList(res));
                res *= 10;
            }
            printTable(name, times);
        }
        
        private void printTable(String sort, double[] times) {
            System.out.println(sort+"\n      N     |     Time(sec)    \n-----------------------------");
            int c = 10;
            for(int i = 0; i < times.length; i++) {
                System.out.printf("%9d   |%11.4f %n", c,
                                  times[i]);
                c *= 10;
            }
            System.out.println();
        }
    }
    
    private static int[] genList(int size) {
        int[] list = new int[size];
        for(int i = 0; i < size; i++) {
            list[i] = (int) (Math.random() * size) + 1;
        }
        return list;
    }

    private interface Search {
        void find(int[] arr, int goal);
    }


    public class SearchStats {
        
        public void linearSearch(int[] arr, int goal) {
            for(int i : arr) if(i == goal) break;
        }

        public void binarySearch(int[] arr, int goal) {
            binarySearch(arr, arr[0], arr[arr.length - 1], goal);
        }

        private int binarySearch(int[] arr, int lo, int hi, int goal) {
            int check = lo + (hi - lo) / 2;
            if(goal == arr[check]) return check;
            if(hi - lo <= 1) return -1;
            return (goal < arr[check]) ? binarySearch(arr, lo, check - 1, goal) : binarySearch(arr, check + 1, hi, goal);
        }

        public long calcTime(Search search, int[] arr, int goal) {
            Stopwatch timer = new Stopwatch();
            timer.start();
            search.find(arr, goal);
            timer.stop();
            return timer.elapsedTime();
        }

        public void printTable(long[] linearTimes, long[] binaryTimes) {
            System.out.printf("   %-10s| %-10s| %6s %n", "N", "Linear", "Binary");
            for(int i : new int[34])System.out.print("-");
            System.out.println();
            int c = 10;
            for(int i = 0; i < linearTimes.length; i++) {
                System.out.printf("   %8d  | %7d   |  %4d%n", c, linearTimes[i], binaryTimes[i]);
                c *= 10;
            }
        }

        public void run(int loop) {
            Lab2.SearchStats q2 = new Lab2().new SearchStats();
            long[] linearTimes = new long[loop];
            long[] binaryTimes = new long[loop];
            int c = 10;
            for(int i = 0; i < loop; i++) {
                int[] arr = genList(c);
                int goal = arr[(int) (Math.random() * c)];
                linearTimes[i] = calcTime(q2::linearSearch, arr, goal);
                binaryTimes[i] = calcTime(q2::binarySearch, arr, goal);
                c *= 10;
            }
            printTable(linearTimes, binaryTimes);
        }
    }

    public static void main(String[] args) {
        Lab2.SortStats q1 = new Lab2().new SortStats();
        q1.runSort("Bubble Sort", 4, q1::bubbleSort);
        q1.runSort("Bubble Short", 4, q1::bubbleShort);
        q1.runSort("Insertion Sort", 5, q1::insertionSort);
        q1.runSort("Selection Sort", 5, q1::selectionSort);
        Lab2.SearchStats q2 = new Lab2().new SearchStats();
        q2.run(7);
    }

}
