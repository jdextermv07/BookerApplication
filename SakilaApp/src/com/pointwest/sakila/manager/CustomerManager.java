package com.pointwest.sakila.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pointwest.sakila.bean.AddressBean;
import com.pointwest.sakila.bean.CustomerBean;
import com.pointwest.sakila.repository.CustomerDao;

public class CustomerManager {

	CustomerDao custDao = new CustomerDao();
	Map<CustomerBean, List<AddressBean>> mapCustAdd = new HashMap<CustomerBean, List<AddressBean>>();
	Map<AddressBean, List<CustomerBean>> mapAddCust = new HashMap<AddressBean, List<CustomerBean>>();
	
	public Map<CustomerBean, List<AddressBean>> returnCustomerByFirstName(String parameter) {
		Map<CustomerBean, List<AddressBean>> mapCustAdd = new HashMap<CustomerBean, List<AddressBean>>();

		for (CustomerBean value : custDao.returnCustomerDetails(parameter.toLowerCase())) {
			List<AddressBean> addressCust = custDao.returnAddressDetails(value);
			mapCustAdd.put(value, addressCust);
		}

		return mapCustAdd;

	}

	public Map<CustomerBean, List<AddressBean>> returnCustomerByLastName(String parameter) {
		Map<CustomerBean, List<AddressBean>> mapCustAdd = new HashMap<CustomerBean, List<AddressBean>>();

		for (CustomerBean value : custDao.returnCustomerDetailsLN(parameter.toLowerCase())) {
			List<AddressBean> addressCust = custDao.returnAddressDetails(value);
			mapCustAdd.put(value, addressCust);
		}

		return mapCustAdd;
	}
	public Map<AddressBean, List<CustomerBean>> returnCustomerByCountry(String parameter){
		Map<AddressBean, List<CustomerBean>> mapAddCust = new HashMap<AddressBean, List<CustomerBean>>();

		for (AddressBean value : custDao.returnAddressDetailsUsingCountry(parameter.toLowerCase())) {
			List<CustomerBean> custAdd = custDao.returnCustomerDetailsCountry(value);
			mapAddCust.put(value, custAdd);	
		}
		
		return mapAddCust;
	}
}
