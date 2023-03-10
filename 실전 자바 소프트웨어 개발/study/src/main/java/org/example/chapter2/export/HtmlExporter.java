package org.example.chapter2.export;

import org.example.chapter2.domain.SummaryStatistics;

public class HtmlExporter implements Exporter {

    @Override
    public String export(SummaryStatistics summaryStatistics) {
        String result = "<!dockype html>";


        //.... HTML 코드

        return result;
    }
}
