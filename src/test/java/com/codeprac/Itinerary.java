package com.codeprac;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class Itinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        List<Ticket> ticketList = tickets.stream().map(ticket ->
                new Ticket(ticket.get(0), ticket.get(1))).collect(toList());
        return solve(ticketList);
    }

    public List<String> solve(List<Ticket> tickets) {
        if (tickets.isEmpty()) return Collections.emptyList();

        TravelItem starting = firstTravelItem(tickets);
        tickets.remove(0);

        int numberOfProcessedTickets = 1;
        while (numberOfProcessedTickets < tickets.size()) {
            var beforeStarting = findPrevious(tickets, starting);

            boolean startingFinalized = beforeStarting.isEmpty();
            if (startingFinalized) {
                constructFromLastPoint(tickets, starting, numberOfProcessedTickets);
                break;
            } else {
                Ticket beforePoint = beforeStarting.get();
                startingFinalized = isPathAvailable(beforePoint.from, starting.name, tickets);
                if (startingFinalized) {
                    constructFromLastPoint(tickets, starting, numberOfProcessedTickets);
                    break;
                } else {
                    starting = addToItineraryAtTheBeginning(starting, beforePoint);
                    tickets.remove(beforePoint);
                    numberOfProcessedTickets++;
                }
            }
        }


        return buildItinerary(starting);
    }

    @NotNull
    private TravelItem addToItineraryAtTheBeginning(TravelItem starting, Ticket beforePoint) {
        var travelItem = new TravelItem(beforePoint.from);
        travelItem.nextPlace = starting;
        starting = travelItem;
        return starting;
    }

    private void constructFromLastPoint(List<Ticket> tickets, TravelItem starting, int numberOfProcessedTickets) {
        TravelItem itr = findLastStop(starting);
        while (numberOfProcessedTickets < tickets.size()) {
            var next = findNextStop(tickets, itr);
            if (next.isPresent()) {
                itr.nextPlace = new TravelItem(next.get().to);
                tickets.remove(next.get());
                itr = itr.nextPlace;
                numberOfProcessedTickets++;
            } else
                break;
        }
    }

    private boolean isPathAvailable(String from, String to, List<Ticket> tickets) {
        return tickets.stream().anyMatch(ticket -> ticket.from.equals(from) && ticket.to.equals(to));
    }

    private List<String> buildItinerary(TravelItem starting) {
        TravelItem itr = starting;
        List<String> result = new ArrayList<>();
        while (itr != null) {
            result.add(itr.name);
            itr = itr.nextPlace;
        }
        return result;
    }

    private TravelItem findLastStop(TravelItem starting) {
        TravelItem itr = starting;
        while(itr.nextPlace != null) {
            itr = itr.nextPlace;
        }
        return itr;
    }

    private Optional<Ticket> findPrevious(List<Ticket> tickets, TravelItem currentPlace) {
        return tickets.stream()
                .filter(ticket -> ticket.to.equals(currentPlace.name))
                .findFirst();
    }

    private Optional<Ticket> findNextStop(List<Ticket> tickets, TravelItem currentPlace) {
        return tickets.stream()
                .filter(ticket -> ticket.from.equals(currentPlace.name))
                .findFirst();
    }

    private TravelItem firstTravelItem(List<Ticket> tickets) {
        TravelItem starting;
        starting = new TravelItem(tickets.get(0).from);
        starting.nextPlace = new TravelItem(tickets.get(0).to);
        return starting;
    }

    static class TravelItem {
        String name;
        TravelItem nextPlace;

        public TravelItem(String name) {
            this.name = name;
        }
    }

    static class Ticket {
        String from;
        String to;

        public Ticket(String from, String to) {
            this.from = from;
            this.to = to;
        }
    }

}
