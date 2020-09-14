package com.nt.dao;

import java.util.List;

import com.nt.bo.PatientBO;

public interface PatientDAO {

	public List<PatientBO> getPatientDetailsByCovid(String cause1) throws Exception;
	
}
