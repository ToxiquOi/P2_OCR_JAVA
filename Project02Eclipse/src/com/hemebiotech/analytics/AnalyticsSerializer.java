package com.hemebiotech.analytics;

import java.io.Serializable;
import java.util.Map;

public class AnalyticsSerializer {

    private Map<String, Integer> mRportsMap;

    public AnalyticsSerializer(Map<String, Integer> reportsMap) {
        mRportsMap = reportsMap;
    }

    public String serialize() {
        StringBuilder oTextBuilder = new StringBuilder()
                .append("Symptoms counts: ").append(mRportsMap.size())
                .append("\r\n");

        mRportsMap.forEach((key, value) ->
                oTextBuilder.append("Symptom: ").append(key)
                        .append(", Total count: ").append(value)
                        .append("\r\n")
        );

        return oTextBuilder.toString();
    }
}
