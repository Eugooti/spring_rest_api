package com.eugooti.restapi.service;

import com.eugooti.restapi.entity.Calendar;
import com.eugooti.restapi.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarService {

    @Autowired
    private CalendarRepository calendarRepository;

    public Calendar saveEvent(Calendar calendar){
      return   calendarRepository.save(calendar);
    }

    public List<Calendar> saveEvents(List<Calendar> calendars){
        return calendarRepository.saveAll(calendars);
    }

    public List<Calendar> getEvents(){
        return calendarRepository.findAll();
    }

    public Calendar getEventById(int id){
        return calendarRepository.findById(id).orElse(null);
    }

    public List<Calendar> getByUser(String user){
        return calendarRepository.findByCreatedBy(user);
    }

    public String deleteEvent(int id){
        calendarRepository.deleteById(id);

        return "Event deleted";
    }

    public Calendar updateEvent(Calendar calendar){
        Calendar calendar1=calendarRepository.findById(calendar.getId()).orElse(null);
        assert calendar1 != null;
        calendar1.setEvent(calendar.getEvent());
        calendar1.setDescription(calendar.getDescription());
        calendar1.setStart(calendar.getStart());
        calendar1.setEnd(calendar.getEnd());

       return calendarRepository.save(calendar1);

    }
}
