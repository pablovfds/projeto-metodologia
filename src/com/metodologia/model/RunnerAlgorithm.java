package com.metodologia.model;

import com.metodologia.ReaderFile;
import com.metodologia.WriterFile;
import com.metodologia.model.exception.HeapException;

import java.io.IOException;

public class RunnerAlgorithm {

	public static void main(String[] args) throws IOException, HeapException {
		String optionAlgorithm = args[0];
		String pathInput = args.length > 1 ? args[1] : "";
		String pathOutput = args.length > 2 ? args[2] : "output.txt";

		ReaderFile readerFile = new ReaderFile(pathInput);
		String[] dataInput = readerFile.readerLines();

		WriterFile writerFile = new WriterFile(pathOutput);
		
		switch (optionAlgorithm) {
			case "heap":
				MaxHeapImpl<String> heap = new MaxHeapImpl<>(dataInput.length);
				
				for (String data : dataInput) {
					heap.insert(data);
				}
				
				heap.heapsort(dataInput);
				
				writerFile.writeLines(heap.toArray());
				break;
			case "par":

				MergeSortImpl mergeSort = new MergeSortImpl();
				mergeSort.sort(dataInput);

				writerFile.writeLines(dataInput);
				break;
		}
		System.exit(0);
	}
}
