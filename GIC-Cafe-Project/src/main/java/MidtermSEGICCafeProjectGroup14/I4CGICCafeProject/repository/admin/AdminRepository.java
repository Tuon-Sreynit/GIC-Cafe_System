package MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import MidtermSEGICCafeProjectGroup14.I4CGICCafeProject.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository <Admin, Long> {
    
}
