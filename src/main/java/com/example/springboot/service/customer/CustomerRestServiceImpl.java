package com.example.springboot.service.customer;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

//import com.example.springboot.model.customer.Roles;
//import com.example.springboot.model.customer.api.Customer;
import com.example.springboot.rest.RestBaseServiceImpl;
import com.example.springboot.rest.model.ResponseModel;

@Service
public class CustomerRestServiceImpl extends RestBaseServiceImpl implements CustomerRestService{

	private static String WEBSITE_FULL_PATH = "https://avocado.od-tech.my/";
	
	@Override
	protected String getRestBasePath() {
		return WEBSITE_FULL_PATH;
	}

//	@Override
//	public Customer getCustomer(String idType, String idNumber){
//		ResponseModel<Customer> result = getByEntityAndParams(ApiPath.API_GET_CUSTOMER.getCode(), 
//				new ParameterizedTypeReference<ResponseModel<Customer>>() {}, null, idType, idNumber);
//		if(result != null) {
//			return result.getData();
//		}else {
//			return null;
//		}
//	}
//	
//	@Override
//	public List<Roles> getCustomerRoles(String customerId){
//		ResponseModel<List<Roles>> result = get(ApiPath.API_GET_CUSTOMER_ROLE.getCode(), customerId);
//		if(result != null) {
//			return result.getData();
//		}else {
//			return null;
//		}
//	}
	
}
