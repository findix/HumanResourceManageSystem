package test;

import org.junit.Test;

import viewPojo.PersonAllInformation;
import dao.PersonDao;

public class test {

	@Test
	public void test() {
		PersonDao pd = new PersonDao();
		PersonAllInformation pai = pd.searchPerson("20100001");
		System.out.println(pai.getDepartmentName());
		return;
	}

}
