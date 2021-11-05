package com.hemebiotech.analytics;

import java.io.*;
import java.util.Map;


/**
 * The core process class
 */
public class AnalyticsCounter implements Runnable {

	private final String mInputFile;
	private final String mOutFile;

	public AnalyticsCounter(String inputFile, String outputFile) {
		mInputFile = inputFile;
		mOutFile = outputFile;
	}

	/**
	 * Run the process, it will produce a report into the defined output file
	 */
	@Override
	public void run() {
		try (final FileWriter WRITER = new FileWriter(mOutFile); final BufferedReader READER = new BufferedReader(new FileReader(mInputFile))) {
			//Create symptoms map from input file
			ISymptomReader symptomReader = new SymptomReaderImpl(READER);
			Map<String, Integer> symptomsMap = symptomReader.GetSymptoms();

			//Serialize and write report
			ISymptomSerializer serializer = new SymptomSerializerImp(symptomsMap);
			WRITER.write(serializer.serialize());

		} catch(FileNotFoundException ex1) {
			ex1.printStackTrace();
		} catch (IOException ex2) {
			ex2.printStackTrace();
		}  catch (Exception ex3) {
			ex3.printStackTrace();
		}
	}
}
