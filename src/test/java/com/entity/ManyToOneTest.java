package com.entity;

import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by yuanjie.fang on 2018/2/28.
 * 测试单向多对一（学生-->班级）
 */
public class ManyToOneTest {
    public static void main(String[] args) {
//        save();
        findGradeByStudent();

    }

    //保存
    public static void save(){
        Grade g = new Grade();
        g.setGname("java三班");
        g.setGdesc("软件开发三班");
        Student s1 = new Student("小龙女","女");
        Student s2 = new Student("杨过","男");
        //设置关联关系
        g.getStudents().add(s1);
        g.getStudents().add(s2);
        s1.setGrade(g);
        s2.setGrade(g);

        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.save(g);
//        session.save(s1);
//        session.save(s2);
        tx.commit();
        HibernateUtil.colseSession(session);
    }

    //查询学生所在班级信息
    public static void findGradeByStudent(){
        Session session = HibernateUtil.getSession();
        Student student = (Student) session.get(Student.class,2);
        System.out.println(student.getGrade().getGname());
    }
}
