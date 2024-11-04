import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
      System.out.println("Unsorted Array ---------------------------------------------------");
      ArrayList<Integer> integerList = Lab4.getList();
      Lab4.outputList(integerList);

      System.out.println("\n\nBubble sort results ----------------------------------------------");
      long startTime = System.nanoTime();
      ArrayList<Integer> bubbleSortedList = Lab4.bubbleSort(integerList);
      long endTime = System.nanoTime();
      Lab4.outputList(bubbleSortedList);
      System.out.println("\n\nReadout Time: " + (endTime - startTime) + " ns");

      System.out.println("\n\nInsertion sort results -------------------------------------------");
      startTime = System.nanoTime();
      ArrayList<Integer> insertionSortedList = Lab4.bubbleSort(integerList);
      endTime = System.nanoTime();
      Lab4.outputList(insertionSortedList);
      System.out.println("\n\nReadout Time: " + (endTime - startTime) + " ns\n");

    }
}

class Lab4 {
  public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
    // Step 1 - Implement insertion sort algorithm here
    int n = integerList.size();

    for (int i = 1; i < n; i++) {

        int currentElement = integerList.get(i);
        int k;

        for (k = i - 1; k >= 0 && integerList.get(k) > currentElement; k--) {
            integerList.set(k + 1, integerList.get(k));
        }

        integerList.set(k + 1, currentElement);
    }
    return integerList;
  }

  public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
    // Step 2 - Implement the bubble sort algorithm here
    int n = integerList.size();
    boolean needNextPass = true;
    
    for (int k = 1; k < n && needNextPass; k++) {
        needNextPass = false;
        
        for (int i = 0; i < n - k; i++) {
            if (integerList.get(i) > integerList.get(i + 1)) {
                int temp = integerList.get(i);
                integerList.set(i, integerList.get(i + 1));
                integerList.set(i + 1, temp);
                needNextPass = true;
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
  }
}
