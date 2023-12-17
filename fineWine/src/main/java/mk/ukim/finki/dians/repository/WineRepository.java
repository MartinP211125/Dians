package mk.ukim.finki.dians.repository;

import mk.ukim.finki.dians.bootstrap.DataHolder;
import mk.ukim.finki.dians.model.Wine;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class WineRepository {
    public List<Wine> findAll(){
        return DataHolder.wines;
    }

    public List<Wine> findNearMe(Double lat, Double lon, Double distance){
        return DataHolder.wines.stream().filter(r -> r.getLat() <= lat+distance && r.getLon() <= lon+distance && r.getLat() >= lat-distance && r.getLon() >= lon-distance).collect(Collectors.toList());
    }

    public Optional<Wine> findByName(String name){
        return DataHolder.wines.stream().filter(r -> r.getName().equals(name)).findFirst();
    }
}
