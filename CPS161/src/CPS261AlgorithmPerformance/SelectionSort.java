package CPS261AlgorithmPerformance;

import java.util.List;

public class SelectionSort {

    static void sort(List<Integer> arr)
    {
        int smallIndex; // index of smallest element in the sublist
        int pass, j;
        Integer temp;
        int n = arr.size();

        // pass has the range 0 to n-2
        for (pass = 0; pass < n-1; pass++)
        {
            // scan the sublist starting at index pass
            smallIndex = pass;

            // j traverses the sublist arr[pass+1] to arr[n-1]
            for (j = pass+1; j < n; j++)
                // update if smaller element found
                if (arr.get(j) < arr.get(smallIndex))
                    smallIndex = j;

            // if smallIndex and pass are not the same location,
            // exchange the smallest item in the sublist with arr[pass]
            if (smallIndex != pass)
            {
                temp = arr.get(pass);
                arr.set(pass, arr.get(smallIndex));
                arr.set(smallIndex, temp);
            }
        }
    }

}