package testdome;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class AlertService {
    private final MapAlertDAO storage = new MapAlertDAO();
    
    public AlertService(AlertDao alertDao) {
        this.storage = (MapAlertDAO) alertDao;
    }
		
    public UUID raiseAlert() {
        return this.storage.addAlert(new Date());
    }
	
    public Date getAlertTime(UUID id) {
        return this.storage.getAlert(id);
    }
    
public static void main(String args[]) {
    	
    }
}



