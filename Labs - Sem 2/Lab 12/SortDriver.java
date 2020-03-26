import java.util.*;

public class SortDriver {
    // count and comment steps for assignment statements,
    // comparisons, and method calls
    private long steps;

    public SortDriver() {
        steps = 0;
    }

    public static void main(String[] args) {
        final SortDriver lab = new SortDriver();
        lab.go();
    }

    public void go() {
        int choice = 0;
        while (choice < 7) {
            final Scanner keys = new Scanner(System.in);
            System.out.println("\n===============================");
            System.out.println("Enter Number of Items: ");
            final int size = keys.nextInt();
            final int[] list = generateList(size);
            print(list);

            System.out.println();
            System.out.println("1: Bubble\t2: Sort1\t\t\t3: Sort2");
            System.out.println("4: MergeSort\t5: Binary Search\t6: Sequential Search");
            System.out.println("7: Quit\n");
            choice = keys.nextInt();
            if (choice == 1)
                bubbleSort(list);
            else if (choice == 2)
                sort1(list);
            else if (choice == 3)
                sort2(list);
            else if (choice == 4)
                mergeSort(list, 0, list.length - 1);
            else if (choice == 5 || choice == 6)
                search(list, choice);
            if (choice < 7)
                print(list);
            steps = 0;
        }
    }

    // Pre: int for array size
    // Post: returns a list of size elements with values from 1 to 5 * size
    public int[] generateList(final int size) {
        steps = 0;
        final int[] list = new int[size];
        for (int i = 0; i < size; i++)
            list[i] = (int) (Math.random() * size * 5 + 1);
        return list;
    }

    // Pre: an array
    // Post: prints the array and how many steps it took
    public void print(final int[] list) {
        if (steps > 0)
            System.out.println("This sort took " + steps + " steps to sort " + list.length + " numbers");
        if (list.length <= 100) {
            for (int i = 0; i < list.length; i++)
                System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    // Bubble sort goes through the list comparing two neighboring values and swaps
    // them if necessary. Once the list is gone through once, the biggest is at the
    // end it then goes through the remaining spots to put the second biggest at
    // end, and so on
    public void bubbleSort(final int[] list) {
        System.out.println("Bubble Sort");
        steps++; // outer =
        for (int outer = list.length - 1; outer >= 0; outer--) {
            steps += 3; // outer >=, outer--, inner =
            for (int inner = 0; inner < outer; inner++) {
                steps += 3; // inner <, inner++, list[inner] >
                if (list[inner] > list[inner + 1]) {
                    steps++; // swap call
                    swap(list, inner, inner + 1);
                }
            }
        }
    }

    public void sort1(final int[] list) {
        System.out.println("Selection Sort");

        // loop through entire array
        steps++; // i =
        for (int i = 0; i < list.length; i++) {
            steps += 3; // i <, i++, j =
            int smallest = i;
            // scan through rest of array to find smallest
            for (int j = i + 1; j < list.length; j++) {
                steps += 3; // j <, j++, list[j] >
                if (list[j] < list[smallest]) {
                    steps++; // update smallest
                    smallest = j;
                }
            }

            // swap placeholder with smallest
            swap(list, smallest, i);
            steps++; // swap call
        }
    }

    public void sort2(final int[] list) {
        System.out.println("Insertion Sort");
    }

    // swaps list[a] with list[b]
    public void swap(final int[] list, final int a, final int b) {
        steps += 3; // temp =, list[a] =, list[b] =
        final int temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }

    // to sort a portion of a list
    public void bubble(final int[] list, final int first, final int last) {
        for (int outer = last; outer >= first; outer--) {
            for (int inner = first; inner < outer; inner++) {
                if (list[inner] > list[inner + 1]) {
                    swap(list, inner, inner + 1);
                }
            }
        }
    }

    public void mergeSort(final int[] list, final int first, final int last) {
        final int mid = (first + last) / 2;
        bubble(list, first, mid);
        bubble(list, mid + 1, last);
        merge(list, first, mid, last);
    }

    public void merge(final int[] list, final int first, final int mid, final int last) {

    }

    public void search(final int[] list, final int choice) {
        final Scanner keys = new Scanner(System.in);
        System.out.println("Enter an item to search for");
        final int value = keys.nextInt();
        int spot;
        if (choice == 5)
            spot = binarySearch(list, value);
        else
            spot = sequentialSearch(list, value);

        if (spot >= 0)
            System.out.println(value + " is at index " + spot);
        else
            System.out.println("value is not in the list");
    }

    // O(log N)
    // Pre: array filled with values
    // Post: index of that value, -1 if DNE
    public int binarySearch(final int[] list, final int value) {
        System.out.println("Since it's binary search, the list will be sorted");
        // Arrays.sort(list);

        // Bubble sort here for now
        for (int outer = list.length - 1; outer >= 0; outer--) {
            for (int inner = 0; inner < outer; inner++) {
                if (list[inner] > list[inner + 1]) {
                    final int temp = list[inner];
                    list[inner] = list[inner + 1];
                    list[inner + 1] = temp;
                }
            }
        }

        int l = 0, r = list.length - 1;
        while (l <= r) {
            final int m = l + (r - l) / 2;
            // If found, return value
            if (list[m] == value)
                return m;
            // Look at right half
            if (list[m] < value)
                l = m + 1;
            // Look at left half
            else
                r = m - 1;
        }
        // Not found, return -1
        return -1;
    }

    // O(N)
    // Pre: array filled with values
    // Post: index of that value, -1 if DNE
    public int sequentialSearch(final int[] list, final int value) {
        // Do a linear scan
        for (int i = 0; i < list.length; i++) {
            if (list[i] == value) {
                return i;
            }
        }
        // If not found return -1
        return -1;
    }
}