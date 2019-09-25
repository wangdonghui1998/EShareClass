package com.es.plailing.check.dao;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Demand;
import com.es.plailing.util.BaseDao;

/**
    * @ClassName: CheckDemandDaoImpl
    * @Description: TODO(check.jspҳ�����UserDemand��һЩ����)
    * @author ����ϼ
    * @date 2018��12��19��
    *
    */
@Repository
public class CheckDemandDaoImpl extends BaseDao<Demand,Integer>{
	
	/**
	 * 
	    * @Title: findDemand
	    * @Description: TODO(ͨ��demandId�ҵ�UserDemand����)
	    * @param @param demandId
	    * @param @return
	    * @param @throws Exception    ����
	    * @return UserDemand    ��������
	    * @throws
	 */
	public Demand findDemand(int demandId) throws Exception {
		String hql = "from Demand d where d.demandId=?";
		Object[] params = {demandId};
		return findOne(hql, params);
	}
}
