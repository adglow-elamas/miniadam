package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import domain.Campaign;
import domain.CampaignRepository;
import domain.CampaignWithStat;
import domain.CampaignWithStatRepository;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service("campaignService")
public class CampaignServiceImpl implements CampaignService {
	
	private final static Logger logger = LogManager.getLogger(CampaignServiceImpl.class);

	@Autowired
	private CampaignRepository campaignRepository;

	@Autowired
	private CampaignWithStatRepository campaignWithStatRepository;
	
	@Override
	public List<Campaign> findAll() {
		return this.campaignRepository.findAll();
	}

	@Override
	public List<CampaignWithStat> getCampaingsWithStat() {
		return this.campaignWithStatRepository.getCampaingsWithStat();
	}

	//no se como coger el campo del sort asi que lo paso fuera
	@Override
	public Page<CampaignWithStat> getCampaingsWithStat(String sortField, Sort.Direction direction, int page, int size) {
		Pageable pageable = PageRequest.of(0, 2);
		return this.campaignWithStatRepository.getCampaingsWithStat(sortField, direction.name(), pageable);
	}
	
	
//	@Override
//	public Page<CampaignWithStat> getCampaingsWithStat(Pageable pageable) {
//		return this.campaignWithStatRepository.getCampaingsWithStat(pageable);
//	}

//	@Override
//	public Page<CampaignWithStat> getCampaingsWithStat(Pageable pageable, Sort sort) {
//		return this.campaignWithStatRepository.getCampaingsWithStat(pageable, sort);
//	}
	
	@Override
	public Campaign save(Campaign campaign) {
		return this.campaignRepository.save(campaign);
	}
	
	@Override
	public void delete(Long id) {
		this.campaignRepository.deleteById(id);
		
	}
	
	@Override
	public Campaign update(long id, Campaign campaignChanges) {
		//implemento esto de manera chapucera porque me casca el campaign.setName y no tengo tiempo
		Campaign campaign = new Campaign();
		campaign.setId(id);
		campaign.setName(campaignChanges.getName());
		return this.campaignRepository.save(campaign);
		/*
		logger.info("[m:update] traza 1");
		Campaign campaign = this.campaignRepository.getOne(id);
		logger.info("[m:update] traza 2");
		//solo pongo los cambios
		if (campaignChanges.getName() != null) {
			logger.info("[m:update] traza 3");
			logger.info("[m:update] campaignChanges.getName(): " + campaignChanges.getName());
			campaign.setName(campaignChanges.getName());
		}
		logger.info("[m:update] traza 4");
		return this.campaignRepository.save(campaign);
		*/
	}
}