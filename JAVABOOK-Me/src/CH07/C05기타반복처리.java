package CH07;

import java.util.ArrayList;
import java.util.List;

public class C05기타반복처리 {
	public static void main(String[] args) {
		// Collection 객체를 이용 - 저장
		List<String> lists = new ArrayList();
		lists.add("Java");
		lists.add("JSP/Servlet");
		lists.add("Spring Sts");
		lists.add("Springboot");
		lists.add("React");
		lists.add("Oracle");
		
		//기존 for
//		for(int i =0; i<lists.size(); i++) {
//			System.out.println(lists.get(i));
//		}
		//개량 for
		for(String a:lists) {
			System.out.println(a);
		}
		//Stream forEach
		lists.stream().forEach((item)->{System.out.println(item);});
	}
}
