package com.example.hundredplaces.webservice;

import com.example.hundredplaces.data.visits.Visit;
import com.example.hundredplaces.data.visits.VisitRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/visits")
public class VisitRestController {
    private final VisitRepository visitRepository;

    public VisitRestController(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @GetMapping("/all")
    public List<Visit> getAllCities() {
        return visitRepository.findAll();
    }

    @GetMapping("/visit")
    public Visit getVisitById(@RequestParam long id) {
        return visitRepository.findById(id);
    }

    @PostMapping("/new")
    public Visit createVisit(@RequestBody Visit visit) {
        return visitRepository.save(visit);
    }

    @PutMapping("/update")
    public Visit updateVisit(@RequestBody Visit visit) {
        return visitRepository.save(visit);
    }

    @DeleteMapping("/delete")
    public void deleteVisitById(@RequestParam long id) {
        visitRepository.deleteById(id);
    }
}
