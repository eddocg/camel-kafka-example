package com.eddocg.dao.impl;

import com.eddocg.dao.RecordsDAOIF;
import com.eddocg.model.Help;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("recordsDAO")
public class JdbcRecordsDAO  extends JdbcDaoSupport implements RecordsDAOIF {

    /** The class-wide logger. */
    private static final Logger LOG = LoggerFactory.getLogger(JdbcRecordsDAO.class);

    public JdbcRecordsDAO(DataSource dataSource){
        setDataSource(dataSource);
    }

    @Override
    public List<Help> findAll() {

        String sql = "select * from help FETCH NEXT 10 ROWS ONLY";
        List<Map<String, Object>> records = getJdbcTemplate().queryForList(sql);

        List<Help> recordList = new ArrayList<>();

        LOG.info("No of records: "+records.size()+ "\n record: "+records.get(0).toString());

        for(Map a : records){
            Help record = new Help();
            record.setInfo(a.get("INFO")!=null? a.get("INFO").toString():"empty");
            record.setSequence(a.get("SEQ")!=null? a.get("SEQ").toString():"empty");
            recordList.add(record);
        }
        return recordList;
    }
}
