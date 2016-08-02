package algotithm;

public class MergeSortImpl {

	public void sort(String[] array) {
		sort(2, array, 0, array.length);
	}

	private void sort(int qnt_threads, String[] strings, int begin, int right) {
		int num1;
		int num2;

		if (right > 1) {
			num1 = right / 2;
			num2 = right - num1;

			if (qnt_threads > 0) {
				Thread thread1 = new Thread(() -> {
					sort(qnt_threads - 2, strings, begin, num1);

				});
				Thread thread2 = new Thread(() -> {
					sort(qnt_threads - 2, strings, begin + num1, num2);
				});

				thread1.run();
				thread2.run();
			} else {
				sort(0, strings, begin, num1);
				sort(0, strings, begin + num1, num2);
			}

			merge(strings, begin, num1, num2);
		}
	}

	private void merge(String[] strings, int begin, int num1, int num2) {
		String[] temp = new String[num1 + num2];
		int k = 0;
		int copy1 = 0;
		int copy2 = 0;
		int i;


		while ((copy1 < num1) && (copy2 < num2)) {
			if (strings[begin + copy1].compareTo(strings[begin + num1 + copy2]) < 0)
				temp[k++] = strings[begin + (copy1++)];
			else
				temp[k++] = strings[begin + num1 + (copy2++)];
		}

		while (copy1 < num1)
			temp[k++] = strings[begin + (copy1++)];
		while (copy2 < num2)
			temp[k++] = strings[begin + num1 + (copy2++)];

		for (i = 0; i < num1 + num2; i++)
			strings[begin + i] = temp[i];
	}
}
