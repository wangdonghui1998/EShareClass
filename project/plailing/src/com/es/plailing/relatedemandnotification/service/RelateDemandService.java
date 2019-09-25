package com.es.plailing.relatedemandnotification.service;

import java.util.List;

import com.es.plailing.entity.Demand;
import com.es.plailing.entity.Page;

/**
 * 
    * @ClassName: DemandService
    * @Description: TODO(�ӿ�)
    * @author ������
    * @date 2018��12��18��
    *
 */
public interface RelateDemandService {
	
	/**
	 * 
	    * @Title: findDemand
	    * @Description: TODO(����id��ѯ����)
	    * @param @param userId
	    * @param @return    ����
	    * @return List<Demand>    ��������
	    * @throws
	 */
	public List<Demand> findDemand(int userId);
	
	/**
	 * 
	    * @Title: pageDemand
	    * @Description: TODO(����Id��ҳ��ѯ����)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param userId
	    * @param @return    ����
	    * @return Page<Demand>    ��������
	    * @throws
	 */
	public Page<Demand> pageDemand(int pageNum,int pageSize,int userId);
	
}
