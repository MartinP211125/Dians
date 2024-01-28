package mk.ukim.finki.dians.service.imp;

import mk.ukim.finki.dians.model.Wine;
import mk.ukim.finki.dians.repository.WineRepository;
import mk.ukim.finki.dians.service.WineService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WineServiceImp implements WineService {

    private final WineRepository wineRepository;

    public WineServiceImp(WineRepository wineRepository) {
        this.wineRepository = wineRepository;
    }

    @Override
    public List<Wine> findAll() {
        return wineRepository.findAll();
    }

    @Override
    public List<Wine> findNearMe(Double lat, Double lon, Double distance) {
        return wineRepository.findNearMe(lat, lon, distance);
    }

    @Override
    public Optional<Wine> findByName(String name) {
        return wineRepository.findByName(name);
    }
}
