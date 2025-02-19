package com.eazybytes.eazyschool.controller;


import com.eazybytes.eazyschool.model.Holiday;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Controller
public class HolidaysController {

    @GetMapping("/holidays")
    public String displayHolidays(@RequestParam(required = false) boolean festival,
                                  @RequestParam(required = false) boolean federal, Model model) {
        model.addAttribute("festival",festival);
        model.addAttribute("national",federal);

        List<Holiday> holidays = Arrays.asList(
                // Public/National Holidays in Ireland
                new Holiday("Jan 1", "New Year's Day", Holiday.Type.NATIONAL),
                new Holiday("Mar 17", "St. Patrick's Day", Holiday.Type.NATIONAL),
                new Holiday("Apr 1", "Easter Monday", Holiday.Type.NATIONAL), // Changes every year
                new Holiday("May 6", "May Bank Holiday", Holiday.Type.NATIONAL), // First Monday in May
                new Holiday("Jun 3", "June Bank Holiday", Holiday.Type.NATIONAL), // First Monday in June
                new Holiday("Aug 5", "August Bank Holiday", Holiday.Type.NATIONAL), // First Monday in August
                new Holiday("Oct 28", "October Bank Holiday", Holiday.Type.NATIONAL), // Last Monday in October
                new Holiday("Dec 25", "Christmas Day", Holiday.Type.NATIONAL),
                new Holiday("Dec 26", "St. Stephen's Day", Holiday.Type.NATIONAL),
                // Festivals in Ireland
                new Holiday("Apr 30", "Beltaine (Ancient Festival)", Holiday.Type.FESTIVAL),
                new Holiday("Oct 31", "Samhain (Ancient Festival, similar to Halloween)", Holiday.Type.FESTIVAL)
        );
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }
        return "holidays.html";

    }

}
