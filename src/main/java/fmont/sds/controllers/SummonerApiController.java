package fmont.sds.controllers;

import fmont.sds.entities.Summoner;
import fmont.sds.services.SummonerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SummonerApiController {

    private final SummonerService summonerService;

    public SummonerApiController(SummonerService summonerService) {
        this.summonerService = summonerService;
    }

    @GetMapping("/api/summoner/{id}")
    public Object getSummoner(@PathVariable Long id) {

        Optional<Summoner> optionalSummoner = summonerService.getSummonerById(id);

        return optionalSummoner.isPresent() ? optionalSummoner.get() : "Not found";
    }


}
