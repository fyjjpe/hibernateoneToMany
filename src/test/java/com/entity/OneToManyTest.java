package com.entity;

import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by yuanjie.fang on 2018/2/28.
 * 测试单向一对多的关联关系（班级————>学生）
 */
public class OneToManyTest {
    public static void main(String[] args) {
//        add();
//        findStudentByGrade();
//        update();
        delete();
    }

    //将学生添加到班级
    public static void add(){
        Grade g = new Grade();
        g.setGname("java一班");
        g.setGdesc("软件开发");

        Student s1 = new Student("张三","男");
        Student s2 = new Student("李四","女");
        g.getStudents().add(s1);
        g.getStudents().add(s2);

        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.save(g);
        session.save(s1);
        session.save(s2);
        tx.commit();
        HibernateUtil.colseSession(session);
    }

    //查询班级学生信息（单向查询：班级————>学生）
    public static void findStudentByGrade(){
        Session session = HibernateUtil.getSession();
        Grade grade = (Grade) session.get(Grade.class,1);
        System.out.println(grade.getGname());

        System.out.println(grade.getStudents());
    }

    //修改学生信息
    public static void update(){
        Grade g = new Grade();
        g.setGname("java二班");
        g.setGdesc("软件开发二班");
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Student student = (Student) session.get(Student.class,3);
        g.getStudents().add(student);
        session.save(g);
        tx.commit();
        HibernateUtil.colseSession(session);
    }

    //删除学生
    public static void delete(){
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Student stu = (Student) session.get(Student.class,2);
        session.delete(stu);
        tx.commit();
        HibernateUtil.colseSession(session);
    }


}
