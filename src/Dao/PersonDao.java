package Dao;

import pojo.EchartsBean;
import pojo.Person;

import java.util.List;

public interface PersonDao {
    public int getTotalRecords();
    public List<Person> queryPersonsByPage(int currentPage,int PageSize);
    public int addPerson(Person person);
    public int updatePerson(Person person);
    public Person queryOnePersonById(Integer id);
    public int deletePersonById(Integer id);
    public List<Person> getListByName(String name);
    public List<Person> getListByTel(String tele);
    public List<EchartsBean> findCountByAddress();
}
