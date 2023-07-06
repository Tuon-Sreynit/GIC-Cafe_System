package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.serviceImplement;

import java.util.List;
import org.springframework.stereotype.Service;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.TableSeat;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin.TableSeatRepository;
import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.service.TableEntityService;
import org.springframework.jdbc.core.JdbcTemplate;
@Service
public class TableEntityServiceImpl implements TableEntityService {

    private TableSeatRepository tableRepository;
    private JdbcTemplate jdbcTemplate;

    public TableEntityServiceImpl(TableSeatRepository tableRepository, JdbcTemplate jdbcTemplate) {
        super();
        this.tableRepository = tableRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<TableSeat> getAllTable() {
        return tableRepository.findAll();
    }

    @Override
    public void setNewTableAmount(Integer tableAmount) {
        Long rowsAmount = tableRepository.count();
        if(rowsAmount > tableAmount){
            for(int i=1; i<=rowsAmount; i++){
                if(i > tableAmount){
                    tableRepository.deleteById((long) i);
                }
            }
        }
        else if (rowsAmount < tableAmount){
            String sql = "ALTER TABLE table_seat AUTO_INCREMENT = 1";
            jdbcTemplate.execute(sql);
            for(int i = (int) (rowsAmount + 1); i<=tableAmount; i++){
                TableSeat newTable = new TableSeat();
                newTable.setNumber(i);
                newTable.setAvailability(1);
                tableRepository.save(newTable);
            }
        }
    }

    @Override
    public Long getTableAmount() {
        return tableRepository.count();
    }

    @Override
    public void setTableBusy(Long tableID) {
        TableSeat table = tableRepository.findById(tableID).get();
        table.setAvailability(0);
        tableRepository.save(table);

    }
    @Override
    public void setTableAvaileble(Long tableID) {
        TableSeat table = tableRepository.findById(tableID).get();
        table.setAvailability(1);
        tableRepository.save(table);

    }

    @Override
    public void setTableUnpaid(Long tableID) {
        TableSeat table = tableRepository.findById(tableID).get();
        table.setAvailability(2);
        tableRepository.save(table);
    }

}
