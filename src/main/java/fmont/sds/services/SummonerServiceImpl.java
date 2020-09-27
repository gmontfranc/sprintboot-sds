package fmont.sds.services;

import fmont.sds.entities.Summoner;
import fmont.sds.repositories.SummonerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class SummonerServiceImpl implements SummonerService {

    private final SummonerRepository summonerRepository;

    public SummonerServiceImpl(SummonerRepository summonerRepository) {
        this.summonerRepository = summonerRepository;
    }

    @Override
    public Optional<Summoner> getSummonerById(Long id) {
       return this.summonerRepository.findById(id);
    }

    @Override
    public Summoner createSummoner() {
        return null;
    }

    @Override
    public Summoner updateSummoner() {
        return null;
    }
}
