package de.hbrs.ia.code;
import de.hbrs.ia.model.SalesMan;
import de.hbrs.ia.model.SocialPerfomanceRecord;

import java.util.List;

/**
 * Code lines are commented for suppressing compile errors.
 * Are there any CRUD-operations missing?
 */
public interface ManagePersonal {
     public void createSalesMan( SalesMan record );

     public void addSocialPerformanceRecord(SocialPerfomanceRecord record , SalesMan salesMan );
     //Remark: an SocialPerformanceRecord corresponds to part B of a bonus sheet

     public SalesMan readSalesMan( int sid );

     public List<SalesMan> readAllSalesMen();

     public List<SocialPerfomanceRecord> readSocialPerformanceRecord( SalesMan salesMan );
     //Remark: How do you integrate the year?

}
