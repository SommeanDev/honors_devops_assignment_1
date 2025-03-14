package com.example.honors_spring_devops.services;

import com.example.honors_spring_devops.dto.FlightInfo;
import com.example.honors_spring_devops.repository.FlightInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// @Service is also same as @Component
@Service
public class FlightService {
    @Autowired
    FlightInfoRepository flightInfoRepository;

    public List<FlightInfo> getAllFlights() {
        return flightInfoRepository.getAllFlights();
    }

    public FlightInfo createFlight(FlightInfo flightInfo) {
        return flightInfoRepository.createFlight(flightInfo);
    }

    public FlightInfo getFlight(String id) throws Exception {
        FlightInfo flightInfo = flightInfoRepository.getFlightById(id);
        if(flightInfo != null) {
            return flightInfo;
        }
        else {
            throw new Exception("Flight does not exist");
        }
    }

    public void deleteFlightById(String id) throws Exception {
        FlightInfo flightInfo = flightInfoRepository.getFlightById(id);
        if (flightInfo != null) {
            flightInfoRepository.deleteFlightById(id);
        }
        else {
            throw new Exception("Flight does not exist");
        }
    }
}
