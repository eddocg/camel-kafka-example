package com.eddocg.processors;

import com.eddocg.dao.RecordsDAOIF;
import com.eddocg.model.Help;
import net.sf.json.JSONObject;
import org.apache.camel.BeanInject;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GetAllRecordsProcessor implements Processor {

    /** The class-wide logger. */
    private static final Logger LOG = LoggerFactory.getLogger(GetAllRecordsProcessor.class);

    @BeanInject("recordsDAO")
    private RecordsDAOIF recordsDAO;
    @Override
    public void process(Exchange exchange) throws Exception {
        LOG.info("Processor started.");
        List<Help> recordList = recordsDAO.findAll();

        List<String> stringList = new ArrayList<>();

        for(Help h : recordList){
            JSONObject product = getRecordJSON(h.getSequence(), h.getInfo());
            stringList.add(product.toString());
        }


        exchange.getIn().setBody(stringList);
        //exchange.getOut().setBody(recordList);
    }


    private JSONObject getRecordJSON(String seq, String info) {

        JSONObject root = new JSONObject();
        JSONObject record = new JSONObject();
        record.put("seq", seq);
        record.put("info", info);
        root.put("record", record);

        return root;
    }
}
