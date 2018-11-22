package eu.jpereira.trainings.designpatterns.creational.builder.builder;

import eu.jpereira.trainings.designpatterns.creational.builder.json.JSONReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;

import java.util.Iterator;

public class JsonReportBodyBuilder extends ReportBodyBuilder {

    @Override
    public ReportBody build() {
        JSONReportBody reportBody = new JSONReportBody();
//Add customer info
        reportBody.addContent("sale:{customer:{");
        reportBody.addContent("name:\"");
        reportBody.addContent(customerName);
        reportBody.addContent("\",phone:\"");
        reportBody.addContent(customerPhone);
        reportBody.addContent("\"}");
//add array of items
        reportBody.addContent(",items:[");
        Iterator<SoldItem> it = soldItems.iterator();
        while (it.hasNext()) {
            SoldItem item = it.next();
            reportBody.addContent("{name:\"");
            reportBody.addContent(item.getName());
            reportBody.addContent("\",quantity:");
            reportBody.addContent(String.valueOf(item.getQuantity()));
            reportBody.addContent(",price:");
            reportBody.addContent(String.valueOf(item.getUnitPrice()));
            reportBody.addContent("}");
            if (it.hasNext()) {
                reportBody.addContent(",");
            }

        }
        reportBody.addContent("]}");

        return reportBody;
    }
}
