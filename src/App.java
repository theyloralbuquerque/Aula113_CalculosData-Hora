import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class App {

	public static void main(String[] args) {
		
		LocalDate d01 = LocalDate.parse("2022-07-20");
		LocalDateTime d02 = LocalDateTime.parse("2022-07-20T01:30:26");
		Instant d03 = Instant.parse("2022-07-20T01:30:26Z");
		
		LocalDate semanaAnteriorDate = d01.minusDays(7); // .minusDays = menos x dias.
		LocalDate semanaSeguinteDate = d01.plusDays(7); // .plusDays = mais x dias.
		
		System.out.println("Semana anterior Date = " + semanaAnteriorDate);
		System.out.println("Semana seguinte Date = " + semanaSeguinteDate);
		
		LocalDateTime semanaAnteriorDateTime = d02.minusDays(7); // .minus/plus também tem horas, minutos e segundos no LocalDateTime.
		LocalDateTime semanaSeguinteDateTime = d02.plusDays(7);
		
		System.out.println("Semana anterior DateTime = " + semanaAnteriorDateTime);
		System.out.println("Semana seguinte DateTime = " + semanaSeguinteDateTime);
		
		// Instant tem o .minus/plus(long amountToSubtract, TemporalUnit unit). Que permite especificar qual unidade e tipo eu quero usar.
		Instant semanaAnteriorInstant = d03.minus(7, ChronoUnit.DAYS); // 7 dias, ChoroUnit.DAYS = unidade dias.
		Instant semanaSeguinteInstant = d03.plus(7, ChronoUnit.DAYS);
		
		System.out.println("Semana anterior Instant = " + semanaAnteriorInstant);
		System.out.println("Semana seguinte Instant = " + semanaSeguinteInstant);
		
		
		// Calculando a duração de duas data-hora. Usa-se o objeto do tipo Duration.
		Duration t1 = Duration.between(semanaAnteriorDate.atStartOfDay(), d01.atStartOfDay()); // LocalDate não tem informação de tempo, por isso tem que converter para LocalDateTime.
																 							   // Para converter para LocalDateTime usa-se o .atStartOfDay ou o .atTime().
		Duration t2 = Duration.between(semanaAnteriorDateTime, d02); // .between: permite comparar durações entre duas data-hora.
		Duration t3 = Duration.between(semanaAnteriorInstant, d03);
		
		System.out.println("t1 = " + t1.toDays());
		System.out.println("t2 = " + t2.toDays()); // .toDays(): exibe o tempo em dias. 
		System.out.println("t3 = " + t3.toDays());
		
		// Se eu colocar uma data posterior menos(-) uma data anterior será exibido o -7, por exemplo.
		
	}

}
