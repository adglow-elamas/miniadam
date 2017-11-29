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

import domain.AdSetWithStat;
import domain.CampaignWithStat;
import service.AdSetService;
import service.CampaignService;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



@RestController
public class AdSetController {
	
	private final static Logger logger = LogManager.getLogger(AdSetController.class);
	
	@Autowired
	private AdSetService adSetService;

    @RequestMapping(value = "/backend/adsetswithstat", method = RequestMethod.GET)
    public List<AdSetWithStat> getAdSetsWithStat() {
    	return adSetService.getAdSetsWithStat();
    }

    //test pagination and sorting
    @RequestMapping(value = "/backend/adsetswithstat/{page}", method = RequestMethod.GET)
    public Page<AdSetWithStat> getAdSetsWithStat(@PathVariable("page") int page) {
    	Pageable pageable = PageRequest.of(page, 2, new Sort(Sort.Direction.DESC, "name"));
    	return adSetService.getAdSetsWithStat(pageable);
    }	 
}
