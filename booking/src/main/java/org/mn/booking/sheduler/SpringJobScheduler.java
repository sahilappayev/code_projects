package org.mn.booking.sheduler;


import java.util.Date;
import lombok.RequiredArgsConstructor;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.mn.booking.service.OrderService;
import org.springframework.scheduling.annotation.Async;
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
    @SchedulerLock(name = "printOrders",
            lockAtLeastFor = "${scheduler.printOrders.lockAtLeast}",
            lockAtMostFor = "${scheduler.printOrders.lockAtMost}")
    @Scheduled(fixedRateString = "PT5S")
//    @Async
    public void printOrders() {
        System.err.println(Thread.currentThread().getName() + "  started: " + new Date()); // 15:05
        orderService.findAll().forEach(System.out::println);

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.err.println(Thread.currentThread().getName() + "  Ended: " + new Date());// 15:10
    }


}
