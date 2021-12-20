package Service;

import pojo.EchartsBean;
import pojo.PageBean;
import pojo.Person;

import java.util.List;

public interface PersonService {
    public PageBean<Person> queryPersonsByPage(int currentPage, int pageSize);
    public boolean addPerson(Person person);
    public boolean updatePerson(Person person);
    public Person queryOnePersonById(Integer id);
    public boolean deletePersonById(Integer id);
    public boolean deletePersonByBatch(String ids);
    public List<Person> getListByName(String name);
    public List<Person> getListByTel(String tele);
    public List<EchartsBean> findCountByAddress();

}
