package com.govtech.demo.generic;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


@Log4j2
public abstract class ASqlService<T> implements ISqlService<T> {

    @Autowired
    JdbcTemplate jdbcTemplate = null;

    private Class<T> entityClass;
    private  String className;


    public ASqlService() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        entityClass = (Class) pt.getActualTypeArguments()[0];
        className = entityClass.getSimpleName().toLowerCase();
    }


    @Override
    public List<T> list(String sql) {

        log.info(sql);
        RowMapper<T> rowMapper = new BeanPropertyRowMapper<T>(entityClass);
        return jdbcTemplate.query(sql, rowMapper);

    }



}
