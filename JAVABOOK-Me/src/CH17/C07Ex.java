package CH17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C07Ex {
	static Map<String,Object> map = new HashMap();
	//01 함수의 파라미터 형으로 사용되는 경우
	public static void setMap( Map<String,Object> params ) {
		//params console에 출력
		for (String entry : params.keySet()) {
			Object values = params.get(entry);
			if (values instanceof String[]) {
				String[] down = (String[])values;
				for(int i = 0; i< down.length; i++) {
					System.out.print(down[i]+" ");
				}
			} else if(values instanceof List) {
				List down = (List)values;
				for (Object object : down) {
					System.out.print(object+" ");
				}
			}
			System.out.println();
		}
		
		params.clear();
		//params를 map 에 저장 
	}
	//02 함수의 리턴형으로 사용되는 경우
	public static Map<String,Object> getMap(){
		return map;
	}
	public static void main(String[] args) {
		//01 파라미터 생성
		Map<String,Object> params = new HashMap();
		//02 데이터 전달
		String [] value ={"정보처리기사","빅데이터분석기사","네트워크 관리사","--"}; 
		params.put("자격증",value);
		setMap(params);
		params.clear();
		//02 데이터 전달		
		List<String> hobby = new ArrayList();
		hobby.add("등산");
		hobby.add("독서");
		hobby.add("게임");
		params.put("취미", hobby);
		setMap(params);

		//03 데이터 확인
		//getMap이용해서 저장된 데이터 확인(출력)
		
		
	}
}
