import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.fasterxml.jackson.databind.ObjectMapper;

import domain.AdSet;
import domain.AdSetWithStat;
import domain.Campaign;
import domain.CampaignWithStat;
import service.AdSetService;
import service.CampaignService;
import domain.Stat;
import service.StatService;

public class Test {
	
	private final static Logger logger = LogManager.getLogger(Test.class);
	
	private final static ObjectMapper mapper = new ObjectMapper();//para sacar el json
	
	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("beans-process.xml");
			CampaignService campaignService = context.getBean("campaignService", CampaignService.class);
			AdSetService adSetService = context.getBean("adSetService", AdSetService.class);
			StatService statService = context.getBean("statService", StatService.class);
			
			//comentario de pruebas
			
//			List<Campaign> campaigns = campaignService.findAll();
//			logger.info("[m:main]: campaigns.size(): " + campaigns.size());

//			List<AdSet> adSets = adSetService.findAll();
//			logger.info("[m:main]: adSets.size(): " + adSets.size());
			
//			List<Stat> stats = statService.findAll();
//			logger.info("[m:main]: stats.size(): " + stats.size());

//			List<CampaignWithStat> campaignWithStatList = campaignService.getCampaingsWithStat();
//			logger.info("[m:main]: campaignWithStatList.size(): " + campaignWithStatList.size());
			
//			Pageable pageableCampaigns = PageRequest.of(0, 2, new Sort(Sort.Direction.DESC, "name"));			
//			Page<CampaignWithStat> campaignWithStatPage = campaignService.getCampaingsWithStat(pageableCampaigns);
//			logger.info("[m:main]: campaignWithStatPage: " + campaignWithStatPage);

//			Pageable pageableAdSets = PageRequest.of(0, 2, new Sort(Sort.Direction.DESC, "name"));			
//			Page<AdSetWithStat> adSetWithStatPage = adSetService.getAdSetsWithStat(pageableAdSets);
//			logger.info("[m:main]: adSetWithStatPage: " + adSetWithStatPage);
			
			//jpql
			//Pageable pageableCampaigns = PageRequest.of(0, 2, new Sort(Sort.Direction.DESC, "name"));			
			//Pageable pageableCampaigns = PageRequest.of(0, 2, new Sort(Sort.Direction.DESC, "name"));
			//Pageable pageableCampaigns = PageRequest.of(0, 2, new Sort(Sort.Direction.DESC, "CAM_NAME"));
//			Pageable pageableCampaigns = PageRequest.of(0, 2);
//			Sort sort = new Sort(Sort.Direction.DESC, "CAM_NAME");
			//Page<CampaignWithStat> campaignWithStatPage = campaignService.getCampaingsWithStat(pageableCampaigns);
			//Page<CampaignWithStat> campaignWithStatPage = campaignService.getCampaingsWithStat(pageableCampaigns, sort);
			//logger.info("[m:main]: campaignWithStatPage: " + campaignWithStatPage);			
			Page<CampaignWithStat> campaignWithStatPage = campaignService.getCampaingsWithStat("CAM_NAME", Sort.Direction.DESC, 0, 2);
			logger.info("[m:main]: campaignWithStatPage.getSize(): " + campaignWithStatPage.getSize());
			logger.info("[m:main]: campaignWithStatPage json: " + mapper.writeValueAsString(campaignWithStatPage));
			
//			List<CampaignWithStat> campaignsWithStat = campaignService.getCampaingsWithStat();
//			logger.info("[m:main]: campaignsWithStat.getSize(): " + campaignsWithStat.size());			
//			logger.info("[m:main]: campaignsWithStat json: " + mapper.writeValueAsString(campaignsWithStat));
			
//			Pageable pageable = PageRequest.of(0, 2);
//			Sort sort = new Sort(Sort.Direction.DESC, "name");
//			Page<CampaignWithStat> campaignWithStatPage = campaignService.getCampaingsWithStat(pageable, sort);
//			logger.info("[m:main]: campaignWithStatPage: " + campaignWithStatPage);			
			
		} catch (Exception e) {
			logger.error("[m:main]", e);
		}
	}

}