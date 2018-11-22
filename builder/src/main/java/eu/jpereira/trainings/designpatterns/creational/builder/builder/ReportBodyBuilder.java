package eu.jpereira.trainings.designpatterns.creational.builder.builder;

import eu.jpereira.trainings.designpatterns.creational.builder.HTMLReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.json.JSONReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SaleEntry;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;
import eu.jpereira.trainings.designpatterns.creational.builder.xml.XMLReportBody;

import java.util.Iterator;
import java.util.List;

public abstract class ReportBodyBuilder {

    protected String customerName;
    protected String customerPhone;
    protected List<SoldItem> soldItems;


    public static ReportBodyBuilder forFormat(String format) {
        switch (format) {
            case "JSON":
                return new JsonReportBodyBuilder();
            case "XML":
                return new XmlReportBodyBuilder();
            case "HTML":
                return new HtmlReportBodyBuilder();
            default:
                throw new IllegalArgumentException("Unknown format");
        }
    }

    public ReportBodyBuilder customerName(String name) {
        this.customerName = name;
        return this;
    }

    public ReportBodyBuilder customerPhone(String phone) {
        this.customerPhone = phone;
        return this;
    }

    public ReportBodyBuilder soldItems(List<SoldItem> items) {
        this.soldItems = items;
        return this;
    }

    public abstract ReportBody build();

}
