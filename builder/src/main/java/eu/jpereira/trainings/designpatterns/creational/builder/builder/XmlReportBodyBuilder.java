package eu.jpereira.trainings.designpatterns.creational.builder.builder;

import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;
import eu.jpereira.trainings.designpatterns.creational.builder.xml.XMLReportBody;

import java.util.Iterator;

public class XmlReportBodyBuilder extends ReportBodyBuilder {
    @Override
    public ReportBody build() {
        XMLReportBody reportBody = new XMLReportBody();
        reportBody.putContent("<sale><customer><name>");
        reportBody.putContent(customerName);
        reportBody.putContent("</name><phone>");
        reportBody.putContent(customerPhone);
        reportBody.putContent("</phone></customer>");

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
        reportBody.putContent("</items></sale>");

        return reportBody;
    }
}
