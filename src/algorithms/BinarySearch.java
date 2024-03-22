package algorithms;

public class BinarySearch {
    public static int searchByIteration(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (array[middle] == target) {
                return middle;
            }

            if (array[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }

    public static int searchByRecursion(int[] array, int target) {
        return searchByRecursion(array, target, 0, array.length - 1);
    }

    public static int searchByRecursion(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int middle = (left + right) / 2;

        if (array[middle] == target) {
            return middle;
        }

        if (array[middle] > target) {
            return searchByRecursion(array, target, left, middle - 1);
        } else {
            return searchByRecursion(array, target, middle + 1, right);
        }
    }
}
