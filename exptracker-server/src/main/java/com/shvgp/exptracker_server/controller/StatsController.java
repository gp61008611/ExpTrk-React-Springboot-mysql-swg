package com.shvgp.exptracker_server.controller;

import com.shvgp.exptracker_server.dto.GraphDTO;
import com.shvgp.exptracker_server.dto.StatsDTO;
import com.shvgp.exptracker_server.services.stats.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StatsController {
    private final StatsService statsService;

    @GetMapping("/chart")
    public ResponseEntity<GraphDTO> getChartDetails(){
        return ResponseEntity.ok(statsService.getChartData());
    }
    @GetMapping("/stats")
    public ResponseEntity<StatsDTO> getStats(){
        return ResponseEntity.ok(statsService.getStats());
    }

}
