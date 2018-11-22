/**
 * Copyright 2011 Joao Miguel Pereira
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.jpereira.trainings.designpatterns.creational.builder;

import eu.jpereira.trainings.designpatterns.creational.builder.builder.ReportBodyBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.model.*;

/**
 * @author jpereira
 *
 */
public class ReportAssembler {

    private SaleEntry saleEntry;

    /**
     * @param //reportDate
     */
    public void setSaleEntry(SaleEntry saleEntry) {
        this.saleEntry = saleEntry;
    }

    /**
     * @param type
     * @return
     */
    public Report getReport(String type) {
        ReportBody reportBody = ReportBodyBuilder.forFormat(type)
                .customerName(saleEntry.getCustomer().getName())
                .customerPhone(saleEntry.getCustomer().getPhone())
                .soldItems(saleEntry.getSoldItems())
                .build();

        Report report = new Report();
        report.setReportBody(reportBody);
        return report;

    }

}
