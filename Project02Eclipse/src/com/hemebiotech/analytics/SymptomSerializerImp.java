package com.hemebiotech.analytics;

import java.util.Map;

/**
 * A simple class to format reports before writing in the output
 */
public class SymptomSerializerImp implements ISymptomSerializer {

    private final Map<String, Integer> mReportsMap;


    public SymptomSerializerImp(Map<String, Integer> reportsMap) {
        mReportsMap = reportsMap;
    }

    /**
     * Serialize a map, content is  sorted alphabeticaly
     * @return string
     */
    @Override
    public String serialize() {
        final StringBuilder textBuilder = new StringBuilder()
                .append("Symptoms counts: ").append(mReportsMap.size())
                .append("\r\n");

        mReportsMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    System.out.println(entry.getKey().toUpperCase() + ", count : " + entry.getValue());
                    textBuilder.append("Symptom: ").append(entry.getKey())
                            .append(", Total count: ").append(entry.getValue())
                            .append("\r\n");
                }
        );

        return textBuilder.toString();
    }
}
