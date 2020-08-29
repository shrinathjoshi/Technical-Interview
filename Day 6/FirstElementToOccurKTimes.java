import java.util.HashMap;
import java.util.Scanner;

public class FirstElementToOccurKTimes {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int arr[] = new int[n];
			int result = -1;
			HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
				hashMap.put(arr[j], hashMap.getOrDefault(arr[j], 0) + 1);
			}

			for (int j = 0; j < n; j++) {
				if (hashMap.get(arr[j]) == k) {
					result = arr[j];
					break;
				}

			}

			System.out.println(result);
		}

		sc.close();
	}

}
