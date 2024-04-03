/**
* models Pension Plan
*/

package edu.miu.cs489appsd.lab1b.model;

import java.time.LocalDate;

/**
 * models Pension plan.
 */
public class PensionPlan {
    private String planReferenceNumber;
    private LocalDate enrollmentDate;
    private double monthlyContribution;

    /**
     * constructor.
     */
    public PensionPlan(String planReferenceNumber, String enrollmentDate, double monthlyContribution) {
        this.planReferenceNumber = planReferenceNumber;
        this.enrollmentDate = LocalDate.parse(enrollmentDate);
        this.monthlyContribution = monthlyContribution;
    }

    @Override
    public String toString() {
        return "PensionPlan -"
                + "| ReferenceNumber='" + planReferenceNumber + '\''
                + "| enrollmentDate=" + enrollmentDate
                + "| monthlyContribution=" + monthlyContribution;
    }
}
