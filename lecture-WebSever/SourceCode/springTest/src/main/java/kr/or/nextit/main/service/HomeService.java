package kr.or.nextit.main.service;

import java.util.HashMap;
import java.util.List;

public interface HomeService {
	
	public List<HashMap<String, Object>> selectItems(HashMap<String, Object> params) throws Exception;

}
