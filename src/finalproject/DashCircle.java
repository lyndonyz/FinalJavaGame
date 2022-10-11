package finalproject;

import java.awt.Rectangle;

class DashCircle extends Rectangle{
	int cx, cy, radius;
	int increase = 1;
	int fade = 255;
	DashCircle(int cx, int cy, int r) {
		this.cx = cx;
		this.cy = cy;
		this.radius = r;
		recalc();
	}
	void recalc() {		
		width = height = radius*2;
		x = cx-radius;
		y = cy-radius;
	}
	void increase() {
		if (increase <100) {
			this.increase = this.increase + 10;
		}
		this.fade = this.fade - 25;
		if (this.fade <0) {
		this.fade = 0;
		}
	}
}
