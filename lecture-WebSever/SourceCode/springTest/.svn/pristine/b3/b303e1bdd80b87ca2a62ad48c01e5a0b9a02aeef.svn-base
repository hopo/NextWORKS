package kr.or.nextit.main.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.nextit.main.service.HomeService;

@Service("HomeService")
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	private HomeMapper homeMapper;
	
	@Override
	public List<HashMap<String, Object>> selectItems(HashMap<String, Object> params) throws Exception {
		return homeMapper.selectItems(params);
	}

}
