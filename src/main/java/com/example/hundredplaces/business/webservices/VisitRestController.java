package com.example.hundredplaces.business.webservices;

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

    @GetMapping()
    public List<Visit> getAllVisitsByUserId(@RequestParam("userId") int userId) {
        return visitRepository.findAllByUserId(userId);
    }

    @PostMapping("/new")
    public void insertVisits(@RequestBody List<Visit> visits) {
        visitRepository.insertAll(visits);
    }
}
