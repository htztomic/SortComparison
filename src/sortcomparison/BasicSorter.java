package sortcomparison;

import java.util.*;

public class BasicSorter implements Sorter {
	@Override
	public void insertionSort(ArrayList<String> data, int firstIndex, int numberToSort) {
		// TODO Auto-generated method stub
		boolean check = false;
		int start;
		int value = -1;
		for (int i = 0; i < numberToSort; i++) {
			value = i + firstIndex - 1;
			start = i + firstIndex;
			while (value >= firstIndex && data.get(start).compareTo(data.get(value)) < 0 && start != firstIndex) {
				check = true;
				value--;
			}

			if (check) {
				swapping(data, start, value + 1);
				// data.add(value + 1, data.remove(start));
				check = false;
			}
		}

	}

	@Override
	public void quickSort(ArrayList<String> data, int firstIndex, int numberToSort) {
		quicky(data, firstIndex, numberToSort, true);
		// TODO Auto-generated method stub

	}

	public void quicky(ArrayList<String> data, int firstIndex, int numberToSort, boolean checks) {
		if (checks) {
			Collections.shuffle(data);
		}
		if (numberToSort <= 15) {
			insertionSort(data, firstIndex, numberToSort);
			return;
		} else {
			String pivot = data.get(firstIndex);
			int last = firstIndex + numberToSort - 1;
			int value = firstIndex + 1;
			while (value <= last) {
				if (data.get(value).compareTo(pivot) > 0) {
					while (data.get(last).compareTo(pivot) > 0 && last >= value) {
						last--;
					}
					if (last > value) {
						Collections.swap(data, value, last);
					}
				}
				value++;
			}
			Collections.swap(data, firstIndex, last);
			quicky(data, firstIndex, last - firstIndex, false);
			quicky(data, last + 1, (numberToSort + firstIndex) - last - 1, false);
		}
	}

	@Override
	public int partition(ArrayList<String> data, int firstIndex, int numberToPartition) {
		String pivot = data.get(firstIndex);
		int last = firstIndex + numberToPartition - 1;
		int value = firstIndex + 1;
		while (value <= last) {
			if (data.get(value).compareTo(pivot) > 0) {
				while (data.get(last).compareTo(pivot) > 0 && last >= value) {
					last--;
				}
				if (last > value) {
					Collections.swap(data, value, last);
				}
			}
			value++;
		}
		Collections.swap(data, firstIndex, last);
		// TODO Auto-generated method stub
		return last;
	}

	@Override
	public void mergeSort(ArrayList<String> data, int firstIndex, int numberToSort) {
		// TODO Auto-generated method stub
		// final long startTime = System.currentTimeMillis();
		if (numberToSort <= 15) {
			insertionSort(data, firstIndex, numberToSort);
			return;
		}
		// if (numberToSort == 1) {
		// return;
		// }
		// Collections.shuffle(data);

		if (numberToSort % 2 == 0) {
			int broke;
			broke = numberToSort / 2;
			mergeSort(data, firstIndex, broke);
			mergeSort(data, firstIndex + broke, broke);
			merge(data, firstIndex, broke, broke);
			// for (int i = firstIndex; i < (firstIndex + 2 * broke); i++) {
			// System.out.print(data.get(i) + " ");
			// }
			// System.out.println();
		} else {
			int brk;
			brk = numberToSort / 2;
			mergeSort(data, firstIndex, brk);
			mergeSort(data, firstIndex + brk, brk + 1);
			merge(data, firstIndex, brk, brk + 1);
			// for (int i = firstIndex; i < (firstIndex + 2 * brk + 1); i++) {
			// System.out.println(data.get(i) + " ");
			// }
			// System.out.println();
		}
		// System.out.println((System.currentTimeMillis() - startTime));

	}

	@Override
	public void merge(ArrayList<String> data, int firstIndex, int leftSegmentSize, int rightSegmentSize) {
		// TODO Auto-generated method stub
		int k = 0;
		int i = 0;
		// long startTime = System.currentTimeMillis();
		int count = leftSegmentSize;

		ArrayList<String> usage = new ArrayList<>();
		if (data.get(firstIndex + leftSegmentSize - 1).compareTo(data.get(firstIndex + leftSegmentSize)) <= 0) {
			return;
		}

		while (count > 0 && k < rightSegmentSize) {
			if (data.get(i + firstIndex).compareTo(data.get(firstIndex + leftSegmentSize + k)) <= 0) {
				usage.add(data.get(firstIndex + i));
				count--;
				i++;
			} else {
				usage.add(data.get(k + firstIndex + leftSegmentSize));
				k++;
			}
		}
		if (k < rightSegmentSize) {
			usage.addAll(
					data.subList(firstIndex + leftSegmentSize + k, firstIndex + leftSegmentSize + rightSegmentSize));
		} else if (count > 0) {
			usage.addAll(data.subList(firstIndex + i, firstIndex + leftSegmentSize));
		}
		int z = 0;
		for (int p = firstIndex; p < (firstIndex + usage.size()); p++) {
			data.set(p, usage.get(z));
			z++;
		}
		// System.out.println(System.currentTimeMillis() - startTime);
	}

	public void swapping(ArrayList<String> temp, int going, int to) {
		// final long startTime = System.currentTimeMillis();
		String position = temp.get(going);
		for (int i = going; i != to; i--) {
			temp.set(i, temp.get(i - 1));
		}
		temp.set(to, position);
		// System.out.println((System.currentTimeMillis() - startTime));
	}

	@Override
	public void heapSort(ArrayList<String> data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void heapify(ArrayList<String> data) {
		// TODO Auto-generated method stub

	}

}
