package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.TableSeat;

@Service
public interface TableEntityService {
    List<TableSeat> getAllTable();
    void setNewTableAmount(Integer tableAmount);
    Long getTableAmount();
    void setTableBusy(Long tableID);
    void setTableAvaileble(Long tableID);
    void setTableUnpaid(Long tableID);
}
