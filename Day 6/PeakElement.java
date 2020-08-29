
/*
problem Statement :- https://leetcode.com/problems/find-peak-element/
 */
public class PeakElement {

	public int findPeakElement(int[] nums) {

		// Time complexity :- O(n)
		// Space complexity :- O(1)

		int n = nums.length;
		if (n <= 1)
			return 0;

		int maxIndex = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[maxIndex])
				return i - 1;
			else
				maxIndex = i;
		}

		return maxIndex;
	}

	public int findPeakElementUsingBinarySearch(int[] nums) {

		// Time complexity :- O(logn)
		// Space complexity :- O(1)

		int n = nums.length;
		int left = 0;
		int right = n - 1;

		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] > nums[mid + 1])
				right = mid;
			else
				left = mid + 1;
		}

		return left;
	}

}
