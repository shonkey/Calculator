package ie.gcd.Calcutator;




import java.util.Scanner;


public class Calcuator {
	static double addition(double x, double y){
		return x+y;
	}
	static int addition(int x, int y){
		return x+y;
	}
	static double multiply(double x, double y){
		return x*y;
	}
	static int multiply(int x, int y){
		return x*y;
	}
	static int subtract(int x, int y){
		return x-y;
	}
	static double subtract(double x, double y){
		return x-y;
	}
	static double divide(double x, double y){
		if(y== 0){
			return 0;
		}else{
			return x/y;
		}
	}
	
	static double brain(double x, String symbol, double y){
		double ans =0; 
		if(symbol.equals("*")){
			ans = multiply(x,y);
		}else if(symbol.equals("/")){
			ans = divide(x,y);
		}else if(symbol.equals("-")){
			ans = subtract(x,y);
		}else if(symbol.equals("+")){
			ans = addition(x,y);
		}else if(symbol.equals("=")){

		}
		return ans;
	}
	static void printAnswer(double ans){
		System.out.println(ans);
	}
	static void printAnswer(String ans){
		System.out.println(ans);
	}
	static void printAnswer(int ans){
		System.out.println(ans);
	}
	static boolean checkIsNumber(String input){
		if(input.equals("*") || input.equals("+") || input.equals("-")
				|| input.equals("/") || input.equals("=")){
			return false; 
		}else{
			return true;
		}
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		double lhs = 0;
		double rhs = 0;
		double ans = 0;
		String input ="";
		String symbol = "";
		String equation ="";
		System.out.println("Please enter your equation");
		do{
			input = in.next();
			equation +=input +" ";
			boolean isNum = checkIsNumber(input);
			if(isNum == true){
				lhs = Double.parseDouble(input);
			}else{
				symbol= input;
				if(!symbol.equals("=")){
					input = in.next();
					equation += input +" ";
					isNum = checkIsNumber(input);
					if(isNum == true){
						rhs = Double.parseDouble(input);
						ans = brain(lhs, symbol, rhs);
						lhs = ans;
					}else{
						System.out.println("Malformed Equation");
						System.exit(1);
					}
				}
			}
		}while(!symbol.equals("="));
		printAnswer(equation +" "+lhs);
		in.close();
	}
}
