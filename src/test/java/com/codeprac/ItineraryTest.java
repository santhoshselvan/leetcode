package com.codeprac;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItineraryTest {

    @Test
    void shouldFindItinerary() {
        var itinerary = new Itinerary();

//        assertEquals(List.of("Bombay", "Delhi", "Goa", "Chennai", "Bangalore"),
//                itinerary.solve(List.of(
//                        new Itinerary.Ticket("Chennai", "Bangalore"),
//                        new Itinerary.Ticket("Bombay", "Delhi"),
//                        new Itinerary.Ticket("Goa", "Chennai"),
//                        new Itinerary.Ticket("Delhi", "Goa")
//                )));
//
//        assertEquals(List.of("JFK","MUC","LHR","SFO","SJC"),
//                itinerary.findItinerary(List.of(
//                        List.of("MUC","LHR"),
//                        List.of("JFK","MUC"),
//                        List.of("SFO","SJC"),
//                        List.of("LHR","SFO")
//                )));

        assertEquals(List.of("JFK","ATL","JFK","SFO","ATL","SFO"),
                itinerary.findItinerary(List.of(
                        List.of("JFK","SFO"),
                        List.of("JFK","ATL"),
                        List.of("SFO","ATL"),
                        List.of("ATL","JFK")
                )));
    }
}
