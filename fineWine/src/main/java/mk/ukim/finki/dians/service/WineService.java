package mk.ukim.finki.dians.service;

import mk.ukim.finki.dians.model.Wine;

import java.util.List;
import java.util.Optional;

public interface WineService {
    public List<Wine> findAll();

    public List<Wine> findNearMe(Double lat, Double lon, Double distance);

    public Optional<Wine> findByName(String name);
}
