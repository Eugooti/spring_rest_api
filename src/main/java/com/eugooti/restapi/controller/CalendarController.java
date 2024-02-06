package com.eugooti.restapi.controller;

import com.eugooti.restapi.entity.Calendar;
import com.eugooti.restapi.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class CalendarController {

    @Autowired
    private CalendarService calendarService;


    @PostMapping("/newEvent")
    public Calendar addEvent(@RequestBody Calendar calendar){
        return calendarService.saveEvent(calendar);
    }

    @PostMapping("/newEvents")
    public List<Calendar> addEvents(@RequestBody List<Calendar> calendar){
        return calendarService.saveEvents(calendar);
    }

    @GetMapping("/events")
    public List<Calendar> getEvents(){
        return calendarService.getEvents();
    }

    @GetMapping("/eventById/{id}")
    public Calendar getEventById(@PathVariable int id){
        return calendarService.getEventById(id);
    }

    @GetMapping("/eventByUser/{user}")
    public List<Calendar> getEventByUser(@PathVariable String user){
        return calendarService.getByUser(user);
    }

    @PutMapping("/updateEvent")
    public Calendar UpdateEvent(@RequestBody Calendar calendar){
        return calendarService.updateEvent(calendar);
    }

    @DeleteMapping("/deleteEvent/{id}")
    public String DeleteEvent(@PathVariable int id){
        return calendarService.deleteEvent(id);
    }



}
