import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Unsorted Array ---------------------------------------------------");
        ArrayList<Integer> integerList = Lab4.getList();
        Lab4.outputList(integerList);

        // Measure time for bubbleSort
        long startTimeBubble = System.nanoTime();
        ArrayList<Integer> bubbleSortedList = Lab4.bubbleSort(integerList);
        long endTimeBubble = System.nanoTime();
        Lab4.outputList(bubbleSortedList);
        System.out.println("\nBubble Sort Time: " + (endTimeBubble - startTimeBubble) + " nanoseconds");

        // Measure time for insertionSort
        long startTimeInsertion = System.nanoTime();
        ArrayList<Integer> insertionSortedList = Lab4.insertionSort(integerList);
        long endTimeInsertion = System.nanoTime();
        Lab4.outputList(insertionSortedList);
        System.out.println("\nInsertion Sort Time: " + (endTimeInsertion - startTimeInsertion) + " nanoseconds");
    }
}

class Lab4 {
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
        for (int i = 1; i < integerList.size(); i++) {
            int key = integerList.get(i);
            int j = i - 1;

            // Move elements of integerList[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && integerList.get(j) > key) {
                integerList.set(j + 1, integerList.get(j));
                j = j - 1;
            }
            integerList.set(j + 1, key);
        }
        return integerList;
    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
        int n = integerList.size();
        // Traverse through all elements in the list
        for (int i = 0; i < n - 1; i++) {
            // Last i elements are already in place
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if element found is greater than the next element
                if (integerList.get(j) > integerList.get(j + 1)) {
                    // Swap integerList[j] and integerList[j+1]
                    int temp = integerList.get(j);
                    integerList.set(j, integerList.get(j + 1));
                    integerList.set(j + 1, temp);
                }
            }
        }
        return integerList;
    }

    public static ArrayList<Integer> getList() {
        ArrayList<Integer> integerList = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("integers.txt"))) {
            while ((line = br.readLine()) != null) {
                integerList.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return integerList;
    }

    public static void outputList(ArrayList<Integer> integerList) {
        for (int i = 0; i < integerList.size(); i++) {
            System.out.print(integerList.get(i) + " ");
        }
        System.out.println();
    }
}