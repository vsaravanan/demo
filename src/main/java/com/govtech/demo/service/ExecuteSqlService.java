package com.govtech.demo.service;


/**
 * @author Sarav on 02 Nov 2023
 * @project govtech
 * @package com.govtech.viswa.service
 * @class ExecuteSqlService
 */

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Service
public class ExecuteSqlService {

    @Autowired
    JdbcTemplate jdbcTemplate = null;

    public Integer execute(String sql)
    {
        log.info(sql);
        Integer count = jdbcTemplate.update(sql);
        log.info("Executed records : " + count);

        return count;
    }

    public List query(String sql)
    {

        log.info(sql);
        List list =  jdbcTemplate.queryForList(sql);
        log.info("Query records : " + list.size());

        return list;



    }

    public List<String>  list(String sql) {


        log.info(sql);
        List list =  jdbcTemplate.queryForList(sql);
        log.info("Query records : " + list.size());
        List<String>  list2 = new ArrayList<>();


        for (Object ls : list) {

            Map<String, Object> map = (Map<String, Object>) ls;

            for (Object s  : map.values()) {
                list2.add(s.toString());
            }

        }
        return list2;
    }

    public Map<String, String>  map(String sql) {


        log.info(sql);
        List list =  jdbcTemplate.queryForList(sql);
        log.info("Query records : " + list.size());
        Map<String, String> map2 = new HashMap<>();

        for (Object ls : list) {

            Map<String, Object> map = (Map<String, Object>) ls;

            List values = new ArrayList(map.values());

            map2.put(values.get(0).toString(), values.get(1).toString());


        }
        return map2;

    }

    public Multimap<String, String> multimap(String sql) {


        log.info(sql);
        List list =  jdbcTemplate.queryForList(sql);
        log.info("Query records : " + list.size());
        Multimap<String, String> map2 = ArrayListMultimap.create();

        for (Object ls : list) {

            Map<String, Object> map = (Map<String, Object>) ls;

            List values = new ArrayList(map.values());

            if (values.get(1) != null) {
                map2.put(values.get(0).toString(), values.get(1).toString());
            }


        }
        return map2;

    }


    public Multimap<String, String> multimap3(String sql) {


        log.info(sql);
        List list =  jdbcTemplate.queryForList(sql);
        log.info("Query records : " + list.size());
        Multimap<String, String> map2 = ArrayListMultimap.create();

        for (Object ls : list) {

            Map<String, Object> map = (Map<String, Object>) ls;

            List values = new ArrayList(map.values());

            String key3 = "";

            if (values.size() > 2 &&  values.get(2) != null) {
                key3 = "|" +  values.get(2).toString();
            }

            map2.put(values.get(0).toString(), values.get(1).toString() + key3);


        }
        return map2;

    }

}
