package org.typograf.classImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.typograf.DAO.WorkDAO;
import org.typograf.entity.Employee;
import org.typograf.entity.Work;
import org.typograf.functionPack.EmployeeLinkedHashMap;

import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.*;

@Repository
public class WorkImpl implements WorkDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getEmployeesForReportWork(Integer qualification, Integer idTypeMachine) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery query;
        
        query = session.createQuery("select new Employee(emp.id,emp.name,emp.surname,emp.email,emp.phone) " +
                "from Employee emp join Qualification q on emp.id=q.id.idEmployee " +
                "where q.id.idTypeMachine=:type and  q.qualification>=:qual");
        query.setParameter("type", idTypeMachine).setParameter("qual", qualification);

            return query.getResultList();
        }

    @Override
    public List getSingleWorkReportForEmp(int id_employee) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery query;
        query=session.createQuery("from Work where idEmployee.id=:id").setParameter("id",id_employee);
        return query.getResultList();
    }

    @Override
    public List<Work> getSingleReportDay(Integer id_employee, LocalDate selectDate) {
        Session session = sessionFactory.getCurrentSession();

        TypedQuery query;
        query = session.createQuery("from Work where idEmployee.id=:id_emp and dateVisit=:dv");
        query.setParameter("id_emp", id_employee).setParameter("dv", selectDate);
        return query.getResultList();
    }

    @Override
    public List<Work> getAllReportEmployees() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Work").getResultList();
    }


    // ?????????????????? ReportsWorkForOneSuitableEmp ?????????? ???????????????? ?????????????? ?????? ???????????????? ???????????????????? ???? SuitableEmployees.
    // ??????????, ?????????? ?????????????????? ?????????????????? ?? workingCoverageOfDates ?????????? ?????????????????? ???? ?????????????????? ????????(wishDate)(???? view ????????????????).
    // ?????? ?????? ???????????? ???????????? ???????? ?? ?????? ???????? 20 ??????????????, ?????? ????????????????(WorkDay) ?????????????????? ??????????????????, ??????
    // ?????????? ???????????????? ????, ?????????? ?????????????? ???????? ?????????????????????? ????????????, ???????????????????????? ?????????????? ?????????????? ??????.
    // ?????????????? ???? ???????????? ???????? ???? incrementFor, ???????? ????????-????????, ???????????? ???????????????????? ?? ???????????????? ???????????????? ???????????????????? WorkDay
    // ?? ?????????????? byWorkNow ???????????????? ???????????????????? ????????????. ???????? ???????????? ???????????? ?????? 1 1 1 1 1 1 1 1 1 1, ???? ??????????
    // ???? ???????????? 0 0 1 1 1 1 1 1 1 1, ???????? ?????????? ???????????? ?????? ?? 10:00 ?? ???? ???????????? ???????????? 2 ???????? ?? ??????????????.
    @Override
    public List<EmployeeLinkedHashMap> fillWorkingCoverageOfDates(List<Employee> SuitableEmployees, LocalDate wishDate) {

        int incrementFor=-1;
        List<EmployeeLinkedHashMap> workingCoverageOfDates=new ArrayList<>();

        for (Employee e:SuitableEmployees) {
            incrementFor+=1;
            List<Work> ReportsWorkForOneSuitableEmp= getSingleWorkReportForEmp(e.getId());
            workingCoverageOfDates.add(new EmployeeLinkedHashMap(wishDate));

            for(Work w:ReportsWorkForOneSuitableEmp) {
                if (workingCoverageOfDates.get(incrementFor).workSession.containsKey(w.getDateVisit())) {
                    workingCoverageOfDates.get(incrementFor).workSession.get(w.getDateVisit()).byWorkNow(w.getTimeStart(),w.getLaidDownTime());
                }
            }
        }
        return workingCoverageOfDates;
    }

    @Override
    public Work getSingleReportDay(Integer id_work) {
        Session session=sessionFactory.getCurrentSession();
        Work work=session.get(Work.class,id_work);

        return work;
    }
}
