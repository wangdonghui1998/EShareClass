package com.es.plailing.relatedemandnotification.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Demand;
import com.es.plailing.entity.Page;
import com.es.plailing.util.BaseDao;

/**
 * 
    * @ClassName: DemandDaoImpl
    * @Description: TODO(�������ݿ�)
    * @author ������
    * @date 2018��12��18��
    *
 */
@Repository
public class RelateDemandDaoImpl extends BaseDao<Demand, Integer>{
	
	public List<Demand> findDemand(int userId) throws Exception{
		String hql="from Demand d where d.demandId in (select ud.demand.demandId from UserDemand ud where ud.user.userId=?)";
		Object[] params= {userId};
		return find(hql, params);
	}
	
	/**
	 * 
	    * @Title: pageDemand
	    * @Description: TODO(����ID��ҳ��ѯ����)
	    * @param @param pageNum
	    * @param @param pageSize
	    * @param @param userId
	    * @param @return
	    * @param @throws Exception    ����
	    * @return Page<Demand>    ��������
	    * @throws
	 */
	public Page<Demand> pageDemand(int pageNum,int pageSize,int userId) throws Exception{
		String hqlCount="select count(*) from Demand d where d.demandId in (select ud.demand.demandId from UserDemand ud where ud.user.userId=?)";
		String hqlList="from Demand d where d.demandId in (select ud.demand.demandId from UserDemand ud where ud.user.userId=?)"; 
		Object[] params= {userId};
		return findPage(pageNum, pageSize, hqlCount, hqlList, params);
	}

	
}
