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
		Member member = new Member("���ȯ", "dragonbead95@naver.com", 26);
		byte[] serializedMember = null; // ����ȭ�� ����Ʈ �迭
		
		try(ByteArrayOutputStream baos = new ByteArrayOutputStream())
		{
			try(ObjectOutputStream oos = new ObjectOutputStream(baos))
			{
				oos.writeObject(member);
				// serializedMembre => ����ȭ�� member ��ü
				serializedMember = baos.toByteArray();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// ����Ʈ �迭�� ������ ����ȭ �����͸� base64�� ��ȯ
		System.out.println(Base64.getEncoder().encodeToString(serializedMember));
		
		
		/////////////////////////////////////////////////////////////////////////////////////
		String base64Member = Base64.getEncoder().encodeToString(serializedMember);
		serializedMember = Base64.getDecoder().decode(base64Member);
		
		try(ByteArrayInputStream bais = new ByteArrayInputStream(serializedMember))
		{
			try(ObjectInputStream ois = new ObjectInputStream(bais))
			{
				// ������ȭ�� Member ��ü�� �о�´�.
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
		
		// CSV ����ȭ
		Member member3 = new Member("���ȯ", "dragonbead95@naver.com", 26);
		// member ��ü�� csv�� ��ȯ
		String csv = String.format("%s,%s,%d", member.getName(), member.getEmail(), member.getAge());
		System.out.println("csv : " + csv);
		
		//JSON ����ȭ
		Member member4 = new Member("���ȯ", "dragonbead95@naver.com", 26);
		// member��ü�� json���� ��ȯ
		String json = String.format("{\"name\":\"%s\", \"email\":\"%s\", \"age\":%d}",
									member.getName(), member.getEmail(), member.getAge());
		System.out.println("json : " + json);
	}	

}
