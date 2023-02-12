package conwaygame;
import java.util.ArrayList;
/**
 * Conway's Game of Life Class holds various methods that will
 * progress the state of the game's board through it's many iterations/generations.
 *
 * Rules 
 * Alive cells with 0-1 neighbors die of loneliness.
 * Alive cells with >=4 neighbors die of overpopulation.
 * Alive cells with 2-3 neighbors survive.
 * Dead cells with exactly 3 neighbors become alive by reproduction.

 * @author Seth Kelley 
 * @author Maxwell Goldberg
 */
public class GameOfLife {

    // Instance variables
    private static final boolean ALIVE = true;
    private static final boolean  DEAD = false;

    private boolean[][] grid;    // The board has the current generation of cells
    private int totalAliveCells; // Total number of alive cells in the grid (board)

    /**
    * Default Constructor which creates a small 5x5 grid with five alive cells.
    * This variation does not exceed bounds and dies off after four iterations.
    */
    public GameOfLife() {
        grid = new boolean[5][5];
        totalAliveCells = 5;
        grid[1][1] = ALIVE;
        grid[1][3] = ALIVE;
        grid[2][2] = ALIVE;
        grid[3][2] = ALIVE;
        grid[3][3] = ALIVE;
    }

    /**
    * Constructor used that will take in values to create a grid with a given number
    * of alive cells
    * @param file is the input file with the initial game pattern formatted as follows:
    * An integer representing the number of grid rows, say r
    * An integer representing the number of grid columns, say c
    * Number of r lines, each containing c true or false values (true denotes an ALIVE cell)
    */
    public GameOfLife (String file) {

        // WRITE YOUR CODE HERE

        StdIn.setFile(file);

        int rows = StdIn.readInt();
        int columns = StdIn.readInt();

        grid = new boolean[rows][columns];


        for(int i = 0; i<rows; i++)
        {
             for(int j =0; j<columns; j++)
             {
                boolean a = StdIn.readBoolean();
                grid[i][j] = a;
                if(grid[i][j] == true){
                    totalAliveCells++;
                }


             }
        }


    }

    /**
     * Returns grid
     * @return boolean[][] for current grid
     */
    public boolean[][] getGrid () {
        return grid;
    }
    
    /**
     * Returns totalAliveCells
     * @return int for total number of alive cells in grid
     */
    public int getTotalAliveCells () {
        return totalAliveCells;
    }

    /**
     * Returns the status of the cell at (row,col): ALIVE or DEAD
     * @param row row position of the cell
     * @param col column position of the cell
     * @return true or false value "ALIVE" or "DEAD" (state of the cell)
     */
    public boolean getCellState (int row, int col) {

        // WRITE YOUR CODE HERE
        boolean a = grid[row][col];

        return a; // update this line, provided so that code compiles
    }

    /**
     * Returns true if there are any alive cells in the grid
     * @return true if there is at least one cell alive, otherwise returns false
     */
    public boolean isAlive () {

        // WRITE YOUR CODE HERE

        boolean[][] temp = getGrid();
        int rows = temp.length;
        int columns = temp[0].length;
        int count = 0;

        boolean a = false;
        

        
            for(int i = 0; i<rows; i++)
            {
                for(int j =0; j<columns; j++)
                {
                    a = temp[i][j];
                    if(a == true){
                        count++;
                    }
                    
                }
            }

        if(count >0){
            return true;
        } else{
            return false;
        }
        
        // update this line, provided so that code compiles
    }

    /**
     * Determines the number of alive cells around a given cell.
     * Each cell has 8 neighbor cells which are the cells that are 
     * horizontally, vertically, or diagonally adjacent.
     * 
     * @param col column position of the cell
     * @param row row position of the cell
     * @return neighboringCells, the number of alive cells (at most 8).
     */
    public int numOfAliveNeighbors (int row, int col) {

        // WRITE YOUR CODE HERE
         boolean[][] temp = getGrid();
         int r = temp.length;
        int c = temp[0].length;

//if its (0,1) -1 means its -1

        
        int counter = 0;
        int x = row;
        int y = col;

        boolean[] Ngrid = new boolean[8];



        x = row + 1; //top right corner
        y = col + 1;

        if(x<0){
            x = x+r;
        }else if(x>r-1){
            x= x -r;
        }

        if(y<0){
            y = y+c;
        } else if(y>c-1){
            y = y-c;
        }

        Ngrid[0] = temp[x][y];
        if(Ngrid[0] == true){
            counter++;
        }

        x = row - 1; //top left corner
        y = col + 1;

        if(x<0){
            x = x+r;
        }else if(x>r-1){
            x= x -r;
        }

        if(y<0){
            y = y+c;
        } else if(y>c-1){
            y = y-c;
        }

        Ngrid[1] = temp[x][y];
        if(Ngrid[1] == true){
            counter++;
        }

        x = row + 1; // bottom right corner
        y = col - 1;

        if(x<0){
            x = x+r;
        }else if(x>r-1){
            x= x -r;
        }

        if(y<0){
            y = y+c;
        } else if(y>c-1){
            y = y-c;
        }

        Ngrid[2] = temp[x][y];
        if(Ngrid[2] == true){
            counter++;
        }

        x = row - 1; // bottom left corner
        y = col - 1;

        if(x<0){
            x = x+r;
        }else if(x>r-1){
            x= x -r;
        }

        if(y<0){
            y = y+c;
        } else if(y>c-1){
            y = y-c;
        }

        Ngrid[3] = temp[x][y];
        if(Ngrid[3] == true){
            counter++;
        }

        x = row ;    //bottom
        y = col - 1;

        if(x<0){
            x = x+r;
        }else if(x>r-1){
            x= x -r;
        }

        if(y<0){
            y = y+c;
        } else if(y>c-1){
            y = y-c;
        }

        Ngrid[4] = temp[x][y];
        if(Ngrid[4] == true){
            counter++;
        }


        x = row;    //top
        y = col + 1;

        if(x<0){
            x = x+r;
        }else if(x>r-1){
            x= x -r;
        }

        if(y<0){
            y = y+c;
        } else if(y>c-1){
            y = y-c;
        }

        Ngrid[5] = temp[x][y];
        if(Ngrid[5] == true){
            counter++;
        }

        x = row + 1;  //right
        y = col;

        if(x<0){
            x = x+r;
        }else if(x>r-1){
            x= x -r;
        }

        if(y<0){
            y = y+c;
        } else if(y>c-1){
            y = y-c;
        }

        Ngrid[6] = temp[x][y];
        if(Ngrid[6] == true){
            counter++;
        }

        x = row - 1; //left
        y = col;

        if(x<0){
            x = x+r;
        }else if(x>r-1){
            x= x -r;
        }

        if(y<0){
            y = y+c;
        } else if(y>c-1){
            y = y-c;
        }

        Ngrid[7] = temp[x][y];
        if(Ngrid[7] == true){
            counter++;
        }

        

        

        

        


  
        return counter; // update this line, provided so that code compiles
    }

    /**
     * Creates a new grid with the next generation of the current grid using 
     * the rules for Conway's Game of Life.
     * 
     * @return boolean[][] of new grid (this is a new 2D array)
     */
    public boolean[][] computeNewGrid () {

        // WRITE YOUR CODE HERE
        boolean[][] ogrid = getGrid();
        boolean[][] ngrid = new boolean[ogrid.length][ogrid[0].length];
        boolean temper = true;
        boolean btemp = true;


        int temp = 0; //counts alive neighbors

        for(int i = 0; i<ogrid.length; i++){
            for(int j =0; j<ogrid[0].length; j++){

                temper = ogrid[i][j];
                temp = numOfAliveNeighbors(i, j);

                if(temper == ALIVE && (temp <= 1 || temp >= 4)){ //if the cell is alive and has either 4 or more or less than one
                    btemp = DEAD;
                    ngrid[i][j] = btemp;
                }else if(temper == ALIVE && (temp ==2 || temp ==3)){ // if cell is alive and has 2 or 3 neighbors
                    btemp = ALIVE;
                    ngrid[i][j] = btemp;
                }else if(temper == DEAD && temp == 3){
                    btemp = ALIVE;
                    ngrid[i][j] = btemp;
                }
            }
        }


        return ngrid;// update this line, provided so that code compiles
    }

    /**
     * Updates the current grid (the grid instance variable) with the grid denoting
     * the next generation of cells computed by computeNewGrid().
     * 
     * Updates totalAliveCells instance variable
     */
    public void nextGeneration () {

        // WRITE YOUR CODE HERE
        boolean[][] joe = computeNewGrid();

        for(int i =0; i<this.grid.length; i++){
            for(int j =0; j<this.grid[0].length; j++){
                this.grid[i][j] = joe[i][j];
            }
        }
    }

    /**
     * Updates the current grid with the grid computed after multiple (n) generations. 
     * @param n number of iterations that the grid will go through to compute a new grid
     */
    public void nextGeneration (int n) {

        // WRITE YOUR CODE HERE

        for(int i=0; i<n; i++){
            nextGeneration();
        }
    }

    /**
     * Determines the number of separate cell communities in the grid
     * @return the number of communities in the grid, communities can be formed from edges
     */
    public int numOfCommunities() {

        // WRITE YOUR CODE HERE
int low = grid.length;
int lols = grid[0].length;
int n =0;
int x;
int y;

boolean boo = true;
int term1 = 0;
int term2 = 0;



WeightedQuickUnionUF var = new WeightedQuickUnionUF(low, lols);



for(int i=0; i<low; i++) // using this for loop as a pointer to union all false variables
{
    for(int j =0; j<lols;j++)
    {
        boo = getCellState(i, j);
        if(boo == false)
        {
            term1 = i;
            term2 = j;
            
        }
    }
}



for(int i=0; i<low; i++) //looping through each cell and finding all alive neighbors
{
    for(int j = 0; j<lols; j++)
    {
if(getCellState(i, j) == true) //if statement to only check and link alive neighbors together
{
        x = i + 1; //top right
        y = j + 1;

        if(x < 0)
        {
            x = x + low;

        } else if(x > low-1 )

        {
            x = x - low;
        }

        if( y < 0)
        {
            y = y + lols;
        } else if(y > lols-1)

        {
            y = y - lols;
        }

        if(getCellState(x, y) == true)
        {
            var.union(i, j, x, y);
            
        }
        x = i - 1; //top left
        y = j + 1;

        if(x < 0)
        {
            x = x + low;

        } else if(x > low-1 )

        {
            x = x - low;
        }

        if( y < 0)
        {
            y = y + lols;
        } else if(y > lols-1)

        {
            y = y - lols;
        }

        if(getCellState(x, y) == true)
        {
            var.union(i, j, x, y);
        }
        x = i; // top
        y = j + 1;

        if(x < 0)
        {
            x = x + low;

        } else if(x > low-1 )

        {
            x = x - low;
        }

        if( y < 0)
        {
            y = y + lols;
        } else if(y > lols-1)

        {
            y = y - lols;
        }

        if(getCellState(x, y) == true)
        {
            var.union(i, j, x, y);
        }
        x = i; //bottom
        y = j - 1;

        if(x < 0)
        {
            x = x + low;

        } else if(x > low-1 )

        {
            x = x - low;
        }

        if( y < 0)
        {
            y = y + lols;
        } else if(y > lols-1)

        {
            y = y - lols;
        }

        if(getCellState(x, y) == true)
        {
            var.union(i, j, x, y);
        }
        x = i - 1; //bottom left
        y = j - 1;

        if(x < 0)
        {
            x = x + low;

        } else if(x > low-1 )

        {
            x = x - low;
        }

        if( y < 0)
        {
            y = y + lols;
        } else if(y > lols-1)

        {
            y = y - lols;
        }

        if(getCellState(x, y) == true)
        {
            var.union(i, j, x, y);
        }
        x = i + 1; // bottom right
        y = j - 1;

        if(x < 0)
        {
            x = x + low;

        } else if(x > low-1 )

        {
            x = x - low;
        }

        if( y < 0)
        {
            y = y + lols;
        } else if(y > lols-1)

        {
            y = y - lols;
        }

        if(getCellState(x, y) == true)
        {
            var.union(i, j, x, y);
        }
        x = i + 1; //right
        y = j;

        if(x < 0)
        {
            x = x + low;

        } else if(x > low-1 )

        {
            x = x - low;
        }

        if( y < 0)
        {
            y = y + lols;
        } else if(y > lols-1)

        {
            y = y - lols;
        }

        if(getCellState(x, y) == true)
        {
            var.union(i, j, x, y);
        }
        x = i - 1; //left
        y = j;

        if(x < 0) 
        {
            x = x + low;

        } else if(x > low-1 )

        {
            x = x - low;
        }

        if( y < 0)
        {
            y = y + lols;
        } else if(y > lols-1)

        {
            y = y - lols;
        }

        if(getCellState(x, y) == true)
        {
            var.union(i, j, x, y);
        } else {
            var.union(x,y,x,y);
        }
     
     } else{
        var.union(term1,term2, i,j);
     }

     
    }
}


int zro = var.find(term1,term2);
int count2 =1;
ArrayList<Integer> supa = new ArrayList<>();

for(int i =0; i<low; i++)
{
    for(int j=0; j<lols; j++)
    {
        n = var.find(i, j);
        if(n != zro)
        {
            supa.add(n);
        }
    }
}


int siz = supa.size();
int[] array = new int[siz];

for(int i =0; i<siz; i++){
array[i] = supa.get(i);
}

int tenea =0;
for(int i =0; i<array.length; i++)
{
    for(int j =i+1; j<array.length; j++)
    {
        if(array[i] > array[j])
        {
            tenea = array[i];
            array[i] = array[j];
            array[j] = tenea;
        }
    }
}



for(int i =1; i<siz; i++) //counting the amount of different numbers
{
if(array[i-1] != array[i]){
    count2++;
}

}


if(isAlive() == false){
return 0;
} else

{
    return count2;
}


//   update this line, provided so that code compiles
}

  
    }

