package org.mn.booking.sheduler;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import lombok.RequiredArgsConstructor;
import org.mn.booking.service.OrderService;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JavaTask {

    private final OrderService orderService;


    public void printOrders() {

        System.out.println("printOrders  started: " + new Date());

        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                orderService.findAll().forEach(System.out::println);
            }
        };

        System.out.println(Thread.currentThread().getName() + "  started: " + new Date());

//        timer.scheduleAtFixedRate(task, 1000, 5000);
        timer.schedule(task, new Date(2025, 5, 28), Long.MAX_VALUE);

        System.out.println(Thread.currentThread().getName() + "  Ended: " + new Date());


        System.out.println("printOrders  completed: " + new Date());


    }


}
