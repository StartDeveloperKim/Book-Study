package org.example.chapter2.export;

import org.example.chapter2.domain.SummaryStatistics;

public interface Exporter {
    String export(SummaryStatistics summaryStatistics);
}
