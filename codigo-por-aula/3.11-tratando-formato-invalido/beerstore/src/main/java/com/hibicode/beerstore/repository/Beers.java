package com.hibicode.beerstore.repository;

import com.hibicode.beerstore.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Beers extends JpaRepository<Beer, Long> {
}
