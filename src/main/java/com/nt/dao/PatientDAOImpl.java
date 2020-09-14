package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.nt.bo.PatientBO;

public class PatientDAOImpl implements PatientDAO {
	private static final String GET_PATIENT_BY_COVID="SELECT PATIENT_ID, PATIENT_NAME,SEX,ADDRESS,PATIENT_MOB,DIAGNOSED_WITH FROM PATIENTDETAILS WHERE DIAGNOSED_WITH='COVID'";
	
	private DataSource ds;
	
	public PatientDAOImpl(DataSource ds) {
		this.ds=ds;
		
	}
	
	public List<PatientBO> getPatientDetailsByCovid(String cause1)throws Exception{
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<PatientBO> listBO=null;
		PatientBO bo=null;
		try {
			//get Pooled jdbc con object
			con=ds.getConnection();
			//create PreparedStatement object
			ps=con.prepareStatement(GET_PATIENT_BY_COVID);
			//set values to query params
			//ps.setString(1, cause1); 
			//ps.setString(2, cause2); ps.setString(3, cause3);
			//execute the query
			rs=ps.executeQuery();
			//convert ResultSet object records to ListBO
			listBO=new ArrayList();
			while(rs.next()) {
				bo=new PatientBO();
				//copy each record of ResultSet obj to BO class object
				bo.setPid(rs.getInt(1));  // here simple int value given by rs.getInt(1) is automatically converted into Integer wrapper obj by using autoboxing feature (java 5)
			   bo.setPname(rs.getString(2));
			   bo.setSex(rs.getString(3));
			   bo.setPadd(rs.getString(4));  //auto boxing
			   bo.setPmob(rs.getLong(5));
			  //bo.setDiagnosedWith("COVID");
			   bo.setDiagnosedWith(rs.getString(6));
			   //add each obj of BO class to List Collection
			   listBO.add(bo);
			}//while
		}//try
		catch(SQLException se) { //known exception
			se.printStackTrace();
			throw se;  //exception rethrowing..
		}
		catch(Exception e) {  //unknow exception
			e.printStackTrace();
			throw e;  //exeception rethrowing
		}
		finally {
			//close jdbc objs
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
				throw se;  //exeception rethrowing
			}
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
				throw se;  //exeception rethrowing
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
				throw se;  //exeception rethrowing
			}
		}//finally
		
		return listBO;
	}//getPatientByCovid(-,-,-)


}//class