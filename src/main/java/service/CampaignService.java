package service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;

import domain.Campaign;
import domain.CampaignWithStat;

public interface CampaignService {

	public List<Campaign> findAll();
	public List<CampaignWithStat> getCampaingsWithStat();
	
	//no se como coger el campo del sort asi que lo paso fuera
	public Page<CampaignWithStat> getCampaingsWithStat(String sortField, Sort.Direction direction, int page, int size);
	//public Page<CampaignWithStat> getCampaingsWithStat(Pageable pageable);
	//public Page<CampaignWithStat> getCampaingsWithStat(Pageable pageable, Sort sort);
	
	public Campaign save(Campaign campaign);
	public void delete(Long id);
	public Campaign update(long id, Campaign campaignChanges);
}
