package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AppointmentService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        AppointmentService appointmentService = context.getBean("appointmentService", AppointmentService.class);

        System.out.println(appointmentService.book("DOC101", "2025-04-10")); 
        System.out.println(appointmentService.book("DOC101", "2024-04-11")); 
    }
}
