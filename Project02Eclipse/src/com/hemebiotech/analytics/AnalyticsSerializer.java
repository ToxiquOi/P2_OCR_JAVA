package com.hemebiotech.analytics;

import java.util.Map;

/**
 * A simple class to format reports into output files
 */
public class AnalyticsSerializer {

    /**
     * Serialize map injected in constructor
     * @return Formated Map content
     */
    public String serialize(Map<String, Integer> reportsMap) {
        StringBuilder textBuilder = new StringBuilder()
                .append("Symptoms counts: ").append(reportsMap.size())
                .append("\r\n");

        reportsMap.forEach((key, value) ->
                textBuilder.append("Symptom: ").append(key)
                        .append(", Total count: ").append(value)
                        .append("\r\n")
        );

        return textBuilder.toString();
    }
}
