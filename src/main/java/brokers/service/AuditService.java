package brokers.service;
 

import brokers.model.AuditLog;
 

public interface AuditService { 

	public boolean insertIntoAuditLog(AuditLog auditLog);
	
}
