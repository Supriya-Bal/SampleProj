package com.nt.test;



	import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.MainController;
import com.nt.vo.PatientVO;

	public class CovidPatientTest {

		public static void main(String[] args) {
			ApplicationContext parentCtx=null,childCtx=null;
			MainController controller=null;
			List<PatientVO> listVO=null;
			//create parent IOC container
			parentCtx=new ClassPathXmlApplicationContext("com/nt/cfgs/business_bean.xml");
			//create child IOC container
			childCtx=new ClassPathXmlApplicationContext(new String[] {"com/nt/cfgs/presentation_bean.xml"},parentCtx);
			//get Controller class object
			controller=childCtx.getBean("controller",MainController.class);
			//invoke method
			System.out.println("...................................................");
			try {
				listVO=controller.getPatientsByCause("cause1");
				//display results
				for(PatientVO vo: listVO) {
					System.out.println(vo);
				}
			}//try
			catch(Exception e){
				e.printStackTrace();
			}
			
			//close containers
			((AbstractApplicationContext) parentCtx).close();
			((AbstractApplicationContext) childCtx).close();

		}//main
	}//class
