import java.util.*;

public class BombSquare extends GameSquare
{
	private boolean thisSquareHasBomb = false;
	private boolean isRevealed=false;

	//getters and setters for if square has a bomb
	public boolean isThisSquareHasBomb() {
		return thisSquareHasBomb;
	}

	public void setThisSquareHasBomb(boolean thisSquareHasBomb) {
		this.thisSquareHasBomb = thisSquareHasBomb;
	}


	public static final int MINE_PROBABILITY = 10;
	
	private int countBomb;

	public BombSquare(int x, int y, GameBoard board)
	{
		super(x, y, "images/blank.png", board);
		
		Random r = new Random();
		thisSquareHasBomb = (r.nextInt(MINE_PROBABILITY) == 0);
		
	}


	public void checkForBomb()
	{
		
		for(int x=this.xLocation-1;x<=this.xLocation+1;x++)
		{
			for(int y=this.yLocation-1;y<=this.yLocation+1;y++)
			{
				BombSquare bomb=(BombSquare)board.getSquareAt(x,y);
				if(bomb!=null)
				{
					if(bomb.isThisSquareHasBomb())
					{
						countBomb++;
					}
				}
				
				
				
			}
		}

		setImage("images/"+countBomb+".png");
		isRevealed=true;

		if(countBomb==0)
		{
			for(int x=this.xLocation-1;x<=this.xLocation+1;x++)
			{
				for(int y=this.yLocation-1;y<=this.yLocation+1;y++)
				{	
					BombSquare bomb=(BombSquare)board.getSquareAt(x,y);
					if(bomb!=null)
					{

						public void reveal()
						{
							
						}
					
						if(!(bomb.isRevealed))
						{
							bomb.clicked();
						}
					}
				}
			}

		}
		
	}


	public void clicked()
	{
		if(thisSquareHasBomb)
		{
			setImage("images/bomb.png");
			//setThisSquarehasBomb(true);
			isRevealed=true;

		}
		else if (!thisSquareHasBomb && !(this.isRevealed))
		{
			checkForBomb();
			
		}


	}
}
