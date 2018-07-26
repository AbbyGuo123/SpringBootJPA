package com.oocl.springBootSqlTest.OneToOne.Controller;

import com.oocl.springBootSqlTest.OneToOne.Enity.Klass;
import com.oocl.springBootSqlTest.OneToOne.Repository.KlassRepository;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/klass")
public class KlassController {

    private KlassRepository klassRepository;

    public KlassController(KlassRepository klassRepository) {
        this.klassRepository = klassRepository;
    }

    @Transactional
    @GetMapping
    public List<Klass> findAllKlass(){
        return klassRepository.findAll();
    }

    @Transactional
    @PostMapping(path = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public Klass addKlass(@RequestBody  Klass klass){
        return klassRepository.save(klass);
    }

    @Transactional
    @GetMapping("/{id}")
    public Klass getKlassById(@PathVariable long id){
        return klassRepository.findById(id).get();
    }

    @Transactional
    @DeleteMapping("/{id}")
    public Klass deleteById(@PathVariable long id){
        Klass klass =klassRepository.findById(id).get();
        klassRepository.delete(klass);
        return klass;
    }
}
