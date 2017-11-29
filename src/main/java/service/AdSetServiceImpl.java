package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import domain.AdSet;
import domain.AdSetRepository;
import domain.AdSetWithStat;
import domain.AdSetWithStatRepository;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service("adSetService")
public class AdSetServiceImpl implements AdSetService {
	
	private final static Logger logger = LogManager.getLogger(AdSetServiceImpl.class);

	@Autowired
	private AdSetRepository adSetRepository;

	@Autowired
	private AdSetWithStatRepository adSetWithStatRepository;
	
	@Override
	public List<AdSet> findAll() {
		return this.adSetRepository.findAll();
	}

	@Override
	public List<AdSetWithStat> getAdSetsWithStat() {
		return this.adSetWithStatRepository.getAdSetsWithStat();
	}

	@Override
	public Page<AdSetWithStat> getAdSetsWithStat(Pageable pageable) {
		return this.adSetWithStatRepository.getAdSetsWithStat(pageable);
	}

}