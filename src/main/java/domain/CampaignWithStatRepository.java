package domain;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
//public interface CampaignWithStatRepository extends JpaRepository<CampaignWithStatEntity, Long> {
public interface CampaignWithStatRepository extends JpaRepository<Campaign, Long> {

	@Query(name="getCampaingsWithStat")
	List<CampaignWithStat> getCampaingsWithStat();	

//	@Query(nativeQuery = true, name="getCampaingsWithStat")
//	List<CampaignWithStat> getCampaingsWithStat();

//	@Query(nativeQuery = true, name="getCampaingsWithStat")
//	//@Query(name="getCampaingsWithStat")
//	Page<CampaignWithStat> getCampaingsWithStat(Pageable pageable);
	
	@Query(nativeQuery = true, name="getCampaingsWithStat")
	Page<CampaignWithStat> getCampaingsWithStat(@Param("order") String order, @Param("sort") String sort, Pageable pageable);	
	
//	@Query(name="getCampaingsWithStat")
//	Page<CampaignWithStat> getCampaingsWithStat(@Param("order") String order, @Param("sort") String sort, Pageable pageable);

//	@Query(name="getCampaingsWithStat")
//	Page<CampaignWithStat> getCampaingsWithStat(Pageable pageable, Sort sort);
	
	/*
	@Query(nativeQuery = true, name="getCampaingsWithStat")
	Page<CampaignWithStat> getCampaingsWithStat(Pageable pageablem, Sort sort);
	*/
	
}


