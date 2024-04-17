package com.example.hundredplaces.webservice;

import com.example.hundredplaces.data.visits.Visit;
import com.example.hundredplaces.data.visits.VisitRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/visits")
public class VisitRestController {
    private final VisitRepository visitRepository;

    public VisitRestController(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @GetMapping("/all")
    public List<LocalDateTime> getAllVisitDatesByUserIdAndPlaceId(@RequestParam("userId") Long userId, @RequestParam("placeId") Long placeId) {
        return visitRepository.findVisitDatesByUserIdAndPlaceId(userId, placeId);
    }

    @PostMapping("/new")
    public Visit createVisit(@RequestBody Visit visit) {
        return visitRepository.save(visit);
    }

}
