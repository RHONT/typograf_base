package org.typograf.classImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.typograf.DAO.WorkDAO;
import org.typograf.entity.Employee;
import org.typograf.entity.Machine;
import org.typograf.entity.Qualification;
import org.typograf.entity.Work;
import org.typograf.functionPack.EmployeeLinkedHashMap;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Repository
@Transactional
public class WorkImpl implements WorkDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> GetListEmployee(Integer i, Integer j) {
        Session session = sessionFactory.getCurrentSession();

        TypedQuery query;
        query = session.createQuery("select new Employee(emp.id,emp.name,emp.surname,emp.email,emp.phone) " +
                "from Employee emp join Qualification q on emp.id=q.id.idEmployee " +
                "where q.id.idTypeMachine=:type and  q.qualification>=:qual");
        query.setParameter("type", j).setParameter("qual", i);
        List<Employee> list = query.getResultList();
            return list;
        }

    @Override
    public List getWorkTabelForOneEmp(int id) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery query;
        query=session.createQuery("from Work where idEmployee.id=:id").setParameter("id",id);
        List<Work> list=query.getResultList();
        return list;
    }

    @Override
    public List<Work> getOneTabelDay(Integer i, LocalDate localDate) {
        Session session = sessionFactory.getCurrentSession();

        TypedQuery query;
        query = session.createQuery("from Work where idEmployee.id=:id_emp and dateVisit=:dv");
        query.setParameter("id_emp", i).setParameter("dv", localDate);
        List<Work> work= query.getResultList();

        return work;
    }

    @Override
    public List<Work> getAllTabel() {
        Session session = sessionFactory.getCurrentSession();
        List<Work> list=session.createQuery("from Work").getResultList();

        return list;
    }

    @Override
    public List<EmployeeLinkedHashMap> fillWorkingCoverageofDates(List<Employee> SuitableEmployees, LocalDate wishDate) {

        int incrementFor=-1;
        List<EmployeeLinkedHashMap> workingCoverageOfDates=new ArrayList<>();

        for (Employee e:SuitableEmployees) {
            incrementFor+=1;
            //Заполняем tabelWorkForOneSuitableEmp всеми записями табелей для текущего сотрудника из SuitableEmployees
            List<Work> tabelWorkForOneSuitableEmp=getWorkTabelForOneEmp(e.getId());
            //После, сразу синхронно добавляем в workingCoverageOfDates новый экземпляр со значением желанной даты
            workingCoverageOfDates.add(new EmployeeLinkedHashMap(wishDate));
            // Так как теперь внутри мапы у нас есть 20 записей, где значение(WorkDay) заполнено еденицами, нам
            // нужно обновить их, чтобы рабочие часы заполнились нолями, символизируя занятый рабочий час
            for(Work w:tabelWorkForOneSuitableEmp) {
                //так как мы еще не успели сделать новую итерацию, переменная incrementFor будет соответствовать нашему
                //списку если ключ-дата есть в нашей мапе, значит будем ее изменять
                if (workingCoverageOfDates.get(incrementFor).workSession.containsKey(w.getDateVisit()))
                //Достаем из списка мапу по incrementFor, ищем ключ-дату, теперь обращаемся к значению лежащего экземпляра WorkDay
                    //И функция byWorkNow изменяет внутренний массив. Если раньше массив был 1 1 1 1 1 1 1 1 1 1, то после
                    // он станет 0 0 1 1 1 1 1 1 1 1, если старт работы был в 10:00 и на работу отвели 2 часа.
                {workingCoverageOfDates.get(incrementFor).workSession.get(w.getDateVisit()).byWorkNow(w.getTimeStart(),w.getLaidDownTime());}
            }
        }
        return workingCoverageOfDates;
    }
}
