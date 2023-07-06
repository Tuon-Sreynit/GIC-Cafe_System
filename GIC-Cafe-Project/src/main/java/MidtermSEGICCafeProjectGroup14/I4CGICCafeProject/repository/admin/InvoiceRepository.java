package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;

import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    
}
