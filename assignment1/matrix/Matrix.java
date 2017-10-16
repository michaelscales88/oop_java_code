package matrix;

class Matrix{
	int rows;
	int cols;
	int[][] matrix;

	public Matrix(){
		rows = 2;
		cols = 2;
		matrix = new int[rows][cols];
		init();
	}

	public Matrix(int newRows, int newCols){
		rows = newRows;
		cols = newCols;
		matrix = new int[rows][cols];
		init();
	}

	public Matrix(Matrix copy){
		rows = copy.rows;
		cols = copy.cols;
		matrix = copy.matrix;
	}

	private void init(){
		for( int x = 0; x < rows; x++ )
			for( int y = 0; y < cols; y++ )
				matrix[x][y] = 0;
	}

	public void randValues(){
		for( int x = 0; x < rows; x++ )
			for( int y = 0; y < cols; y++ )
				matrix[x][y] = (int)(Math.random() * 99 + 0);
	}

	public void setValue(int x, int y, int value){
		if((x < rows) && (x >= 0) && (y < cols) && (y >= 0))
			matrix[x][y] = value;
		else
			System.out.println("Assignment coordinates out of bounds.");
	}

	public void showValues(){
		if((rows > 1) && (cols > 1)){
			System.out.println("\nMatrix of size: " + rows + " x " + cols + "\n");
			for( int x = 0; x < rows; x++ ){
				for( int y = 0; y < cols; y++ )
					System.out.printf(matrix[x][y] + "\t");
				System.out.println();
			}
		}
	}

	public Matrix add(Matrix op){
		Matrix matrixSum = new Matrix(rows, cols);
		if((rows == op.rows) && (cols == op.cols)){
			for( int x = 0; x < rows; x++)
				for( int y = 0; y < cols; y++ )
					matrixSum.matrix[x][y] = matrix[x][y] + op.matrix[x][y];
		}
		else
			badOp();
		return matrixSum;
	}

	public Matrix multiply(Matrix op){
		Matrix matrixProd = new Matrix(rows, op.cols);
		if((rows == op.cols) && (cols == op.rows)){
			for( int x = 0; x < rows; x++ )
				for( int y = 0; y < cols; y++ )
					for( int z = 0; z < op.cols; z++ )
						matrixProd.matrix[x][z] += (matrix[x][y] * op.matrix[y][z]);
		}
		else
			badOp();
		return matrixProd;
	}

	private void badOp(){
		System.out.println
			("\nMatricies are incompatible sizes for operation.");
	}
}
