package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.ConstructorResult;
import javax.persistence.Embeddable;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedNativeQueries;
import javax.persistence.Column;
import javax.persistence.ColumnResult;


//@Entity

//sin paginacion
/*
@SqlResultSetMapping(
	    name = "getCampaingsWithStatMapping",
	    classes = @ConstructorResult(
	            targetClass = CampaignWithStat.class,
	            columns = {
	                    @ColumnResult(name = "CAM_ID", type = Long.class),
	                    @ColumnResult(name = "CAM_NAME"),
	                    @ColumnResult(name = "IMPRESSIONS", type = Integer.class)
	            }
	    )
	)
@NamedNativeQuery(
		  name="getCampaingsWithStat",
		  query="SELECT CAM.CAM_ID, CAM.CAM_NAME, SUM(STA_IMPRESSIONS) AS IMPRESSIONS " + 
		  		"FROM CAMPAIGNS CAM " + 
		  		"LEFT JOIN ADSETS ADS ON CAM.CAM_ID = ADS.CAM_ID " + 
		  		"LEFT JOIN ADS AD ON ADS.ADS_ID = AD.ADS_ID " + 
		  		"LEFT JOIN AD_STATS STA ON AD.AD_ID = STA.AD_ID " + 
		  		"GROUP BY CAM.CAM_ID",
		  resultSetMapping="getCampaingsWithStatMapping"
		)
*/

//con paginacion
/*
@SqlResultSetMappings({
	@SqlResultSetMapping(
		    name = "getCampaingsWithStatMapping",
		    classes = @ConstructorResult(
		            targetClass = CampaignWithStat.class,
		            columns = {
		                    @ColumnResult(name = "CAM_ID", type = Long.class),
		                    @ColumnResult(name = "CAM_NAME"),
		                    @ColumnResult(name = "IMPRESSIONS", type = Integer.class)
		            }
		    )
		),
	@SqlResultSetMapping(name = "SqlResultSetMapping.count", columns = @ColumnResult(name = "CNT"))
})
@NamedNativeQueries({
	@NamedNativeQuery(
			  name="getCampaingsWithStat",
			  query="SELECT CAM.CAM_ID, CAM.CAM_NAME, SUM(STA_IMPRESSIONS) AS IMPRESSIONS " + 
			  		"FROM CAMPAIGNS CAM " + 
			  		"LEFT JOIN ADSETS ADS ON CAM.CAM_ID = ADS.CAM_ID " + 
			  		"LEFT JOIN ADS AD ON ADS.ADS_ID = AD.ADS_ID " + 
			  		"LEFT JOIN AD_STATS STA ON AD.AD_ID = STA.AD_ID " + 
			  		//"GROUP BY CAM.CAM_ID ORDER BY ?#{#pageable}",
			  		//"GROUP BY CAM.CAM_ID ORDER BY {#pageable}",
			  		"GROUP BY CAM.CAM_ID",
			  resultSetMapping="getCampaingsWithStatMapping"
			),
    @NamedNativeQuery(
            name = "getCampaingsWithStat.count",
            resultSetMapping = "SqlResultSetMapping.count",
			query="SELECT COUNT(*) as CNT FROM CAMPAIGNS"
    )
}) 
*/
public class CampaignWithStatEntity {
	
	//@Id
	private Long dummy;	
	
}
