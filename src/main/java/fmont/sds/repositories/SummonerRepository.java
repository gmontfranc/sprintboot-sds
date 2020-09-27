package fmont.sds.repositories;

import fmont.sds.entities.Summoner;
import org.springframework.data.repository.CrudRepository;

public interface SummonerRepository extends CrudRepository<Summoner,Long> {

    Summoner findByUserName(String userName);

}
