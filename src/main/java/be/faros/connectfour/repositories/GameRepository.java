package be.faros.connectfour.repositories;

import be.faros.connectfour.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by juchtdi on 14/09/2015.
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findFirst3ByOrderByGameIdDesc();
}
