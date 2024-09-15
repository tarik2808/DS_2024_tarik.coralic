package midterm.homework1;

import midterm.homework1.Entry;
public class BinarySearch {
    public static int[] search(Entry[] entries, String searchableName) {
        int left = 0;
        int right = entries.length - 1;
        int[] result = new int[]{-1, -1};

        while(left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = entries[mid].getName().compareTo(searchableName);
            if(cmp == 0) {
                int start = mid;
                int end = mid;
                while (start > 0 && entries[start - 1].getName().equals(searchableName)) {
                    start--;
                }

                while (end < entries.length - 1 && entries[end + 1].getName().equals(searchableName)) {
                    end++;
                }

                result[0] = start;
                result[1] = end;
                return result;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new int[]{};

    }
}