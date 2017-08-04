import java.util.GregorianCalendar;

//Considerei sempre o menor angulo;
//Considerei a influencia do movimento do ponteiro do minuto no ponteiro da hora;
//Considerei o retorno float que é mais adequado para este exemplo;
//Fiz o calculo de quantos graus á por minuto chegando a 6 por minuto, sendo assim 30 graus por hora;
//Fiz o calculo da porcentagem que o ponteiro da hora se movimenta de acordo com o minuto, sendo assim igual ao relogio verdadeiro;
//Considerei no meu codigo a conversção do grau negativo para positivo, podendo o calculo chegar em um grau negativo;
//Setei na classe gregorianCalender para utilizar apenas hora e minuto;

public class Main {

	public static void main (String[] args){
		
		int inputHora = 0;
		int inputMinuto = 30;
		
		GregorianCalendar data = new GregorianCalendar();
		data.set(GregorianCalendar.HOUR, inputHora);
		data.set(GregorianCalendar.MINUTE, inputMinuto);
		System.out.println("Ângulo: " + new Main().retornaAnguloRelogio(data));
		
	}
	
	public float retornaAnguloRelogio(GregorianCalendar horario){
		
		float hora   = horario.get(GregorianCalendar.HOUR);
		float minuto = horario.get(GregorianCalendar.MINUTE);
	
		float porcentagemMinuto = 100*minuto/60/100;
		float distanciaHora = (hora*30)+(porcentagemMinuto*30);
		float distanciaMinuto = minuto*6;
		
		float angulo = distanciaHora - distanciaMinuto;
		
		if(angulo < 0){
			angulo = -angulo;
		}
		
		return angulo;
	}
}