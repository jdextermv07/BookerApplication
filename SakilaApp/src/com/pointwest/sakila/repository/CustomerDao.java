package com.pointwest.sakila.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.pointwest.sakila.bean.AddressBean;
import com.pointwest.sakila.bean.CustomerBean;
import com.pointwest.sakila.bean.FilmBean;

public class CustomerDao {

	Logger logger = Logger.getLogger(CustomerDao.class);
	public List<CustomerBean> returnCustomerDetails(String param) {

		File inputFileCustomer = new File("customer-table.txt");
		Scanner scanner1;
		List<CustomerBean> customer = new ArrayList<CustomerBean>();
		String[] customerDetails;
		CustomerBean customerBean;

		try {
			scanner1 = new Scanner(inputFileCustomer);
			String toNext = scanner1.nextLine();
			while (scanner1.hasNext()) {
				customerDetails = scanner1.nextLine().split("\\|");
				if (customerDetails[2].toLowerCase().indexOf(param) != -1) {
					customerBean = new CustomerBean();
					customerBean.setCustAddressID(customerDetails[0]);
					customerBean.setStoreID(customerDetails[1]);
					customerBean.setCustomerFN(customerDetails[2]);
					customerBean.setCustomerLN(customerDetails[3]);
					customerBean.setCustomerEmail(customerDetails[4]);
					customerBean.setCustAddressID(customerDetails[5]);

					customer.add(customerBean);
				}
			}
		} catch (FileNotFoundException e) {
			logger.error("File not found");
			System.out.println("An error occurred");

		} catch (Exception e) {
			logger.error("An error occurred");
			System.out.println("An error occurred");
		}
		return customer;
	}
	
	public List<CustomerBean> returnCustomerDetailsLN(String param) {

		File inputFileCustomer = new File("customer-table.txt");
		Scanner scanner1;
		List<CustomerBean> customer = new ArrayList<CustomerBean>();
		String[] customerDetails;
		CustomerBean customerBean;

		try {
			scanner1 = new Scanner(inputFileCustomer);
			String toNext = scanner1.nextLine();
			while (scanner1.hasNext()) {
				customerDetails = scanner1.nextLine().split("\\|");
				if (customerDetails[3].toLowerCase().indexOf(param) != -1) {
					customerBean = new CustomerBean();
					customerBean.setCustAddressID(customerDetails[0]);
					customerBean.setStoreID(customerDetails[1]);
					customerBean.setCustomerFN(customerDetails[2]);
					customerBean.setCustomerLN(customerDetails[3]);
					customerBean.setCustomerEmail(customerDetails[4]);
					customerBean.setCustAddressID(customerDetails[5]);

					customer.add(customerBean);
				}
			}
		} catch (FileNotFoundException e) {
			logger.error("File not found");
			System.out.println("An error occurred");

		} catch (Exception e) {
			logger.error("An error occurred");
			System.out.println("An error occurred");
		}
		return customer;
	}

	public List<AddressBean> returnAddressDetails(CustomerBean listCust){
		
		
		File inputFileAddress = new File("address-table.txt");
		Scanner scanner;
		
		List<AddressBean> address = new ArrayList<AddressBean>();
		String[] addressDetails;
		AddressBean addBean;
	
		try {
			scanner = new Scanner(inputFileAddress);
			String toNext = scanner.nextLine();
			while (scanner.hasNext()) {
				addressDetails = scanner.nextLine().split("\\|");
				if(listCust.getCustAddressID().equals(addressDetails[0])) {
					addBean = new AddressBean();
					addBean.setAddressID(addressDetails[0]);
					addBean.setCustAddress(addressDetails[1]);
					addBean.setAddressDistrict(addressDetails[2]);
					addBean.setAddressCity(addressDetails[3]);
					addBean.setAddressCountry(addressDetails[4]);
					
					address.add(addBean);

				}
				
			}

		} catch (FileNotFoundException e) {
			logger.error("File not found");
			System.out.println("An error occurred");

		} catch (Exception e) {
			logger.error("An error occurred");
			System.out.println("An error occurred");
		}
		return address;
	}
	
public List<AddressBean> returnAddressDetailsUsingCountry(String param){
		
		
		File inputFileAddress = new File("address-table.txt");
		Scanner scanner;
		
		List<AddressBean> address = new ArrayList<AddressBean>();
		String[] addressDetails;
		AddressBean addBean;
	
		try {
			scanner = new Scanner(inputFileAddress);
			String toNext = scanner.nextLine();
			while (scanner.hasNext()) {
				addressDetails = scanner.nextLine().split("\\|");
				if(addressDetails[4].toLowerCase().indexOf(param) != -1) {
					addBean = new AddressBean();
					addBean.setAddressID(addressDetails[0]);
					addBean.setCustAddress(addressDetails[1]);
					addBean.setAddressDistrict(addressDetails[2]);
					addBean.setAddressCity(addressDetails[3]);
					addBean.setAddressCountry(addressDetails[4]);
					
					address.add(addBean);

				}
				
			}

		} catch (FileNotFoundException e) {
			logger.error("File not found");
			System.out.println("An error occurred");

		} catch (Exception e) {
			logger.error("An error occurred");
			System.out.println("An error occurred");
		}
		return address;
	}
public List<CustomerBean> returnCustomerDetailsCountry(AddressBean addressList) {

	File inputFileCustomer = new File("customer-table.txt");
	Scanner scanner1;
	List<CustomerBean> customer = new ArrayList<CustomerBean>();
	String[] customerDetails;
	CustomerBean customerBean;

	try {
		scanner1 = new Scanner(inputFileCustomer);
		String toNext = scanner1.nextLine();
		while (scanner1.hasNext()) {
			customerDetails = scanner1.nextLine().split("\\|");
			if(addressList.getAddressID().equals(customerDetails[0])) {
				customerBean = new CustomerBean();
				customerBean.setCustAddressID(customerDetails[0]);
				customerBean.setStoreID(customerDetails[1]);
				customerBean.setCustomerFN(customerDetails[2]);
				customerBean.setCustomerLN(customerDetails[3]);
				customerBean.setCustomerEmail(customerDetails[4]);
				customerBean.setCustAddressID(customerDetails[5]);

				customer.add(customerBean);
			}
		}
	} catch (FileNotFoundException e) {
		logger.error("File not found");
		System.out.println("An error occurred");

	} catch (Exception e) {
		logger.error("An error occurred");
		System.out.println("An error occurred");
	}
	return customer;
}
}
