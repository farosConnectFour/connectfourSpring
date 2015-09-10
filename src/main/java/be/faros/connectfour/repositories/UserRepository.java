package be.faros.connectfour.repositories;

import be.faros.connectfour.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by juchtdi on 9/09/2015.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
