package org.mn.booking.repository;

import java.util.List;
import java.util.Set;
import org.mn.booking.annotation.constant.RoleEnum;
import org.mn.booking.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Set<Role> findByNameIn(List<RoleEnum> names);

}
