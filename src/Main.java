import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
    }
}

//MINE beats 50%
class Solution {
    public void rotate(int[] nums, int k) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        int index = 0;

        for (int i = nums.length - k; i < nums.length; i++) {
            nums[index] = copy[i];
            index++;
        }
        for (int j = 0; j < nums.length - k; j++) {
            nums[index] = copy[j];
            index++;
        }
    }
}

// TOP SOLUTION, NO TEMP ARRAY NEEDD
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int n = nums.length;
        reverseNum(nums,0,n-1); // reverse array so now is [7,6,5,4,3,2,1]
        reverseNum(nums,0,k-1); // start = 0, end = 2. reverse [7,6,5] -> [5,6,7]
        reverseNum(nums,k,n-1); // start = 3, end = 6. reverse [4,3,2,1] -> [1,2,3,4]
        // result is [5,6,7,1,2,3,4]
    }
    public void reverseNum(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

// SUPPOSE [1,2,3,4,5,6,7], k = 3