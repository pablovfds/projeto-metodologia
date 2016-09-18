package algotithm;

import java.io.IOException;

public class RunnerAlgorithm {

	public static void main(String[] args) throws IOException, HeapException {
		String optionAlgorithm = args[0];
		String pathInput = args.length > 1 ? args[1] : "";
		String pathOutput = args.length > 2 ? args[2] : "output.txt";
		
		Long startTime;
		Long finalTime;
		
		ReaderFile readerFile = new ReaderFile(pathInput);
		String[] dataInput = readerFile.readerLines();

		WriterFile writerFile = new WriterFile(pathOutput);

		switch (optionAlgorithm) {
		case "heap":
			MaxHeapImpl<String> heap = new MaxHeapImpl<String>(dataInput.length);
			
			startTime = System.currentTimeMillis();
			
			System.out.println(startTime);
			
			for (String data : dataInput) {
				heap.insert(data);
			}

			heap.heapsort(dataInput);

			finalTime = System.currentTimeMillis();
			System.out.println(finalTime);
			
			System.out.println("Tempo de execução: " + (finalTime - startTime));
			
			writerFile.writeLines(heap.toArray());
			break;
		case "par":

			MergeSortImpl<String> mergeSort = new MergeSortImpl<String>();
			
			startTime = System.currentTimeMillis();
			
			System.out.println(startTime);
			
			mergeSort.sort(dataInput);

			finalTime = System.currentTimeMillis();
			System.out.println(finalTime);
			
			System.out.println("Tempo de execução: " + (finalTime - startTime));
			
			writerFile.writeLines(dataInput);
			break;
		}
		System.exit(0);
	}
}
