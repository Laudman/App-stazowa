
package com.myapp.model.dto;

import com.myapp.model.Task;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zama
 */
public class TaskMapper {
    
    public static TaskDTO map(Task task) {
			TaskDTO taskDto = new TaskDTO();
                        taskDto.setId_user(task.getId_user());
			taskDto.setId_task(task.getId_task());
			taskDto.setText(task.getText());
			taskDto.setAmountAnswer(task.getAmountAnswer());
			taskDto.setTypeOfJob(task.getTypeOfJob());
			taskDto.setTypeOfQuestion(task.getTypeOfQuestion());
                        taskDto.setTypeOfSpeak(task.getTypeOfSpeak());
                        taskDto.setVoteTaskPkt(task.getVoteTaskPkt());
                        if(task.getSubscribe().isEmpty()){
                            taskDto.setSubscribed(false);
                        }
                        else{
                            taskDto.setSubscribed(true);
                        }
			return taskDto;
	}
	
	public static List<TaskDTO> map(List<Task> tasks) {
		List<TaskDTO> dtos = new ArrayList<TaskDTO>();
		for (Task task: tasks) {
			dtos.add(map(task));
		}
		return dtos;
	}
}
