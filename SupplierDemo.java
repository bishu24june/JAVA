package com.program.java8.function;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo<T>
{

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args)
    {
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);

        Supplier<LocalDateTime> s = () -> LocalDateTime.now();
        time = s.get();
        System.out.println(time);

        Supplier<String> s1 = () -> dtf.format(LocalDateTime.now());
        String time2 = s1.get();
        System.out.println(time2);

        SupplierDemo<String> obj = new SupplierDemo();

        List<String> list = obj.supplierMethod().get();

        Developer obj1 = factory(Developer::new);
        System.out.println(obj1);

        Developer obj2 = factory(() -> new Developer("bishwa"));
        System.out.println(obj2);

    }
    public Supplier<List<T>> supplierMethod() {

        // lambda
        // return () -> new ArrayList<>();

        // constructor reference
        return ArrayList::new;

        //you can't
       //return new ArrayList();

    }

    public static Developer factory(Supplier<? extends Developer> s) {

        Developer developer = s.get();
        if (developer.getName() == null || "".equals(developer.getName())) {
            developer.setName("default");
        }
        developer.setSalary(BigDecimal.ONE);
        developer.setStart(LocalDate.of(2017, 8, 8));

        return developer;

    }

}
