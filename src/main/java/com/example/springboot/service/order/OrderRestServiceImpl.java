package com.example.springboot.service.order;

import java.util.Date;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

//import com.example.springboot.model.order.Transaction;
//import com.example.springboot.model.order.api.TransactionVO;
import com.example.springboot.rest.RestBaseServiceImpl;
import com.example.springboot.rest.model.ResponseModel;

@Service
public class OrderRestServiceImpl extends RestBaseServiceImpl implements OrderRestService{
	
	private static String WEBSITE_FULL_PATH = "https://avocado.od-tech.my/";

	@Override
	protected String getRestBasePath() {
		return WEBSITE_FULL_PATH;
	}

//	@Override
//	public List<Transaction> searchOrder(String customerId, Date startDate, Date endDate, String statusCode,Integer startRecord, Integer recordLimit){
//		TransactionVO transactionVO = convertToVO(customerId, startDate, endDate, statusCode, startRecord, recordLimit);
//		ResponseModel<List<Transaction>> result = postByEntity(ApiPath.API_SEARCH_ORDER.getCode(), 
//				new ParameterizedTypeReference<ResponseModel<List<Transaction>>>() {}, transactionVO);
//		if(result != null) {
//			return result.getData();
//		}else {
//			return null;
//		}
//	}
//	
//	private TransactionVO convertToVO(String customerId, Date startDate, Date endDate, String statusCode,Integer startRecord, Integer recordLimit) {
//		TransactionVO transactionVO = new TransactionVO();
//		transactionVO.setCustomerId(customerId);
//		transactionVO.setStartDate(startDate);
//		transactionVO.setEndDate(endDate);
//		transactionVO.setStatusCode(statusCode);
//		transactionVO.setStartRecord(startRecord);
//		transactionVO.setRecordLimit(recordLimit);
//		return transactionVO;
//	}
}
