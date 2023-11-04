import java.util.*;

class RadixSortUtils {
	static int numLength(int num) {
		int count = 0;
		
		while (num != 0) {
			count++;
			num /= 10;
		}
		
		return count;
	}

	static int getDigitAtIndexOfFromEnd(int num, int index) {
		if (index < 0) {
			System.out.println("Index < 0");
		}
		
		int divisor = (int) Math.pow(10, index);
		int digit = (num / divisor) % 10;

		return digit;
	}

	static int getMax(int[] elements) {
		int max = 0;

		for (int element : elements) {
			if (element > max) {
				max = element;
			}
		}

		return max;
	}
}

public class Main {

  private static final int ASCENDING_ORDER = 1;

  private static void radixSort(int[] nums, boolean ascending) {
   		int max = RadixSortUtils.getMax(nums);
		  int numberOfDigits = RadixSortUtils.numLength(max);

		  Deque<Integer>[] digitsList = new Deque[10];

		  for (int i = 0; i < 10; i++) {
			  digitsList[i] = new LinkedList<Integer>();
		  }

		  for (int i = 0; i < numberOfDigits; i++) {
			  for (int j = 0; j < nums.length; j++) {
			    int digit = RadixSortUtils.getDigitAtIndexOfFromEnd(nums[j], i);
				  digitsList[digit].add(nums[j]);
			}

			int index = 0;
			for (Deque<Integer> digits : digitsList) {
				while (!digits.isEmpty()) {
					nums[index++] = digits.remove();
				}
			}
		}

		if (ascending != true) {
		  for (int i = 0; i < numberOfDigits; i++) {
			  for (int j = 0; j < nums.length; j++) {
			    int digit = 9 - RadixSortUtils.getDigitAtIndexOfFromEnd(nums[j], i);
				  digitsList[digit].add(nums[j]);
			}

			int index = 0;
			for (Deque<Integer> digits : digitsList) {
				while (!digits.isEmpty()) {
					nums[index++] = digits.remove();
				}
			}
		}
		}
  }

	public static void main(String[] args) {

		int[] nums = new int[13];
		nums[0] = 1000;
		nums[1] = 4;
		nums[2] = 25;
		nums[3] = 319;
		nums[4] = 88;
		nums[5] = 51;
		nums[6] = 3430;
		nums[7] = 8471;
		nums[8] = 701;
		nums[9] = 1;
		nums[10] = 2989;
		nums[11] = 657;
		nums[12] = 713;

		boolean ascending = true;

		radixSort(nums, ascending);

		System.out.println("Ascending: " + Arrays.toString(nums));
		
		radixSort(nums, !ascending);
		System.out.println("Descending: " + Arrays.toString(nums));
	}
}
