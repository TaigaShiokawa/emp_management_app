package model.map;

import java.util.HashMap;
import java.util.Map;

public class PostMap {
	public static final Map<Integer, String> POST_MAP = new HashMap<>();
	static {
		POST_MAP.put(1, "一般社員");
		POST_MAP.put(2, "主任");
		POST_MAP.put(3, "係長");
		POST_MAP.put(4, "課長");
	} //初期化ブロック. クラスがロードされた時に実行.
	
	public static String getpost(int map) {
		return POST_MAP.getOrDefault(map, "一般社員");
	}

}
