package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class CampaignWithStatJdbcTemplateRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public Page<CampaignWithStat> getCampaignsWithStat(Pageable pageable) {
    	SqlParameterSource namedParameters = null;//TODO esto se podrá hacer mejor
    	int total = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM CAMPAIGNS", namedParameters, Integer.class);
    	
    	/*
            SELECT CAM.CAM_ID, CAM.CAM_NAME, SUM(STA_IMPRESSIONS) AS IMPRESSIONS  
			  		FROM CAMPAIGNS CAM  
			  		LEFT JOIN ADSETS ADS ON CAM.CAM_ID = ADS.CAM_ID  
			  		LEFT JOIN ADS AD ON ADS.ADS_ID = AD.ADS_ID  
			  		LEFT JOIN AD_STATS STA ON AD.AD_ID = STA.AD_ID
			  		GROUP BY CAM.CAM_ID 
    	 */
    	
    	StringBuilder sbQuery = new StringBuilder(256);
    	sbQuery.append("SELECT CAM.CAM_ID, CAM.CAM_NAME, SUM(STA_IMPRESSIONS) AS IMPRESSIONS");
    	sbQuery.append(" FROM CAMPAIGNS CAM");
    	sbQuery.append(" LEFT JOIN ADSETS ADS ON CAM.CAM_ID = ADS.CAM_ID");
    	sbQuery.append(" LEFT JOIN ADS AD ON ADS.ADS_ID = AD.ADS_ID");
    	sbQuery.append(" LEFT JOIN AD_STATS STA ON AD.AD_ID = STA.AD_ID");
    	sbQuery.append(" GROUP BY CAM.CAM_ID");
    	
    	Sort sort = pageable.getSort();
    	if (sort != null) {
    		sbQuery.append(" ORDER BY ");
    		//vale para varios campos
    		String separator = "";
            for (Sort.Order order : sort) {
            	sbQuery.append(separator)
                    .append(order.getProperty())
                    .append(" ")
                    .append(order.getDirection());
            	separator = ", ";
            } 
    	}

    	sbQuery.append(" LIMIT ").append(pageable.getPageSize());
    	sbQuery.append(" OFFSET ").append(pageable.getOffset());
    	
    	List<CampaignWithStat> campaigns = jdbcTemplate.query(sbQuery.toString(), new CampaignWithStatRowMapper());
    	
    	return new PageImpl<>(campaigns, pageable, total);
    }
    
    class CampaignWithStatRowMapper implements RowMapper<CampaignWithStat> {
    	@Override
    	public CampaignWithStat mapRow(ResultSet rs, int rowNum) throws SQLException {
    		return new CampaignWithStat(rs.getLong("CAM_ID"), rs.getString("CAM_NAME"), rs.getLong("IMPRESSIONS"));
        }
    }

}
