package eu.jpereira.trainings.designpatterns.creational.builder.builder;

import eu.jpereira.trainings.designpatterns.creational.builder.HTMLReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;

import java.util.Iterator;

public class HtmlReportBodyBuilder extends ReportBodyBuilder {
    @Override
    public ReportBody build() {
        HTMLReportBody reportBody = new HTMLReportBody();
        reportBody.putContent("<span class=\"customerName\">");
        reportBody.putContent(customerName);
        reportBody.putContent("</span><span class=\"customerPhone\">");
        reportBody.putContent(customerPhone);
        reportBody.putContent("</span>");

        reportBody.putContent("<items>");

        Iterator<SoldItem> it = soldItems.iterator();
        while (it.hasNext()) {
            SoldItem soldEntry = it.next();
            reportBody.putContent("<item><name>");
            reportBody.putContent(soldEntry.getName());
            reportBody.putContent("</name><quantity>");
            reportBody.putContent(soldEntry.getQuantity());
            reportBody.putContent("</quantity><price>");
            reportBody.putContent(soldEntry.getUnitPrice());
            reportBody.putContent("</price></item>");
        }
        reportBody.putContent("</items>");

        return reportBody;
    }
}
