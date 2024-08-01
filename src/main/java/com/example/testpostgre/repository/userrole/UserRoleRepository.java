package com.example.testpostgre.reps.userrole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.testpostgre.model.UserRole;

import java.util.List;

@Repository
@Transactional
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    @Query("Select ur.role.roleName from UserRole ur where ur.appUser.userId = ?1")
    List<String> getRoleNames(Long userId);

}
