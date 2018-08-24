package kr.or.nextit.customer.service;

import java.io.Serializable;


@SuppressWarnings("serial")
public class CustomerVo implements Serializable {

	private int custId;
	private String custName;
	private String custGender;
	private int custYearOfBirth;
	private String custMaritalStatus;
	private String custPostalCode;
	private String custStreetAddress;
	private String custCity;
	private int custCityId;
	private String custStateProvince;
	private int custStateProvinceId;
	private String custMainPhoneInt;
	private String custIncomeLevel;
	private String custCreditLimit;
	private String custEmail;

	private String message;
	private boolean result;
	

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustGender() {
		return custGender;
	}

	public void setCustGender(String custGender) {
		this.custGender = custGender;
	}

	public int getCustYearOfBirth() {
		return custYearOfBirth;
	}

	public void setCustYearOfBirth(int custYearOfBirth) {
		this.custYearOfBirth = custYearOfBirth;
	}

	public String getCustMaritalStatus() {
		return custMaritalStatus;
	}

	public void setCustMaritalStatus(String custMaritalStatus) {
		this.custMaritalStatus = custMaritalStatus;
	}

	public String getCustPostalCode() {
		return custPostalCode;
	}

	public void setCustPostalCode(String custPostalCode) {
		this.custPostalCode = custPostalCode;
	}

	public String getCustStreetAddress() {
		return custStreetAddress;
	}

	public void setCustStreetAddress(String custStreetAddress) {
		this.custStreetAddress = custStreetAddress;
	}

	public String getCustCity() {
		return custCity;
	}

	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}

	public int getCustCityId() {
		return custCityId;
	}

	public void setCustCityId(int custCityId) {
		this.custCityId = custCityId;
	}

	public String getCustStateProvince() {
		return custStateProvince;
	}

	public void setCustStateProvince(String custStateProvince) {
		this.custStateProvince = custStateProvince;
	}

	public int getCustStateProvinceId() {
		return custStateProvinceId;
	}

	public void setCustStateProvinceId(int custStateProvinceId) {
		this.custStateProvinceId = custStateProvinceId;
	}

	public String getCustMainPhoneInt() {
		return custMainPhoneInt;
	}

	public void setCustMainPhoneInt(String custMainPhoneInt) {
		this.custMainPhoneInt = custMainPhoneInt;
	}

	public String getCustIncomeLevel() {
		return custIncomeLevel;
	}

	public void setCustIncomeLevel(String custIncomeLevel) {
		this.custIncomeLevel = custIncomeLevel;
	}

	public String getCustCreditLimit() {
		return custCreditLimit;
	}

	public void setCustCreditLimit(String custCreditLimit) {
		this.custCreditLimit = custCreditLimit;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
}
