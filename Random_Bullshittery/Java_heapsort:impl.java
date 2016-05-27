/**
 * Generic HeapSort Array-based implementation
 * can be used with either the 'sift up' or 'sift down' algorithms
 * as described <a href="https://en.wikipedia.org/?title=Heapsort#Pseudocode">Here</a>
 * Usage <code>Type[] array = HeapSort.sort(inputArray);</code>
 * will default to the sift down, use
 * <code>Type[] array = HeapSort.sort(inputArray, false);</code> for sift up.
 * 
 * @author /u/Philboyd_Studge
 */
class HeapSort
{

    /**
     * sort array of type T using the sift down method
     * @param array array of type T
     * @return sorted array of type T
     */
    public static <T extends Comparable<T>> T[] sort(T[] array)
    {
        return sort(array, true);
    }

    /** 
     * sort array of type T using either sift up or down method
     * @param array array of type T
     * @param down true for sift down, false for aift up
     * @return sorted array of type T
     */
    public static <T extends Comparable<T>> T[] sort(T[] array, boolean down)
    {
        if (down) 
        {
            heapify(array, array.length);
        }
        else
        {
            heapifyUp(array, array.length);
        } 

        int end = array.length - 1;
        while (end >= 0)
        {
            swap(array, end, 0);
            end--;

            // with either method, you have to use siftDown here.
            siftDown(array, 0, end);
        }
        return array;

    }

    /**
     * Swap two members of array
     * @param array array of type T
     * @param index1 first index of element to swap
     * @param index2 second index of element to swap with first
     * @return array of type T
     */
    private static <T extends Comparable<T>> T[] swap(T[] array, int index1, int index2)
    {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        return array;
    }

    /**
     * Heapify array into max heap using sift down
     * @param array array of type T
     * @param count integer length of array
     * @return array of type T as a max heap
     */
    private static <T extends Comparable<T>> T[] heapify(T[] array, int count)
    {
        int start = (int) Math.floor((count - 2)/2);
        while (start >= 0)
        {
            siftDown(array, start, count - 1);
            start--;
        }
        return array;
    }

    /**
     * Heapify array into max heap using sift up
     * @param array array of type T
     * @param count integer length of array
     * @return array of type T as a max heap
     */
    private static <T extends Comparable<T>> T[] heapifyUp(T[] array, int count)
    {
        int end = 1;
        while (end < count)
        {
            siftUp(array, 0, end);
            end++;
        }
        return array;
    }

    /**
     * Sift Up
     * @param array array of type T
     * @param start index to start from
     * @param end node to sift up
     * @return array of type T
     */
    private static<T extends Comparable<T>> T[] siftUp(T[] array, int start, int end)
    {
        int child = end;
        while (child > start)
        {
            int parent = (int) Math.floor((child - 1) /2);
            if (array[parent].compareTo(array[child]) < 0)
            {
                swap(array, parent, child);
                child = parent;
            }
            else
            {
                return array;
            }
        }
        return array;
    }

    /**
     * Sift Down
     * @param array array of type T
     * @param start index to start from
     * @param end index to end at
     * @return array of type T
     */
    private static <T extends Comparable<T>> T[] siftDown(T[] array, int start, int end)
    {
        int root = start;
        while (root * 2 + 1 <= end)
        {
            int child = root * 2 + 1;
            int swap = root;
            if (array[swap].compareTo(array[child]) < 0)
            {
                swap = child;
            }
            if ((child + 1 <= end) && (array[swap].compareTo(array[child + 1]) < 0))
            {
                swap = child + 1;
            }
            if (swap==root)
            {
                return array;
            }
            else
            {
                swap(array, root, swap);
                root = swap;
            }
        }
        return array;
    }   
}