package com.shvgp.exptracker_server.services.stats;

import com.shvgp.exptracker_server.dto.GraphDTO;
import com.shvgp.exptracker_server.dto.StatsDTO;

public interface StatsService {
    GraphDTO getChartData();
    StatsDTO getStats();
}
