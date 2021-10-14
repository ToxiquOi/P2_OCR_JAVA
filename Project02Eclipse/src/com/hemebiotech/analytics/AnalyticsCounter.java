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
		String inFile = "sympoms.txt";
		String oFile = "./result.out";
		FileWriter writer = new FileWriter (oFile);

		BufferedReader reader = null;
		Map<String, Integer> symptomsMap = null;

		try (Stream<Path> walk = Files.walk(Paths.get("."))) {
			Optional<Path> optPath = walk
					.filter(p -> p.getFileName().toString().contains(inFile))
					.findFirst();

			if (optPath.isEmpty()) {
				System.out.println("Input file not found");
				return;
			}

			reader = new BufferedReader(new FileReader(optPath.get().toFile()));
			symptomsMap = new SymptomReaderImpl(reader).GetSymptoms();
			writer.write(new AnalyticsSerializer(symptomsMap).serialize());

		} catch (Exception ex) {
			writer.write(ex.toString());
		} finally {
			if (reader != null) reader.close();
			if (symptomsMap != null) symptomsMap.clear();
			writer.close();
		}
	}
}
