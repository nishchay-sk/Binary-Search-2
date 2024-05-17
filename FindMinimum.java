// Time Complexity: O(log(n))
// Space Complexity: O(1)

class Solution {
    public int findMin(int[] nums) {
        // 0,1,2,4,5,6,7
        // 4,5,6,7,8,1,2

        int low = 0;
        int high = nums.length - 1;

        int smallest = Integer.MAX_VALUE;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(nums[low] <= nums[mid]) {
                smallest = Math.min(nums[low], smallest);
                low = mid + 1;
            } else if(nums[mid] <= nums[high]) {
                smallest = Math.min(nums[mid], smallest);
                high = mid - 1;
            }

        }

        return smallest;
    }
}
