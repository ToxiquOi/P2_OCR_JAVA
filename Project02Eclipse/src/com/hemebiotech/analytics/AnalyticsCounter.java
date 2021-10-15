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
		String inFile = "symptoms.txt";
		String oFile = "./result.out";

		Map<String, Integer> symptomsMap = null;

		try (FileWriter writer = new FileWriter (oFile)) {
			try (Stream<Path> walk = Files.walk(Paths.get(System.getProperty("user.dir")))) {
				Optional<Path> optPath = walk
						.filter(p -> p.getFileName().toString().contains(inFile))
						.findFirst();

				if (optPath.isEmpty()) {
					String errMess = "Input file not found";
					writer.write(errMess);
					System.out.println(errMess);
					return;
				}


				try (BufferedReader bReader = new BufferedReader(new FileReader(optPath.get().toFile()));) {
					symptomsMap = new SymptomReaderImpl(bReader).GetSymptoms();
					writer.write(new AnalyticsSerializer(symptomsMap).serialize());
				}

			} catch (Exception ex) {
				writer.write(ex.toString());
			}
		} finally {
			if (symptomsMap != null) symptomsMap.clear();
		}
	}
}
