package model.map;

import java.util.HashMap;
import java.util.Map;

public class DepartmentMap {
	public static final Map<Integer, String> DEPARTMENT_MAP = new HashMap<>();
	static {
		DEPARTMENT_MAP.put(1, "企画課");
		DEPARTMENT_MAP.put(2, "情報システム課");
		DEPARTMENT_MAP.put(3, "財務課");
	} //初期化ブロック. クラスがロードされた時に実行.
	
	public static String getDepartment(int map) {
		return DEPARTMENT_MAP.getOrDefault(map, "無所属");
	}

}
