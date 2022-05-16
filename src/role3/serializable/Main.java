package role3.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

public class Main {

	public static void main(String args[])
	{
		Member member = new Member("김용환", "dragonbead95@naver.com", 26);
		byte[] serializedMember = null; // 직렬화된 바이트 배열
		
		try(ByteArrayOutputStream baos = new ByteArrayOutputStream())
		{
			try(ObjectOutputStream oos = new ObjectOutputStream(baos))
			{
				oos.writeObject(member);
				// serializedMembre => 직렬화된 member 객체
				serializedMember = baos.toByteArray();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// 바이트 배열로 생성된 직렬화 데이터를 base64로 변환
		System.out.println(Base64.getEncoder().encodeToString(serializedMember));
		
		
		/////////////////////////////////////////////////////////////////////////////////////
		String base64Member = Base64.getEncoder().encodeToString(serializedMember);
		serializedMember = Base64.getDecoder().decode(base64Member);
		
		try(ByteArrayInputStream bais = new ByteArrayInputStream(serializedMember))
		{
			try(ObjectInputStream ois = new ObjectInputStream(bais))
			{
				// 역직렬화된 Member 객체를 읽어온다.
				Object objectMember = ois.readObject();
				Member member1 = (Member) objectMember;
				System.out.println(member1);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// CSV 직렬화
		Member member3 = new Member("김용환", "dragonbead95@naver.com", 26);
		// member 객체를 csv로 변환
		String csv = String.format("%s,%s,%d", member.getName(), member.getEmail(), member.getAge());
		System.out.println("csv : " + csv);
		
		//JSON 직렬화
		Member member4 = new Member("김용환", "dragonbead95@naver.com", 26);
		// member객체를 json으로 변환
		String json = String.format("{\"name\":\"%s\", \"email\":\"%s\", \"age\":%d}",
									member.getName(), member.getEmail(), member.getAge());
		System.out.println("json : " + json);
	}	

}
