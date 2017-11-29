package domain;

import javax.persistence.SqlResultSetMapping;

import org.springframework.stereotype.Component;

import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQuery;
import javax.persistence.ColumnResult;

/*
@SqlResultSetMapping(
	    name = "getCampaingsWithStatMapping",
	    classes = @ConstructorResult(
	            targetClass = CampaignWithStat.class,
	            columns = {
	                    @ColumnResult(name = "userFirstName"),
	                    @ColumnResult(name = "userLastName"),
	                    @ColumnResult(name = "id"),
	                    @ColumnResult(name = "packageName")
	            }
	    )
	)
@NamedNativeQuery(
		  name="getCampaingsWithStat",
		  query="SELECT CAM.CAM_ID, CAM.CAM_NAME, SUM(STA_IMPRESSIONS) AS IMPRESIONS " + 
		  		"FROM CAMPAIGNS CAM " + 
		  		"LEFT JOIN ADSETS ADS ON CAM.CAM_ID = ADS.CAM_ID " + 
		  		"LEFT JOIN ADS AD ON ADS.ADS_ID = AD.ADS_ID " + 
		  		"LEFT JOIN AD_STATS STA ON AD.AD_ID = STA.AD_ID " + 
		  		"GROUP BY CAM.CAM_ID",
		  resultSetMapping="getCampaingsWithStatMapping"
		)
*/		

public class CampaignWithStat {
	
	private Campaign campaign;
	private Stat stat;
	
	public CampaignWithStat(Long campaignId, String campaignName, Long impressions) {
		this.campaign = new Campaign();
		this.campaign.setId(campaignId);
		this.campaign.setName(campaignName);
		this.stat = new Stat();
		stat.setImpressions(impressions);
	}

	public CampaignWithStat(Campaign campaign, Stat stat) {
		this.campaign = campaign;
		this.stat = stat;
	}

	public CampaignWithStat(Campaign campaign, Long impressions) {
		this.campaign = campaign;
		this.stat = new Stat();
		stat.setImpressions(impressions);
	}
	

	public Campaign getCampaign() {
		return campaign;
	}
	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}
	public Stat getStat() {
		return stat;
	}
	public void setStat(Stat stat) {
		this.stat = stat;
	}
	
}
