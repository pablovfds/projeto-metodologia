package com.metodologia.model;

import com.metodologia.Utils.Util;
import com.metodologia.model.exception.HeapException;
import com.metodologia.model.interfaces.MaxHeap;

public class MaxHeapImpl<T extends Comparable<T>> implements MaxHeap<T> {
	private Integer sizeHeap;
	private T[] heap;

	public MaxHeapImpl(Integer initialSize) {
		heap = (T[]) new Comparable[initialSize];
		this.sizeHeap = new Integer(0);
	}

	@Override
	public boolean isEmpty() {
		return this.sizeHeap == 0;
	}

	@Override
	public void insert(T element) throws HeapException {
		if (sizeHeap >= heap.length) {
			throw new HeapException("A Heap Cheia");
		}
		int i = sizeHeap;
		while (i > 0 && heap[parent(i)].compareTo(element) < 0) {
			heap[i] = heap[parent(i)];
			i = parent(i);
		}
		heap[i] = element;
		sizeHeap++;
	}

	@Override
	public T extractRootElement() {
		if (this.rootElement() == null) {
			return null;
		}
		T root = this.rootElement();

		Util.swap(heap, 0, sizeHeap - 1);

		sizeHeap--;
		heapify(0);

		return root;
	}

	@Override
	public T rootElement() {
		return this.isEmpty() ? null : heap[0];
	}

	@Override
	public T[] heapsort(T[] array) {
		T[] copy = array.clone();
		this.buildHeap(copy);
		int i = sizeHeap - 1;
		while (!this.isEmpty()) {
			copy[i--] = this.extractRootElement();
		}
		return copy;
	}

	@Override
	public void buildHeap(T[] array) {
		this.heap = array.clone();

		sizeHeap = heap.length;

		for (int i = (sizeHeap - 1) / 2; i >= 0; i--) {
			heapify(i);
		}
	}

	private void heapify(int position) {
		int left = left(position);
		int right = right(position);
		int max = position;

		if (left <= sizeHeap - 1 && heap[left].compareTo(heap[position]) > 0) {
			max = left;
		}
		if (right <= sizeHeap - 1 && heap[right].compareTo(heap[max]) > 0) {
			max = right;
		}
		if (max != position) {
			Util.swap(heap, position, max);
			heapify(max);
		}
	}

	@Override
	public T[] toArray() {
		return heap.clone();
	}

	private int parent(int i) {
		return (i - 1) / 2;
	}

	private int left(int i) {
		return 2 * i + 1;
	}

	private int right(int i) {
		return 2 * i + 2;
	}

}
