
public class TextTrim {
	public static void main(String ar[]){
		
		//���ڿ��� ��� ����(�����ϰ��� ���ڿ�) ����
		String str = "a ab acb gf   ";
		str = str.replaceAll(" " , "" );
		String str1= "aabacbgf";
		if(str.equals(str1)){
			System.out.println(str + "=" + str1 +":" + "��ġ");
		}else{
			System.out.println("����ġ");
		}
		////////////////////////////////////////////////////////
		
		//���ϴ� ���ڸ� ��������
		String sString = "102.154��";
		String sub_temp = sString.substring(0,4);	  
		System.out.println(sub_temp);
		////////////////////////////////////////////////////////
	}
}
