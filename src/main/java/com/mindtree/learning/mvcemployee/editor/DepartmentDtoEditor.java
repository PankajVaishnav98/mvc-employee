package com.mindtree.learning.mvcemployee.editor;

import java.beans.PropertyEditorSupport;

import com.mindtree.learning.mvcemployee.dto.DepartmentDto;
import com.mindtree.learning.mvcemployee.exception.controllerexception.ControllerException;
import com.mindtree.learning.mvcemployee.exception.serviceexception.ServiceException;
import com.mindtree.learning.mvcemployee.service.DepartmentService;

public class DepartmentDtoEditor extends PropertyEditorSupport{

	private DepartmentService ds;
	
	public DepartmentDtoEditor(DepartmentService ds) {
		this.ds = ds;
	}
	
	@Override
	public void setAsText(String dName) {
		DepartmentDto departmentDto = null;
		
		try {
			
			departmentDto = ds.getDepartmentByName(dName);
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		this.setValue(departmentDto);
	}
	
}
