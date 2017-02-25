package _2016year._10_2;

import java.util.Arrays;
import java.util.Scanner;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[6];
		Scanner in = new Scanner(System.in);
		for (int k = 0; k < 6; k++)
			arr[k] = in.nextInt();
		/*
		 * InsertSort(arr); System.out.println(Arrays.toString(arr));// ע��
		 * InsertSort1(arr); System.out.println(Arrays.toString(arr));
		 */
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	// �������򣬼ٶ���һ��Ԫ�ر��ŵ�����ȷ��λ���ϣ������������1~n-1
	public static void InsertSort(int[] arr) {
		int i, j;
		int n = arr.length;
		int target;
		for (i = 1; i < n; i++) {
			j = i;
			target = arr[i];
			while (j > 0 && target < arr[j - 1]) {// ��Ҫ������Ǹ�������ǰ��������Ǵ���С�������Ļ����Ǹ���
													// ���ƣ������������Ļ����ߵ�������ĵ�һ��λ�þͰѸ������뵽j��ʱ��λ��
				arr[j] = arr[j - 1];
				--j;
			}
			arr[j] = target;
		}

	}

	// ��һ�ֲ�������д��
	public static void InsertSort1(int[] arr) {
		if (arr == null || arr.length < 2)
			return;
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				} else
					break;
			}
		}
	}

	// ��������
	public static void quickSort(int arr[], int low, int high) {
		if (low < high) {
			int key = arr[low];
			int l = low;
			int h = high;
			while (l < h) {
				while (l < h && arr[h] >= key)
					h--;
				arr[l] = arr[h];
				while (l < h && arr[l] <= key)
					l++;
				arr[h] = arr[l];
			}

			arr[l] = key;
			quickSort(arr, low, l - 1);
			quickSort(arr, l + 1, high);
		}
		return;

	}

}
