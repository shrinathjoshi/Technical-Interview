
/**
 * @author Shrinath Joshi
 * 
 *         Problem Statement :-
 *         https://leetcode.com/problems/trapping-rain-water/
 *
 */
public class TrappingRainWater {

	public static void main(String[] args) {
		int height[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.print(new TrappingRainWater().trap(height));
	}

	private int trap(int[] height) {

		return trapUsingTwoPointer(height);
	}

	private int trapUsingArray(int[] height) {

		// Time complexity :- O(n)
		// Space complexity :- O(n)

		int result = 0;
		int n = height.length;

		int maxFromRight[] = new int[n];
		int maxFromLeft[] = new int[n];

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			maxFromLeft[i] = Integer.max(max, height[i]);
			max = Integer.max(height[i], max);
		}

		max = Integer.MIN_VALUE;
		for (int i = n - 1; i >= 0; i--) {
			maxFromRight[i] = Integer.max(maxFromRight[i], max);
			max = Integer.max(height[i], max);
		}

		for (int i = 0; i < n; i++) {
			int minLevel = Integer.min(maxFromRight[i], maxFromLeft[i]);
			if (minLevel - height[i] > 0)
				result += (minLevel - height[i]);
		}

		return result;
	}

	private int trapUsingTwoPointer(int[] height) {
		// Time complexity :- O(n)
		// Space complexity :- O(1)
		// Lower Envelope Technique
		int n = height.length;
		int left = 0, right = n - 1;
		int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
		int result = 0;

		while (left < right) {
			if (height[left] < height[right]) {

				if (height[left] > leftMax)
					leftMax = height[left];
				else
					result += (leftMax - height[left]);

				left++;

			} else {

				if (height[right] > rightMax)
					rightMax = height[right];
				else
					result += (rightMax - height[right]);

				right--;
			}
		}

		return result;
	}

}
