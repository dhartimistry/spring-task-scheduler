package com.example.spring_task_scheduler.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteService {
    private static final Logger logger = LoggerFactory.getLogger(QuoteService.class);

    private final List<String> quotes = List.of(
            "Believe you can and you're halfway there.",
            "Opportunities don't happen. You create them.",
            "Your time is limited, so don't waste it living someone else's life.",
            "Success is not final, failure is not fatal: it is the courage to continue that counts.",
            "Don't watch the clock; do what it does. Keep going."
    );

    // Random object to generate a random index for selecting a quote
    private final Random random = new Random();

    @Scheduled(cron = "0 0 8 * * ?") //Cron for 8:00 AM daily
    public void dailyQuote() {
        String quoteOfTheDay = quotes.get(random.nextInt(quotes.size()));
        logger.info("Quote of the Day: {} ", quoteOfTheDay);

    }
}
