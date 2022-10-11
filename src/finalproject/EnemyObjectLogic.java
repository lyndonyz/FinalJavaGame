package finalproject;

public class EnemyObjectLogic {
	String shape;
	boolean active,moveX, moveY, indicator,indiActive;
	int x1,y1,x2,y2;
	int timeStart, timeEnd, moveSpeed;
	EnemyObjectLogic(String shape, boolean active, int x1, int y1, int x2, int y2, int timeStart, int timeEnd, boolean moveX, boolean moveY,int moveSpeed,boolean indicator,boolean indiActive){
		this.shape = shape;
		this.active = active;
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.moveX = moveX;
		this.moveY = moveY;
		this.moveSpeed = moveSpeed;
		this.indicator = indicator;
		this.indiActive = indiActive;
	}
}
