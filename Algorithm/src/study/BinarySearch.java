package study;

public class BinarySearch {

	public static void main(String[] args) {
		int[] nums = {0,2,4,6,8,10,12,14,16,18};
		
		int searchNum = 4;
		
		int result = binarySearch(nums, 0, nums.length, searchNum);
		
		System.out.println(result);

	}

	private static int binarySearch(int[] nums, int start, int end, int searchNum) {
		int center = (start+end) / 2;
		if(nums[center] == searchNum) {
			return center;
		} else {
			if(nums[center] < searchNum) {
				return binarySearch(nums, center, end, searchNum);	
			} else {
				return binarySearch(nums, start, center, searchNum);
			}
		}
		
	}

}
