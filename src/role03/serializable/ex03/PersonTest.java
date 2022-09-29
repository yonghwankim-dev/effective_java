package role03.serializable.ex03;



import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;

import static org.junit.Assert.assertThrows;


class PersonTest {

	@Test
	void whenSerializingAndDeserializing_ThenObjectIsTheSame() throws IOException, ClassNotFoundException {
		Person person = new Person();
		Address addr = new Address();
		addr.setContent("seoul");
		person.setAge(20);
		person.setName("Joe");
		person.setCountry(addr);
		
		FileOutputStream fileOutputStream = new FileOutputStream("yourfile.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		
		// Person �ʵ����� Address Ŭ������ Serializable �������̽� �����ؾ� �ϴµ�
		// ���� ���� ��� NotSerializableException ���ܰ� �߻���
		assertThrows(NotSerializableException.class, ()->{
			objectOutputStream.writeObject(person);
		});		
	}

}
