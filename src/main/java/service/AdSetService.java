package service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import domain.AdSet;
import domain.AdSetWithStat;

public interface AdSetService {

	public List<AdSet> findAll();
	public List<AdSetWithStat> getAdSetsWithStat();
	public Page<AdSetWithStat> getAdSetsWithStat(Pageable pageable);
}
