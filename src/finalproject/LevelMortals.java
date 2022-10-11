package finalproject;

import java.awt.Rectangle;
import java.io.IOException;

public class LevelMortals {
	static void Mortals(){
		 FinalGame.enemyL[199] = new EnemyObjectLogic("Rectangle",true,0,0,1000,32,0,2350,false,false,0,false,false);
		 FinalGame.enemyL[198] = new EnemyObjectLogic("Rectangle",true,0,768,1000,32,0,2350,false,false,0,false,false);
		 FinalGame.enemyL[197] = new EnemyObjectLogic("Rectangle",true,0,0,32,800,0,2350,false,false,0,false,false);
		 FinalGame.enemyL[196] = new EnemyObjectLogic("Rectangle",true,968,0,32,800,0,2350,false,false,0,false,false);
		 
		 FinalGame.enemyL[1] = new EnemyObjectLogic("Rectangle",true,160,-32,32,32,65,230,false,true,5,false,false);
		 FinalGame.enemyL[2] = new EnemyObjectLogic("Rectangle",true,315,-32,32,32,65,230,false,true,5,false,false);
		 FinalGame.enemyL[3] = new EnemyObjectLogic("Rectangle",true,470,-32,32,32,65,230,false,true,5,false,false);
		 FinalGame.enemyL[4] = new EnemyObjectLogic("Rectangle",true,625,-32,32,32,65,230,false,true,5,false,false);
		 FinalGame.enemyL[5] = new EnemyObjectLogic("Rectangle",true,780,-32,32,32,65,230,false,true,5,false,false);

		 FinalGame.enemyL[6] = new EnemyObjectLogic("Rectangle",true,160,800,32,32,235,405,false,true,(-5),false,false);
		 FinalGame.enemyL[7] = new EnemyObjectLogic("Rectangle",true,315,800,32,32,235,405,false,true,(-5),false,false);
		 FinalGame.enemyL[8] = new EnemyObjectLogic("Rectangle",true,470,800,32,32,235,405,false,true,(-5),false,false);
		 FinalGame.enemyL[9] = new EnemyObjectLogic("Rectangle",true,625,800,32,32,235,405,false,true,(-5),false,false);
		 FinalGame.enemyL[10] = new EnemyObjectLogic("Rectangle",true,780,800,32,32,235,405,false,true,(-5),false,false);
		 
		 FinalGame.enemyL[11] = new EnemyObjectLogic("Rectangle",true,-32,120,32,32,405,595,true,false,7,false,false);
		 FinalGame.enemyL[12] = new EnemyObjectLogic("Rectangle",true,-32,245,32,32,405,595,true,false,7,false,false);
		 FinalGame.enemyL[13] = new EnemyObjectLogic("Rectangle",true,-32,370,32,32,405,595,true,false,7,false,false);
		 FinalGame.enemyL[14] = new EnemyObjectLogic("Rectangle",true,-32,495,32,32,405,595,true,false,7,false,false);
		 FinalGame.enemyL[15] = new EnemyObjectLogic("Rectangle",true,-32,620,32,32,405,595,true,false,7,false,false);
		 
		 FinalGame.enemyL[16] = new EnemyObjectLogic("Rectangle",true,1000,120,32,32,575,780,true,false,-7,false,false);
		 FinalGame.enemyL[17] = new EnemyObjectLogic("Rectangle",true,1000,245,32,32,575,780,true,false,-7,false,false);
		 FinalGame.enemyL[18] = new EnemyObjectLogic("Rectangle",true,1000,370,32,32,575,780,true,false,-7,false,false);
		 FinalGame.enemyL[19] = new EnemyObjectLogic("Rectangle",true,1000,495,32,32,575,780,true,false,-7,false,false);
		 FinalGame.enemyL[20] = new EnemyObjectLogic("Rectangle",true,1000,620,32,32,575,780,true,false,-7,false,false);

		 FinalGame.enemyL[21] = new EnemyObjectLogic("Rectangle",true,0,0,500,400,800,1055,false,false,0,true,false);
		 FinalGame.enemyL[22] = new EnemyObjectLogic("Rectangle",true,0,400,500,400,885,1055,false,false,0,true,false);
		 FinalGame.enemyL[23] = new EnemyObjectLogic("Rectangle",true,500,0,500,400,970,1055,false,false,0,true,false);
		 
		 FinalGame.enemyL[24] = new EnemyObjectLogic("Rectangle",true,500,400,500,400,1140,1395,false,false,0,true,false);
		 FinalGame.enemyL[25] = new EnemyObjectLogic("Rectangle",true,500,0,500,400,1225,1395,false,false,0,true,false);
		 FinalGame.enemyL[26] = new EnemyObjectLogic("Rectangle",true,0,400,500,400,1310,1395,false,false,0,true,false);
		 
		 FinalGame.enemyL[27] = new EnemyObjectLogic("Rectangle",true,0,0,500,400,1480,1755,false,false,0,true,false);
		 FinalGame.enemyL[28] = new EnemyObjectLogic("Rectangle",true,500,0,500,400,1565,1755,false,false,0,true,false);
		 FinalGame.enemyL[29] = new EnemyObjectLogic("Rectangle",true,500,400,500,400,1670,1755,false,false,0,true,false);
		 FinalGame.enemyL[30] = new EnemyObjectLogic("Rectangle",true,0,-32,1000,32,1480,1650,false,true,5,false,false);
		 
		 FinalGame.enemyL[31] = new EnemyObjectLogic("Rectangle",true,0,400,500,400,1840,2095,false,false,0,true,false);
		 FinalGame.enemyL[32] = new EnemyObjectLogic("Rectangle",true,0,0,500,400,1925,2095,false,false,0,true,false);
		 FinalGame.enemyL[33] = new EnemyObjectLogic("Rectangle",true,500,400,500,400,2010,2095,false,false,0,true,false);
		 FinalGame.enemyL[34] = new EnemyObjectLogic("Rectangle",true,0,800,1000,32,1840,2010,false,true,(-5),false,false);
		 
		 FinalGame.enemyL[35] = new EnemyObjectLogic("Rectangle",true,450,0,100,800,2180,2435,false,false,0,true,false);
		 FinalGame.enemyL[36] = new EnemyObjectLogic("Rectangle",true,0,350,1000,100,2265,2435,false,false,0,true,false);
		 FinalGame.enemyL[37] = new EnemyObjectLogic("Rectangle",true,200,150,600,500,2350,2435,false,false,0,true,false);
		 
		 FinalGame.enemyL[195] = new EnemyObjectLogic("Rectangle",true,0,0,1000,100,2350,5000,false,false,0,true,false);
		 FinalGame.enemyL[194] = new EnemyObjectLogic("Rectangle",true,0,700,1000,100,2350,5000,false,false,0,true,false);
		 FinalGame.enemyL[193] = new EnemyObjectLogic("Rectangle",true,0,0,100,800,2350,5000,false,false,0,true,false);
		 FinalGame.enemyL[192] = new EnemyObjectLogic("Rectangle",true,900,0,100,800,2350,5000,false,false,0,true,false);
		 
		 FinalGame.enemyL[38] = new EnemyObjectLogic("Rectangle",true,0,-32,1000,32,2180,2350,false,true,5,false,false);
		 FinalGame.enemyL[39] = new EnemyObjectLogic("Rectangle",true,0,800,1000,32,2180,2350,false,true,(-5),false,false);
		 
		 FinalGame.enemyL[40] = new EnemyObjectLogic("Rectangle",true,275,0,50,800,2530,5000,false,false,0,true,false);
		 FinalGame.enemyL[41] = new EnemyObjectLogic("Rectangle",true,675,0,50,800,2530,5000,false,false,0,true,false);
		 FinalGame.enemyL[42] = new EnemyObjectLogic("Rectangle",true,0,225,1000,50,2605,5000,false,false,0,true,false);
		 FinalGame.enemyL[43] = new EnemyObjectLogic("Rectangle",true,0,525,1000,50,2605,5000,false,false,0,true,false);
		 FinalGame.enemyL[44] = new EnemyObjectLogic("Rectangle",true,475,0,50,800,2690,5000,false,false,0,true,false);
		 FinalGame.enemyL[45] = new EnemyObjectLogic("Rectangle",true,0,375,1000,50,2775,5000,false,false,0,true,false);
		 FinalGame.enemyL[46] = new EnemyObjectLogic("Rectangle",true,0,0,32,800,2530,2860,true,false,6,false,false);
		 FinalGame.enemyL[47] = new EnemyObjectLogic("Rectangle",true,0,800,1000,32,2530,2860,false,true,(-4),false,false);
		 
		 FinalGame.enemyL[48] = new EnemyObjectLogic("Rectangle",true,50,0,225,800,3230,3485,false,false,0,true,false);
		 FinalGame.enemyL[49] = new EnemyObjectLogic("Rectangle",true,250,0,225,800,3315,3485,false,false,0,true,false);
		 FinalGame.enemyL[50] = new EnemyObjectLogic("Rectangle",true,450,0,225,800,3400,3485,false,false,0,true,false);
		 
		 FinalGame.enemyL[51] = new EnemyObjectLogic("Rectangle",true,725,0,225,800,3570,3825,false,false,0,true,false);
		 FinalGame.enemyL[52] = new EnemyObjectLogic("Rectangle",true,525,0,225,800,3655,3825,false,false,0,true,false);
		 FinalGame.enemyL[53] = new EnemyObjectLogic("Rectangle",true,325,0,225,800,3740,3825,false,false,0,true,false);
		 
		 FinalGame.enemyL[54] = new EnemyObjectLogic("Rectangle",true,50,0,225,800,3910,4165,false,false,0,true,false);
		 FinalGame.enemyL[55] = new EnemyObjectLogic("Rectangle",true,250,0,225,800,3995,4165,false,false,0,true,false);
		 FinalGame.enemyL[56] = new EnemyObjectLogic("Rectangle",true,450,0,225,800,4080,4165,false,false,0,true,false);
//		 FinalGame.enemyL[54] = new EnemyObjectLogic("Rectangle",true,50,0,225,800,3910,4165,false,false,0,true,false);
//		 FinalGame.enemyL[55] = new EnemyObjectLogic("Rectangle",true,250,0,225,800,3995,4165,false,false,0,true,false);
//		 FinalGame.enemyL[56] = new EnemyObjectLogic("Rectangle",true,450,0,225,800,4080,4165,false,false,0,true,false);
		 
			for (int i = 0; i< FinalGame.enemyL.length; i++) {
				 FinalGame.enemy[i] = new Rectangle( FinalGame.enemyL[i].x1,  FinalGame.enemyL[i].y1,  FinalGame.enemyL[i].x2,  FinalGame.enemyL[i].y2);
			}
		}
}
