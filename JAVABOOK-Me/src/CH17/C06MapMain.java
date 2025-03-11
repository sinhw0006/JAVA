package CH17;

import java.awt.RenderingHints.Key;
import java.util.HashMap;
import java.util.Map;

public class C06MapMain {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap();
		
		map.put("aaa", 1111);
		map.put("bbb", 1112);
		map.put("ccc", 1113);
		map.put("ddd", 1114);
		
		System.out.println("Size : " + map.size());
		System.out.println("bbb : " + map.get("bbb"));
		
		for (String string : map.keySet()) {
			System.out.println(string+" : "+map.get(string));
		}
	}
}
