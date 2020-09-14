package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.dto.PatientDTO;
import com.nt.service.PatientMgmtService;
import com.nt.vo.PatientVO;

public class MainController {
	private  PatientMgmtService service;

	public MainController(PatientMgmtService service) {
			this.service = service;
	}
	
	public  List<PatientVO> getPatientsByCause(String cause1)throws Exception{
		List<PatientDTO> listDTO=null;
		List<PatientVO> listVO=null;
		PatientVO vo=null;
		//use service
		  listDTO=service.getPatientDetailsByCovid(cause1);
		  //convert listDTO to listVO
		  listVO=new ArrayList();
		  for(PatientDTO dto:listDTO) {
			  //convert each dto to each vo
                  vo=new PatientVO();
                  BeanUtils.copyProperties(dto, vo);
                  vo.setPid(Integer.valueOf(dto.getPid()));
                  vo.setPname(String.valueOf(dto.getPname()));
                  vo.setSex(String.valueOf(dto.getSex()));
                  vo.setPadd(String.valueOf(dto.getPadd()));
                  vo.setPmob(Long.valueOf(dto.getPmob()));
                  vo.setDiagnosedWith(String.valueOf(dto.getDiagnosedWith()));
                  
                  //add each vo to listVO
                  listVO.add(vo);
		  }//for
		  return listVO;
	} //method
	

}//class