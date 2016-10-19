package com.bpmw.web.model.task;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestStatisticModel extends Assert{

    @Test
    public void testFillCalendar(){
        StaticticTaskModel staticticTaskModel = new StaticticTaskModel();
        Map dataGraph = new LinkedHashMap<String, Integer>();
        dataGraph = staticticTaskModel.fillCalendar(31);
        assertEquals(31, dataGraph.size());
    }

//    @Test void testGetDataGraph(){
//        StaticticTaskModel staticticTaskModel = new StaticticTaskModel();
//        Map dataGraph = new LinkedHashMap<String, Integer>();
//        staticticTaskModel.fillDataGraph("user", 31);
//        dataGraph = staticticTaskModel.getDataGraph();
//        assertEquals(31, dataGraph);
//    }
}
