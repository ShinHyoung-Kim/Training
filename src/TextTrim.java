
public class TextTrim {
	public static void main(String ar[]){
		
		//문자열의 모든 공백(제거하고픈 문자열) 제거
		String str = "a ab acb gf   ";
		str = str.replaceAll(" " , "" );
		String str1= "aabacbgf";
		if(str.equals(str1)){
			System.out.println(str + "=" + str1 +":" + "일치");
		}else{
			System.out.println("불일치");
		}
		////////////////////////////////////////////////////////
		
		//원하는 문자만 가져오기
		String sString = "102.154원";
		String sub_temp = sString.substring(0,4);	  
		System.out.println(sub_temp);
		////////////////////////////////////////////////////////
	}
}
