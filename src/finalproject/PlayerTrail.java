package finalproject;

public class PlayerTrail {
	int fade = 255;
	int x;
	int y;
	PlayerTrail(int n, int x, int y){
		this.x = x;
		this.y = y;
		if (n == 0) {
			this.fade = 101;
		}
		else if (n == 1) {
			this.fade = 152;
		}
		else if (n == 2) {
			this.fade = 253;
		}
		else {
			this.fade = 254;
		}
	}
}
