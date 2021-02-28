package ulam;

public class Ulam {
    int[][] matrix;

    public Ulam(int dimension) {
        this.matrix = new int[dimension][dimension];
        fillUlam (matrix, matrix.length/2, matrix.length/2, true, 0, 1);
    }

    private void fillUlam (int[][] matrix, int x, int y, boolean goRight, int length, int iterator){

        // if first iteration
        if (length == 0){
            matrix[x][y] = iterator;
            fillUlam(matrix, x + 1, y, goRight, length + 1, ++iterator);
        }
        //if last iteration
        else if (length == matrix.length){
            for (int i = 1; i < matrix.length; i++){
                matrix[i][y] = iterator;
                iterator++;
            }

            for (int i = 0; i < matrix.length; i++){
                for (int j = 0; j < matrix[0].length; j++){
                    if(matrix[j][i] < 10) {
                        //System.err.print(" ");
                    }
                    if (isPrime(matrix[j][i])){
                        //System.err.print(matrix[j][i] + " ");
                    } else {
                        //System.out.print(matrix[j][i] + " ");
                    }
                    //System.out.print(matrix[j][i] + " ");
                }
                //System.out.print("\n");
            }
        }
        // any other iteration
        else {
            if (goRight){
                //go right
                for (int i = 0; i < length; i++){
                    matrix[x + i][y] = iterator;
                    iterator++;
                }
                //go up
                for (int j = 0; j < length; j++){
                    matrix[x + length - 1][y - j - 1] = iterator;
                    iterator++;
                }
                //next iteration
                fillUlam(matrix, x + length - 2, y - length, !goRight, length + 1, iterator);
            }
            else if (!goRight){
                //go left
                for (int i = 0; i < length; i++){
                    matrix[x - i][y] = iterator;
                    iterator++;
                }
                //go down
                for (int j = 0; j < length; j++){
                    matrix[x - length + 1][y + j + 1] = iterator;
                    iterator++;
                }
                //next iteration
                fillUlam(matrix, x - length + 2, y + length, !goRight, length + 1, iterator);
            }

        }

    }

    public void printPrimes (){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (isPrime(matrix[j][i])){
                    if(matrix[j][i] < 10) System.out.print(" ");
                    if(matrix[j][i] < 100) System.out.print(" ");
                    System.out.print(matrix[j][i] + " ");
                }
                else System.out.print("    ");
            }
            System.out.print("\n");
        }
    }

    private boolean isPrime(int N) {
        if (N < 2) return false;
        for (int i = 2; i*i <= N; i++)
            if (N % i == 0) return false;
        return true;
    }

}
