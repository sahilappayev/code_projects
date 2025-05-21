package org.mn.msaccount.repository;

import java.util.List;
import java.util.Optional;
import org.mn.msaccount.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameIgnoreCase(String username);

    List<User> findAllByFirstNameOrderByCreatedAtDescLastNameDesc(String firstName);

    @Query("select u from User u where u.firstName = :firstName order by u.createdAt desc")
    List<User> findAllByFirstNameAndOrder(String firstName);

    @Query(value = "select * from users u where u.first_name = :firstName order by u.created_at desc",
            nativeQuery = true)
    List<User> findAllByFirstNameAndOrderWithNative(String firstName);

}
