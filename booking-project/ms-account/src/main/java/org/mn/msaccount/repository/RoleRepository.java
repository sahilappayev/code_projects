package org.mn.msaccount.repository;

import java.util.List;
import java.util.Set;
import org.mn.msaccount.annotation.constant.RoleEnum;
import org.mn.msaccount.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Set<Role> findByNameIn(List<RoleEnum> names);

}
