package edu.miu.cs489appsd.lab1b;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import edu.miu.cs489appsd.lab1b.model.Employee;
import edu.miu.cs489appsd.lab1b.model.PensionPlan;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Just doing lab2b.
 * see in assignment tab
 */
final class App {
    /**
     * Main Method.
     */
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Daniel", "Agar", "2018-01-17", 105945.50));
        employees.add(new Employee(2, "Benard", "Shaw", "2022-10-03", 197750.00));
        employees.add(new Employee(3, "Carly", "Agar", "2014-05-16", 842000.75));
        employees.add(new Employee(4, "Wesley", "Schneider", "2018-11-02", 74500.00));

        employees.get(0).setPensionPlan(new PensionPlan("EX1089", "2024-03-17", 100.00));
        employees.get(2).setPensionPlan(new PensionPlan("SM2307", "2019-11-04", 1555.50));

        employees.sort(Comparator.comparing(Employee::getLastName)
                .thenComparing(Employee::getYearlySalary).reversed());

        System.out.println("List of Employees (including Pension Plan data):");
        // Gson gson = new GsonBuilder().setPrettyPrinting().create();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
        Gson gson = gsonBuilder.create();
        String json = gson.toJson(employees);
        System.out.println(json);

        LocalDate nextMonthFirstDay = LocalDate.now().plusMonths(1).withDayOfMonth(1);
        LocalDate nextMonthLastDay = nextMonthFirstDay.plusMonths(1).minusDays(1);

        List<Employee> upcomingEnrollees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getPensionPlan() == null
                    && isQualifiedForEnrollment(employee, nextMonthFirstDay, nextMonthLastDay)) {
                upcomingEnrollees.add(employee);
            }
        }

        upcomingEnrollees.sort(Comparator.comparing(Employee::getEmploymentDate));

        System.out.println(" Monthly Upcoming Enrollees :");
        // gson = new GsonBuilder().setPrettyPrinting().create();
        json = gson.toJson(upcomingEnrollees);
        System.out.println(json);
    }

    private static boolean isQualifiedForEnrollment(Employee employee, LocalDate nextMonthFirstDay,
            LocalDate nextMonthLastDay) {
        LocalDate employmentDate = employee.getEmploymentDate();
        return employmentDate.isBefore(nextMonthLastDay) && employmentDate.plusYears(5).isBefore(nextMonthFirstDay);
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    static class LocalDateSerializer implements JsonSerializer<LocalDate> {

        @Override
        public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(formatter.format(src));
        }
    }
}
