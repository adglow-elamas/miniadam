package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Stat;
import domain.StatRepository;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service("statService")
public class StatServiceImpl implements StatService {
	
	private final static Logger logger = LogManager.getLogger(StatServiceImpl.class);

	@Autowired
	private StatRepository statRepository;

	@Override
	public List<Stat> findAll() {
		return this.statRepository.findAll();
	}

}