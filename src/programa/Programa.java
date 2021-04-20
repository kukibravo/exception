package programa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import programa.entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do quarto: ");
		int numero = sc.nextInt();
		System.out.print("Data de check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data de check-out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva! A data de check-out não pode ser maior que a data de check-in.");
		}else {
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva :" + reserva);
			
			System.out.println();
			System.out.println("Digite os dados da atualizacao da reserva:");
			System.out.print("Data de check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date agora = new Date();
			
			if(checkIn.before(agora) || checkOut.before(agora)) {
				System.out.println("Erro na reserva! As datas devem ser futuras.");
			}else if(!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva! A data de check-out não pode ser maior que a data de check-in.");
			}else {
				reserva.atualizaDatas(checkIn, checkOut);
				System.out.println("Reserva :" + reserva);
			}
		}
		
		//Deu certo!
		
		sc.close();

	}

}
