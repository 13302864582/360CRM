package com.fz.datalibrary;

import android.content.Context;

import com.database.greenDao.db.DaoSession;
import com.database.greenDao.db.StudentDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class StudentDaoUtil {
    private static final boolean DUBUG = true;
    private DaoManager manager;
    private StudentDao studentDao;
    private DaoSession daoSession;

    public StudentDaoUtil(Context context) {
        manager = DaoManager.getInstance();
        manager.init(context);
        daoSession = manager.getDaoSession();
        manager.setDebug(DUBUG);
    }

    /**
     * 添加数据，如果有重复则覆盖
     */
    public void insertStudent(Student student) {
        manager.getDaoSession().insertOrReplace(student);
    }

    /**
     * 添加多条数据，需要开辟新的线程
     */
    public void insertMultStudent(final List<Student> students) {
        manager.getDaoSession().runInTx(new Runnable() {
            @Override
            public void run() {
                for (Student student : students) {
                    manager.getDaoSession().insertOrReplace(student);
                }
            }
        });
    }


    /**
     * 删除数据
     */
    public void deleteStudent(Student student) {
        manager.getDaoSession().delete(student);
    }

    /**
     * 删除全部数据
     */
    public void deleteAll(Class cls) {
        manager.getDaoSession().deleteAll(cls);
    }

    /**
     * 更新数据
     */
    public void updateStudent(Student student) {
        manager.getDaoSession().update(student);
    }

    /**
     * 按照主键返回单条数据
     */
    public Student listOneStudent(long key) {
        return manager.getDaoSession().load(Student.class, key);
    }

    /**
     * 根据指定条件查询数据
     */
    public List<Student> queryStudent() {
        //查询构建器
        QueryBuilder<Student> builder = manager.getDaoSession().queryBuilder(Student.class);
        List<Student> list = builder.where(StudentDao.Properties.Sex.ge(1)).where(StudentDao.Properties.Name.like("王小二")).list();
        return list;
    }

    /**
     * 查询全部数据
     */
    public List<Student> queryAll() {
        return manager.getDaoSession().loadAll(Student.class);
    }

    /**
     * 查询全部数据
     */
    /*public List<Student> queryRaw() {
        return manager.getDaoSession().getDatabase().rawQuery();
    }*/
}
