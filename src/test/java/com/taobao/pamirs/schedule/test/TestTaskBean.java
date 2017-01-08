package com.taobao.pamirs.schedule.test;

import com.taobao.pamirs.schedule.IScheduleTaskDealSingle;
import com.taobao.pamirs.schedule.TaskItemDefine;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 待调度的任务
 */
public class TestTaskBean implements IScheduleTaskDealSingle<TaskRunable>{

    @Override
    public boolean execute(TaskRunable task, String ownSign) throws Exception {
        System.out.println(ownSign);
        task.execute();
        return true;
    }

    @Override
    public List<TaskRunable> selectTasks(String taskParameter, String ownSign, int taskItemNum, List<TaskItemDefine> taskItemList, int eachFetchDataNum) throws Exception {
        List<TaskRunable> list = new ArrayList<TaskRunable>();
        TaskRunable runable = new TaskRunable();
        list.add(runable);
        return list;
    }

    @Override
    public Comparator<TaskRunable> getComparator() {
        return new Comparator<TaskRunable>() {
            @Override
            public int compare(TaskRunable o1, TaskRunable o2) {
                return 0;
            }
        };
    }

}
