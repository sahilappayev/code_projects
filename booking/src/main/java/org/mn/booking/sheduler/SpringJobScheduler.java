package org.mn.booking.sheduler;


import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.mn.booking.service.OrderService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SpringJobScheduler {

    private final OrderService orderService;

    // fixed delay end time
    // fixed rate start time
//    @Scheduled(initialDelay = 1000, fixedRate = 5000)
    // 1 - san, 2 -deq, 3 - saat, 4 - ayin gunu, 5 - ay, 6 - heftenin gunu
//    @Scheduled(cron = "30 * * * * TUE,MON", zone = "Asia/Baku")
    @Scheduled(fixedRateString = "PT2H15M30S")
//    @Async
    public void printOrders() {
        System.err.println(Thread.currentThread().getName() + "  started: " + new Date());
        orderService.findAll().forEach(System.out::println);
        System.err.println(Thread.currentThread().getName() + "  Ended: " + new Date());
    }


}
