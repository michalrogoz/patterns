package eu.jpereira.trainings.designpatterns.creational.factorymethod;

public abstract class ReportFactory {

    static public Report getReport(String type) {
        switch (type) {
            case "JSON":
                return new JSONReport();
            case "XML":
                return new XMLReport();
            case "HTML":
                return new HTMLReport();
            case "PDF":
                return new PDFReport();
            default:
                return null;
        }
    }

}
