package Calc;
import java.util.Scanner;

public class calc{
	public static void main (String[] args) {
//	while (true) {
		String inputstring="",virajenie="";
		String[] word_len;
		String rezult="";
		int tryer=0;
		System.out.println("Для получения результата введите арифметическое выражение в виде x * y,");
		System.out.println("где x и y могут быть арабские, либо римские числа от 1 до 10, ");
		System.out.println("в качестве * могут выступать операторы +,-,*,/ \n");
		Scanner input = new Scanner(System.in); //ввод выражения
		inputstring=input.nextLine();//в строку
		input.close();//закрываем портал
		virajenie=inputstring.trim();
		word_len=inputstring.split(" ");
//		if(virajenie=="999") {
//			break;
//		} 		
		if ( word_len.length!=3) {
			try { 
				tryer= 1/0;

				} catch (Exception e) {
					System.out.println("Формат математической операции не удовлетворяет заданию" );
				}
			return;
		} else
			rezult=calc(inputstring);
		} //end if
//	}
	
	
	public static String calc(String input) {
		byte operand1=0;
		byte operand2=0;
		int edenitsi=0;
		StringBuilder rezult = new StringBuilder(""); 
		String[] word;
		boolean arab = false, rim =false ;
		int rezult_calc = 0;
		int tryer=0;
		word=input.split(" ");
		operand1=checkop(word[0]);
		operand2=checkop(word[2]);
		if (operand1<=0 || operand1>10 || operand2<=0 || operand2>10) {
			try {
				tryer = 1/0	;
				} catch (Exception e) {
					System.out.println("Формат математической операции не удовлетворяет заданию: числа должны быть от 1 до 10");
				}
			return "";
		}
		if (  	(word[0].equals("1") //проверка арабский 
				|| word[0].equals("2") 
				|| word[0].equals("3") 
				|| word[0].equals("4") 
				|| word[0].equals("5") 
				|| word[0].equals("6") 
				|| word[0].equals("7") 
				|| word[0].equals("8") 
				|| word[0].equals("9") 
				|| word[0].equals("10"))
				 &&
				(word[2].equals("1") //  
				|| word[2].equals("2") 
				|| word[2].equals("3") 
				|| word[2].equals("4") 
				|| word[2].equals("5") 
				|| word[2].equals("6") 
				|| word[2].equals("7") 
				|| word[2].equals("8") 
				|| word[2].equals("9") 
				|| word[2].equals("10"))
				)
		{ //начало выполнения  if
			arab=true;
			rim=false;
		}	else { if ( (word[0].equals("I") //проверка римский 
						|| word[0].equals("II") 
						|| word[0].equals("III") 
						|| word[0].equals("IV") 
						|| word[0].equals("V") 
						|| word[0].equals("VI") 
						|| word[0].equals("VII") 
						|| word[0].equals("VII") 
						|| word[0].equals("IX") 
						|| word[0].equals("X"))
				 		&&
				 		(word[2].equals("I")  
				 		|| word[2].equals("II") 
				 		|| word[2].equals("III") 
				 		|| word[2].equals("IV") 
				 		|| word[2].equals("V") 
				 		|| word[2].equals("VI") 
				 		|| word[2].equals("VII") 
				 		|| word[2].equals("VII") 
				 		|| word[2].equals("IX") 
				 		|| word[2].equals("X")) ) 
						{ //начало выполнения  if
						arab=false;
						rim=true;
				} //окончание выполнения  if
					else {
						try { 
							tryer= 1/0;
				
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("Используются одновременно разные системы счисления" );
						} 
						return "";
			}
		}//окончание выполнения  if
		switch (word[1]) { //вычисление 
		case ("+"):{	
			rezult_calc=operand1+operand2;
			break;
			}
		case ("-"):{
			rezult_calc=operand1-operand2;
			if (rim && rezult_calc<0) { // проверка на орицательное число в результате
				try {
					tryer = 1/0	;
					} catch (Exception e) {
					// TODO: handle exception
						System.out.println("В римской системе нет отрицательных чисел");
					}
				return "";
				}
			break;
			}
		case ("/"):{	
			rezult_calc=operand1 / operand2;
			break;
			}
		case ("*"):{	
			rezult_calc=operand1 * operand2;
			break;
			}
		default:
			try {
				tryer = 1/0	;
				} catch (Exception e) {
				// TODO: handle exception
					System.out.println("Формат математической операции не удовлетворяет заданию");
				}
			return "";
		}//switch
		if (rim) {// если были введены римские, то преобразуем результат в римском формате
			edenitsi = rezult_calc%10; //находим единицы и присваиваем соответствующие римские цифры 
			switch (edenitsi) {
			case(1): 
				{
				rezult.append("I");
				break;
				}
			case(2): 
				{
				rezult.append("II");
				break;
				}
			case(3): 
				{
				rezult.append("III");
				break;
				}
			case(4): 
				{
				rezult.append("IV");
				break;
				}
			case(5): 
				{
				rezult.append("V");
				break;
				}
			case(6): 
				{
				rezult.append("VI");
				break;
				}
			case(7): 
				{
				rezult.append("VII");
				break;
				}
			case(8): 
				{
				rezult.append("VIII");
				break;
				}
			case(9): 
				{
				rezult.append("IX");
				break;
				}
			case(10): 
				{
				rezult.append("X");
				break;
				}
			}
			
			if (rezult_calc>=10 && rezult_calc<20) { //добавляем десятки
				rezult.insert(0,"X");
			}
			if (rezult_calc>=20 && rezult_calc<30) {
				rezult.insert(0,"XX");
			}
			if (rezult_calc>=30 && rezult_calc<40) {
				rezult.insert(0,"XXX");
			}
			if (rezult_calc>=40 && rezult_calc<50) {
				rezult.insert(0,"XL");
			}
			if (rezult_calc>=50 && rezult_calc<60) {
				rezult.insert(0,"L");
			}
			if (rezult_calc>=60 && rezult_calc<70) {
				rezult.insert(0,"LХ");
			}
			if (rezult_calc>=70 && rezult_calc<80) {
				rezult.insert(0,"LХX");
			}
			if (rezult_calc>=80 && rezult_calc<90) {
				rezult.insert(0,"LХXX");
			}
			if (rezult_calc>=90 && rezult_calc<100) {
				rezult.insert(0,"ХC");
			}
			if (rezult_calc==100) {
				rezult.insert(0,"C");
			}

			System.out.println("Результат равен : "+ rezult); 
			
	} else { if (arab) {
			rezult.append(rezult_calc);
			System.out.println("Результат равен : "+ rezult);
			}
			;
		} //if
		
	return rezult.toString();
	}
	
	// Метод (выставление соотвествий содердимого стрингового выражения и byte)
	public static byte checkop(String input) {
		byte var_checkop=0;
		int tryer;
		switch (input) {
		case ("1"):{	
			var_checkop=1;
			break;
			}
		case ("2"):{	
			var_checkop=2;
			break;
			}
		case ("3"):{	
			var_checkop=3;
			break;
			}
		case ("4"):{	
			var_checkop=4;
			break;
			}
		case ("5"):{	
			var_checkop=5;
			break;
			}
		case ("6"):{	
			var_checkop=6;
			break;
			}
		case ("7"):{	
			var_checkop=7;
			break;
			}
		case ("8"):{	
			var_checkop=8;
			break;
			}
		case ("9"):{	
			var_checkop=9;
			break;
			}
		case ("10"):{	
			var_checkop=10;
			break;
			}
		case ("I"):{	
			var_checkop=1;
			break;
			}
		case ("II"):{	
			var_checkop=2;
			break;
			}
		case ("III"):{	
			var_checkop=3;
			break;
			}
		case ("IV"):{	
			var_checkop=4;
			break;
			}
		case ("V"):{	
			var_checkop=5;
			break;
			}
		case ("VI"):{	
			var_checkop=6;
			break;
			}
		case ("VII"):{	
			var_checkop=7;
			break;
			}
		case ("VIII"):{	
			var_checkop=8;
			break;
			}
		case ("IX"):{	
			var_checkop=9;
			break;
			}
		case ("X"):{	
			var_checkop=10;
			break;
			}
		default:
			var_checkop=0;
		}
		return var_checkop;
	}
}


