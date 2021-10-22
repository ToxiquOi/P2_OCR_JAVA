package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;


public class AnalyticsCounter {

	public static void main(String[] args) throws Exception {
		String inFile = System.getProperty("user.dir") + System.getProperty("file.separator") + "Project02Eclipse/symptoms.txt";
		String oFile = "./result.out";

		Map<String, Integer> symptomsMap = null;

		try (FileWriter writer = new FileWriter (oFile)) {
			try (BufferedReader bReader = new BufferedReader(new FileReader(inFile))) {
				symptomsMap = new SymptomReaderImpl(bReader).GetSymptoms();
				writer.write(new AnalyticsSerializer().serialize(symptomsMap));
			} catch (Exception ex) {
				writer.write(ex.toString());
			}
		} finally {
			if (symptomsMap != null) symptomsMap.clear();
		}
	}
}
