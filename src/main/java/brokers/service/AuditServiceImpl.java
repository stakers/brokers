package brokers.service;
 
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brokers.dao.AuditDao;
import brokers.model.AuditLog;
import brokers.model.Response;

import org.springframework.core.env.Environment;

@Service("auditService")
public class AuditServiceImpl implements AuditService {

    static final Logger LOGGER = LoggerFactory.getLogger(AuditServiceImpl.class); 
    @Autowired
    Environment environment;
    @Autowired
    AuditDao dao; 
    
	@Override
	public boolean insertIntoAuditLog(AuditLog auditLog) {  
		return true;
	}

 
}
