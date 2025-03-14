package com.example.honors_spring_devops;

import com.example.honors_spring_devops.dto.ScheduleInfo;
import com.example.honors_spring_devops.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @GetMapping("/flights/{flightId}")
    ResponseEntity<List<ScheduleInfo>> getSchedulesForFlight(@PathVariable String flightId) {
        List<ScheduleInfo> scheduleInfoList = scheduleService.getSchedulesByFlightId(flightId);
        if (scheduleInfoList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(scheduleInfoList);
    }

    @PostMapping()
    ScheduleInfo CreateFlight(@RequestBody ScheduleInfo scheduleInfo) {
        return scheduleService.createSchedule(scheduleInfo);
    }

//    @GetMapping("/{id}/schedules")
//    ResponseEntity<ScheduleInfo> getFlightSchedules(@PathVariable String id, @RequestParam(required = false)Optional<String> dates) {
//
//    }

    @DeleteMapping("/{id}")
    ResponseEntity<ScheduleInfo> deleteFlightById(@PathVariable String id) {
        try {
            scheduleService.deleteFlightById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}