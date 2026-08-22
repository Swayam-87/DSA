class Solution {
    public int largestInteger(int[] nums, int k) {
        int ans = -1;

        for (int i = 0; i <= nums.length - k; i++) {

            for (int j = i; j < i + k; j++) {

                boolean already = false;

                // Check if nums[j] already appeared
                // in this subarray
                for (int p = i; p < j; p++) {
                    if (nums[p] == nums[j]) {
                        already = true;
                        break;
                    }
                }

                if (already) {
                    continue;
                }

                // Count how many subarrays contain nums[j]
                int count = 0;

                for (int a = 0; a <= nums.length - k; a++) {
                    for (int b = a; b < a + k; b++) {
                        if (nums[b] == nums[j]) {
                            count++;
                            break;
                        }
                    }
                }

                if (count == 1) {
                    ans = Math.max(ans, nums[j]);
                }
            }
        }

        return ans;
    }
}