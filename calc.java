
import java.util.Scanner;

public class calc {

		public static void main (String[] args) {
		//StringBuilder virazhenie = new StringBuilder("VIII / VIII");
		String inputstring;
		StringBuilder virazhenie = new StringBuilder("");
		String vir="" ;
		String [] words;
		String strspace = " "; 
		String ourstring ;
		int edenitsi=0;
		StringBuilder resultrim = new StringBuilder(""); 
		int operand1 =0;
		int operand2 =0;
		String strop1;
		String strop2;
		String strop;
		int indSpace = 0;
		int lenvir = 0;
		int rezult=0;
		boolean correct= false, arab= false, rim= false, oparab1= false, oparab2= false, oprim1= false, oprim2= false;

		System.out.println("Для получения результата введите арифметическое выражение в виде x * y,");
		System.out.println("где x и y могут быть арабские, либо римские числа от 1 до 10, ");
		System.out.println("в качестве * могут выступать операторы +,-,*,/");
		
		Scanner input = new Scanner(System.in); //ввод выражения
		inputstring=input.nextLine();//в строку
		input.close();//закрываем портал
		
		virazhenie.append(inputstring); //копируем в  StringBuilder для возможности редактирования
		vir=virazhenie.toString();
		lenvir=virazhenie.length(); //размер (длина) строки
		indSpace=virazhenie.indexOf(strspace);
		
		/*if (lenvir<5 || indSpace<1 ){
			System.out.println("Неверный формат ввода данных или строка не является математической операцией" );
			return;
		}
		*/
		words=vir.split(" ");
		//System.out.println(words.length);
		if ( words.length!=3) {
			return;
		}
		for (byte i=0; i<words.length; i++) {
			System.out.println(words[i]);
		}
		
		
		indSpace=virazhenie.indexOf(strspace); //ищем позицию пробела
		ourstring=virazhenie.substring(0, indSpace); //выбираем из строки первый операнд
		strop1=ourstring.toString(); //1 операнд присваиваем строке 
		
		if (indSpace+1<=lenvir) { //соизмеряем со строкой позицию пробела и если она не больше то удаляем символы до первого пробела включительно
			virazhenie=virazhenie.delete(0, indSpace+1);
		}
		indSpace=virazhenie.indexOf(strspace);//ищем позицию пробела
		ourstring=virazhenie.substring(0, indSpace);//выбираем из строки операцию
		strop=ourstring;
		lenvir=virazhenie.length();
		if (indSpace+1<=lenvir) {//соизмеряем со строкой позицию пробела и если она не больше то удаляем символы до второго пробела включительно
			virazhenie=virazhenie.delete(0, indSpace+1);
		}
		ourstring=virazhenie.toString(); //выбираем из строки операнд 2
		strop2=ourstring;
		
		if (   (strop1.equals("1") //проверка на соотвествие 1-го операнда
				|| strop1.equals("2") 
				|| strop1.equals("3") 
				|| strop1.equals("4") 
				|| strop1.equals("5") 
				|| strop1.equals("6") 
				|| strop1.equals("7") 
				|| strop1.equals("8") 
				|| strop1.equals("9") 
				|| strop1.equals("10"))
				){
			oparab1=true;
			correct=true;
		}
				
		if (	(strop2.equals("1") //проверка на соотвествие 2-го операнда
				|| strop2.equals("2") 
				|| strop2.equals("3") 
				|| strop2.equals("4") 
				|| strop2.equals("5") 
				|| strop2.equals("6") 
				|| strop2.equals("7") 
				|| strop2.equals("8") 
				|| strop2.equals("9") 
				|| strop2.equals("10"))
				) {
			oparab2=true;
			correct=true;
		}

		if ((	strop1.equals("I") //проверка на соотвествие 1-го операнда
				|| strop1.equals("II") 
				|| strop1.equals("III") 
				|| strop1.equals("IV" )
				|| strop1.equals("V" )
				|| strop1.equals("VI" )
				|| strop1.equals("VII" )
				|| strop1.equals("VIII" )
				|| strop1.equals("IX" )
				|| strop1.equals("X"))
				) {
			oprim1=true;
			correct=true;
		}
				
		if ((	strop2.equals("I") //проверка на соотвествие 2-го операнда
				|| strop2.equals("II") 
				|| strop2.equals("III") 
				|| strop2.equals("IV" )
				|| strop2.equals("V" )
				|| strop2.equals("VI" )
				|| strop2.equals("VII" )
				|| strop2.equals("VIII" )
				|| strop2.equals("IX" )
				|| strop2.equals("X"))
				) {
			oprim2=true;
			correct=true;
		}

		if ((	strop.equals("+") 
				|| strop.equals("-") 
				|| strop.equals("*")
				|| strop.equals("/")
				)
			){
			correct=true;
		}
		else {
			System.out.println("Неверное, либо отсутствует арифметическое действие");
			correct=false;
		}
		
		if (!(oparab1 && oparab2) && !(oprim1 && oprim2)) {
			System.out.println("Используются одновременно разные системы счисления");
			correct=false;
		} 
		if (oparab1 && oparab2) {//цифры арабские
			arab=true;
		}
		if (oprim1 && oprim2) { //цифры римские
			rim=true;
		}
		if ( !correct) {
			System.out.println("Неверный формат ввода данных или строка не является математической операцией" );
			return;
		}
		if (arab) {// преобразование из строки в целое число 
			switch (strop1) {
			case ("1"):{	
				operand1=1;
				break;
				}
			case ("2"):{	
				operand1=2;
				break;
				}
			case ("3"):{	
				operand1=3;
				break;
				}
			case ("4"):{	
				operand1=4;
				break;
				}
			case ("5"):{	
				operand1=5;
				break;
				}
			case ("6"):{	
				operand1=6;
				break;
				}
			case ("7"):{	
				operand1=7;
				break;
				}
			case ("8"):{	
				operand1=8;
				break;
				}
			case ("9"):{	
				operand1=9;
				break;
				}
			case ("10"):{	
				operand1=10;
				break;
				}
			}
			switch (strop2) {
			case ("1"):{	
				operand2=1;
				break;
				}
			case ("2"):{	
				operand2=2;
				break;
				}
			case ("3"):{	
				operand2=3;
				break;
				}
			case ("4"):{	
				operand2=4;
				break;
				}
			case ("5"):{	
				operand2=5;
				break;
				}
			case ("6"):{	
				operand2=6;
				break;
				}
			case ("7"):{	
				operand2=7;
				break;
				}
			case ("8"):{	
				operand2=8;
				break;
				}
			case ("9"):{	
				operand2=9;
				break;
				}
			case ("10"):{	
				operand2=10;
				break;
				}
			}
	
		}
		if (rim) {// преобразование из строки в целое число
			switch (strop1) {
			case ("I"):{	
				operand1=1;
				break;
				}
			case ("II"):{	
				operand1=2;
				break;
				}
			case ("III"):{	
				operand1=3;
				break;
				}
			case ("IV"):{	
				operand1=4;
				break;
				}
			case ("V"):{	
				operand1=5;
				break;
				}
			case ("VI"):{	
				operand1=6;
				break;
				}
			case ("VII"):{	
				operand1=7;
				break;
				}
			case ("VIII"):{	
				operand1=8;
				break;
				}
			case ("IX"):{	
				operand1=9;
				break;
				}
			case ("X"):{	
				operand1=10;
				break;
				}
			}
			switch (strop2) {
			case ("I"):{	
				operand2=1;
				break;
				}
			case ("II"):{	
				operand2=2;
				break;
				}
			case ("III"):{	
				operand2=3;
				break;
				}
			case ("IV"):{	
				operand2=4;
				break;
				}
			case ("V"):{	
				operand2=5;
				break;
				}
			case ("VI"):{	
				operand2=6;
				break;
				}
			case ("VII"):{	
				operand2=7;
				break;
				}
			case ("VIII"):{	
				operand2=8;
				break;
				}
			case ("IX"):{	
				operand2=9;
				break;
				}
			case ("X"):{	
				operand2=10;
				break;
				}
			}//switch
	
		}//if
		//System.out.println(operand1);
		//System.out.println(operand2);
		switch (strop) { //вычисление 
		case ("+"):{	
			rezult=operand1+operand2;
			break;
			}
		case ("-"):{
			rezult=operand1-operand2;
			if (rim && rezult<0) { // проверка на орицательное число в результате
				System.out.println("в римской системе нет отрицательных чисел");
				return;
				}
			break;
			}
		case ("/"):{	
			rezult=operand1 / operand2;
			break;
			}
		case ("*"):{	
			rezult=operand1 * operand2;
			break;
			}
		}//switch
		//System.out.println(rezult);
		
		if (rim) {// если были введены римские, то преобразуем результат в римском формате
				edenitsi = rezult%10; //находим единицы и присваиваем соответствующие римские цифры 
				switch (edenitsi) {
				case(1): 
					{
					resultrim.append("I");
					break;
					}
				case(2): 
					{
					resultrim.append("II");
					break;
					}
				case(3): 
					{
					resultrim.append("III");
					break;
					}
				case(4): 
					{
					resultrim.append("IV");
					break;
					}
				case(5): 
					{
					resultrim.append("V");
					break;
					}
				case(6): 
					{
					resultrim.append("VI");
					break;
					}
				case(7): 
					{
					resultrim.append("VII");
					break;
					}
				case(8): 
					{
					resultrim.append("VIII");
					break;
					}
				case(9): 
					{
					resultrim.append("IX");
					break;
					}
				default:
					resultrim.append("Пусто");
				}
				
				if (rezult>=10 && rezult<20) { //добавляем десятки
					resultrim.insert(0,"X");
				}
				if (rezult>=20 && rezult<30) {
					resultrim.insert(0,"XX");
				}
				if (rezult>=30 && rezult<40) {
					resultrim.insert(0,"XXX");
				}
				if (rezult>=40 && rezult<50) {
					resultrim.insert(0,"XL");
				}
				if (rezult>=50 && rezult<60) {
					resultrim.insert(0,"L");
				}
				if (rezult>=60 && rezult<70) {
					resultrim.insert(0,"LХ");
				}
				if (rezult>=70 && rezult<80) {
					resultrim.insert(0,"LХX");
				}
				if (rezult>=80 && rezult<90) {
					resultrim.insert(0,"LХXX");
				}
				if (rezult>=90 && rezult<100) {
					resultrim.insert(0,"ХC");
				}
				if (rezult==100) {
					resultrim.insert(0,"C");
				}

				System.out.println("Результат равен : "+ resultrim); 
		} else {
			System.out.println("Результат равен : "+ rezult);
		} //if
		
		
		} //public void
} //public class



