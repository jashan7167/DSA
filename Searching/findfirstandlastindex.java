class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = binarySearch(nums, 0, nums.length - 1, target, true, -1);
        res[1] = binarySearch(nums, 0, nums.length - 1, target, false, -1);
        return res;
    }

    public int binarySearch(int[] nums, int low, int high, int target, boolean findFirst, int ans) {
        if (low > high) {
            return ans;
        }
        int mid = (low + high) / 2;
        if (nums[mid] > target) {
            return binarySearch(nums, low, mid - 1, target, findFirst, ans);
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, high, target, findFirst, ans);
        } else {
            ans = mid;
            if (findFirst) {
                return binarySearch(nums, low, mid - 1, target, findFirst, ans);
            } else {
                return binarySearch(nums, mid + 1, high, target, findFirst, ans);
            }
        }
    }
}

