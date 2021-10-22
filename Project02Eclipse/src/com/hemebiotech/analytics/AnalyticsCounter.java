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


	public static void main(String args[]) throws Exception {
		String inFile = System.getProperty("user.dir") + System.getProperty("file.separator") + "Project02Eclipse/symptoms.txt";
		String oFile = "./result.out";

		try (FileWriter writer = new FileWriter (oFile); BufferedReader bReader = new BufferedReader(new FileReader(inFile))) {
			//Create symptoms map from input file
			Map<String, Integer> symptomsMap = new SymptomReaderImpl(bReader).GetSymptoms();
			//Serialize and write report
			writer.write(new AnalyticsSerializer().serialize(symptomsMap));

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw ex;
		}
	}
}
