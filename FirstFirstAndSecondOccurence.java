// Time Complexity: O(logn)
// Space Complexity: O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {

        if(nums.length == 0) {
            return new int[]{-1, -1};
        }

        int firstOccurence = getPos(-1, target, nums);
        int secondOccurence = getPos(1, target, nums);

        return new int[]{firstOccurence, secondOccurence};
    }

    public int getPos(int direction, int target, int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(nums[mid] == target) {
                if(direction == -1) {
                    if(mid == 0 && nums[mid] == target) {
                        return mid;
                    } 
                    if(mid - 1 >= 0 && nums[mid - 1] != target) {
                        return mid;
                    } else {
                        high = mid - 1;
                    }
                } else if(direction == 1) {
                    if(mid == nums.length - 1 && nums[mid] == target) {
                        return mid;
                    } 
                    if(mid + 1 <= nums.length - 1 && nums[mid + 1] != target) {
                        return mid;
                    } else {
                        low = mid + 1;
                    }
                }
                
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else if(nums[mid] < target) {
                low = mid + 1;
            }
        }

        return -1;
    }
}
