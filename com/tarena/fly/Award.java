package com.tarena.fly;
/** 
 * 獎勵 
 */  
public interface Award {
	int DOUBLE_FIRE = 0;  ///雙倍火力
	int LIFE = 1;   //1條命 
	/** 獲得獎勵型別(上面的0或1) */
	int getType();
}
