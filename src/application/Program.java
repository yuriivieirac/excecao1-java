package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Número do quarto: ");
			int number = sc.nextInt();
			System.out.print("Data de CheckIn (dd/MM/aaaa): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data de CheckOut (dd/MM/aaaa): ");
			Date checkOut = sdf.parse(sc.next());
			
		
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reserva: " + reservation);
			
			System.out.println();
			System.out.println("Insira os dados para atualizar a reserva: ");
			System.out.print("Data de CheckIn (dd/MM/aaaa): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de CheckOut (dd/MM/aaaa): ");
			checkOut = sdf.parse(sc.next());
			
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reserva: " + reservation);
		}
		catch(ParseException e) {
			System.out.println("Data inválida!");
		}
		
		catch(DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		
		catch (RuntimeException e) {
			System.out.println("Erro inesperado!");
		}

		sc.close();

	}

}
