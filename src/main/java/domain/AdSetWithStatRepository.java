package domain;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdSetWithStatRepository extends JpaRepository<AdSet, Long> {


	@Query(nativeQuery = true, name="getAdSetsWithStat")
	List<AdSetWithStat> getAdSetsWithStat();

	@Query(nativeQuery = true, name="getAdSetsWithStat")
	Page<AdSetWithStat> getAdSetsWithStat(Pageable pageable);
}


