package quadratic;

public class Quadratic
{
			// variables to hold terms a, b, c;
	Double a, b, c;
	Complex p, q;

			// constructor class for Quadratic
	Quadratic(Double newA, Double newB, Double newC){
		a = newA;
		b = newB;
		c = newC;
	}

	private void calculate(){
				// discriminant, everything under the square root
		Double discriminant = (b * b) - (4 * a * c);
				// term1, -b / 2a
		Double term1 = (-b / (2 * a));
				// term2, sqrt(b^2 - 4ac)/2a
		Double term2 = Math.sqrt(Math.abs(discriminant)) / (2 * a);

				// two complex roots, p and q are of type Complex
		if( discriminant < 0.0 ){
				// assign complex p to term1 for real and term 2 for imag
			p = new Complex(term1, term2);
				// assign q as conjugate, reversing the sign of imag
			q = new Complex(p.conjugate());
		}
				// one root, q == NULL,
		else if( discriminant == 0.0 )
				// assign single root p to hold one real variable
			p = new Complex(term1);
				// two roots, p and q are type double
		else{
				// assign roots, complex type, of real variable only
			p = new Complex(term1 + term2);
			q = new Complex(term1 - term2);
		}
	}

	private void displayResults(){
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);
		System.out.println("Root 1, p = " + p.showNum());
		if( q != null )
			System.out.println("Root 2, q = " + q.showNum());
	}

	private void verifyResults(){
		System.out.println( " p + q = " + p.add(q).showNum() );
		System.out.println( " - b / a = " + (-(b / a)) );
		System.out.println( " p * q = " + p.multiply(q).showNum() );
		System.out.println( " c / a = " + (c / a) );
	}

	public static void main(String[] args){
		Quadratic eqn = new Quadratic(Double.parseDouble(args[0]),
												Double.parseDouble(args[1]),
												Double.parseDouble(args[2]));
		eqn.calculate();
		eqn.displayResults();
		eqn.verifyResults();
	}
}
