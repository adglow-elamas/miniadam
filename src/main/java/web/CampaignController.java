package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import domain.Campaign;
import domain.CampaignWithStat;
import service.CampaignService;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



@RestController
public class CampaignController {
	
	private final static Logger logger = LogManager.getLogger(CampaignController.class);
	
	@Autowired
	private CampaignService campaignService;

    @RequestMapping(value = "/backend/campaignswithstat", method = RequestMethod.GET)
    public List<CampaignWithStat> getCampaingsWithStat() {
    	return campaignService.getCampaingsWithStat();
    }

    //test pagination and sorting
    @RequestMapping(value = "/backend/campaignswithstat/{page}", method = RequestMethod.GET)
    public Page<CampaignWithStat> getCampaingsWithStat(@PathVariable("page") int page) {
    	Pageable pageable = PageRequest.of(page, 2, new Sort(Sort.Direction.DESC, "name"));
    	//return campaignService.getCampaingsWithStat(pageable);
    	return null;
    }	 
    
    @RequestMapping(value = "/backend/campaigns", method = RequestMethod.POST)
    public Campaign save(@RequestBody Campaign campaign) {
    	return campaignService.save(campaign);
    }    
    
    @RequestMapping(value = "/backend/campaigns/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") long id) {
    	campaignService.delete(id);
    }	

    //recibo el id por parametro y el name como objeto en json, que son todos los campos, 
    //pero hago como si la campana pudiera recibir mas, solo se pasan los que se modifican
    @RequestMapping(value = "/backend/campaigns/{id}", method = RequestMethod.PUT)
    public Campaign save(@RequestBody Campaign campaignChanges, @PathVariable("id") long id) {
    	return campaignService.update(id, campaignChanges);
    }    
    
}
