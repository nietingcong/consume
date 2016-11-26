package com.wiseweb.ntc.comment.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class BaseDao<T,ID extends Serializable> {
	private Class<T> clazz;
	@Autowired
    private SessionFactory sessionFactory;
	public BaseDao() {
		this.clazz = ReflectUtils.getSuperClassGenricType(this.getClass());
	}
	public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
	public T get(ID id) {
        return (T)getSession().get(this.clazz,id);
    }

    public List<T> getAll() {
        String hql = "from "+clazz.getName();
        return getSession().createQuery(hql).list();
    }

    public Long getTotalCount() {
        Session session = getSession();
        String hql = "select count(*) from "+clazz.getName();
        Number number = (Number) session.createQuery(hql).uniqueResult();
        session.close();
        return number == null ? 0 : number.longValue();
    }

    public void save(T obj) {
        Session session = getSession();
        session.save(obj);
    }

    public void deleteById(ID id) {
        Session session = getSession();
        T t = (T) session.get(this.clazz,id);
        session.delete(t);
    }

    public void deleteBatch(ID[] ids) {
        for(ID id:ids) {
            T t = (T) getSession().get(this.clazz,id);
            if(t != null) {
                getSession().delete(t);
            }
        }
    }
}
