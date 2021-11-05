package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

/**
 * Class implementing interface ISymptomReader
 */
public class SymptomReaderImpl implements ISymptomReader {

	private final BufferedReader mReader;
	
	/**
	 * 
	 * @param reader A text reader ready to use
	 */
	public SymptomReaderImpl (BufferedReader reader) {
		mReader = reader;
	}
	
	@Override
	public Map<String, Integer> GetSymptoms() throws IOException {
		final Map<String, Integer> symptomsMap = new HashMap<>();

		while(mReader.ready()) {
			String line = mReader.readLine();

			if(symptomsMap.containsKey(line))
				symptomsMap.put(line, symptomsMap.get(line) + 1);
			else
				symptomsMap.put(line, 1);
		}
		
		return symptomsMap;
	}

}
