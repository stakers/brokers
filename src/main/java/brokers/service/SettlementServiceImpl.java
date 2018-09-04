package brokers.service;
 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brokers.dao.SettlementDao;

import org.springframework.core.env.Environment;

@Service("settlementService")
public class SettlementServiceImpl implements SettlementService {

    static final Logger LOGGER = LoggerFactory.getLogger(SettlementServiceImpl.class); 
    @Autowired
    Environment environment;
    @Autowired
    SettlementDao dao;

 
}
