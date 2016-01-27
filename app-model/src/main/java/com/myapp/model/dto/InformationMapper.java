
package com.myapp.model.dto;

import com.myapp.model.Information;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zama
 */
public class InformationMapper {
    public static InformationDTO map(Information information) {
        
			InformationDTO informationDto = new InformationDTO();
                        informationDto.setIdInformation(information.getIdInformation());
                        informationDto.setAddDate(information.getAddDate());
			informationDto.setIdTask(information.getIdTask());
			informationDto.setTextInformation(information.getTextInformation());
                        informationDto.setIdUserInfo(information.getIdUserInfo());
			                   
			return informationDto;
	}
	
	public static List<InformationDTO> map(List<Information> informations) {
		List<InformationDTO> dtos = new ArrayList<InformationDTO>();
		for (Information information: informations) {
			dtos.add(map(information));
		}
		return dtos;
	}
}
