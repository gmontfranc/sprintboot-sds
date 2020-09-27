package fmont.sds.services;

import fmont.sds.entities.Summoner;

import java.util.Optional;


public interface SummonerService {

    Optional<Summoner> getSummonerById(Long id);
    Summoner createSummoner();
    Summoner updateSummoner();
}
