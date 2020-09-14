package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.PatientBO;
import com.nt.dao.PatientDAO;
import com.nt.dto.PatientDTO;

public class PatientMgmtServiceImpl implements PatientMgmtService {
     private  PatientDAO  dao;
     
	public PatientMgmtServiceImpl(PatientDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<PatientDTO> getPatientDetailsByCovid(String cause1)throws Exception {
		List<PatientBO> listBO=null;
		List<PatientDTO>  listDTO=null;
		PatientDTO dto=null;
		//convert inputs(desgs) to uppercase letter  (b.logic)
		cause1=cause1.toUpperCase();
	//	cause2=cause2.toUpperCase();
		//cause3=cause3.toUpperCase();
		//use DAO
		listBO=dao.getPatientDetailsByCovid(cause1);
		//convert listBO to listDTO
		  listDTO=new ArrayList();
		  for(PatientBO bo: listBO) {
			  //copy each bo to new DTO object
			 dto=new PatientDTO();
			 BeanUtils.copyProperties(bo, dto); // copies data from one javabean object to anthoer bean obj when they have matching properties names,types
	
			 dto.setPid(listDTO.size());  //serinal number generation..
			 //add each DTO 
			 listDTO.add(dto);
		  }//for
		  
		return listDTO;
	}//method
}//