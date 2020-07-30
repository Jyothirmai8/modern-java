package examples;

import java.time.*; // 1.8
import java.time.temporal.ChronoField;

/*
 * 
 *  LocalDate
 *  LocalTime
 *  LocalDateTime
 *  Instant
 *  Duration
 *  Period
 * 
 */

public class DateAndTimeApi {

	public static void main(String[] args) {

		LocalDate date = LocalDate.of(2020, 7, 30);
		System.out.println(date);

		System.out.println(date.getYear());
		System.out.println(date.getMonth());
		System.out.println(date.getDayOfMonth());
		System.out.println(date.lengthOfMonth());
		System.out.println(date.isLeapYear());

		System.out.println(date.get(ChronoField.YEAR));
		System.out.println(date.get(ChronoField.MONTH_OF_YEAR));
		System.out.println(date.get(ChronoField.DAY_OF_MONTH));

		LocalDate today = LocalDate.now();
		System.out.println(today);

		LocalTime localTime = LocalTime.of(11, 5, 00);
		System.out.println(localTime);

		LocalDate localDate = LocalDate.parse("2020-07-30");
		System.out.println(localDate);
		LocalTime time = LocalTime.parse("11:07:00");
		System.out.println(time);
		LocalDateTime localDateTime = LocalDateTime.now();

//		
//		Duration duration=Duration.between(LocalTime.now(), LocalTime.now());
//		System.out.println(duration);

		LocalDate dob = LocalDate.of(1983, 10, 5);
		LocalDate todayy = LocalDate.now();

		System.out.println(Period.between(dob, todayy));

	}

}
