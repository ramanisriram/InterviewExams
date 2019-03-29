package testdome;

import java.util.Date;
import java.util.UUID;

interface AlertDao {
    public UUID addAlert(Date time);
    public Date getAlert(UUID id);
}