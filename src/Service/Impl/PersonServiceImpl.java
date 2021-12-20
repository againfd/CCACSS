package Service.Impl;

import Dao.Impl.PersonDaoImpl;
import Dao.PersonDao;
import Service.PersonService;
import pojo.EchartsBean;
import pojo.PageBean;
import pojo.Person;

import java.util.List;

public class PersonServiceImpl implements PersonService {
    private PersonDao personDao=new PersonDaoImpl();


    @Override
    public PageBean<Person> queryPersonsByPage(int currentPage, int pageSize) {
        List<Person> customers=personDao.queryPersonsByPage(currentPage,pageSize);
        int total=personDao.getTotalRecords();
        PageBean<Person> pageBean=new PageBean<>();
        pageBean.setPageSize(pageSize);
        pageBean.setTotalRecords(total);
        pageBean.setCurrentPageNum(currentPage);
        pageBean.setList(customers);
        return pageBean;
    }

    @Override
    public boolean addPerson(Person person) {
        int row=personDao.addPerson(person);
        if(row>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePerson(Person person) {
        int row=personDao.updatePerson(person);
        if(row>0){
            return true;
        }
        return false;
    }

    @Override
    public Person queryOnePersonById(Integer id) {
        return personDao.queryOnePersonById(id);
    }

    @Override
    public boolean deletePersonById(Integer id) {
        int row=personDao.deletePersonById(id);
        if(row>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePersonByBatch(String ids) {
        String[] idStr=ids.split(",");
        int row=0;
        for(String id:idStr){
            row=personDao.deletePersonById(Integer.parseInt(id));
        }
        if(row>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Person> getListByName(String name) {
        return personDao.getListByName(name);
    }

    @Override
    public List<Person> getListByTel(String tele) {
        return personDao.getListByTel(tele);
    }

    @Override
    public List<EchartsBean> findCountByAddress() {
        return personDao.findCountByAddress();
    }
}
