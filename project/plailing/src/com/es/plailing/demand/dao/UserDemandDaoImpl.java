package com.es.plailing.demand.dao;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.es.plailing.entity.Demand;
import com.es.plailing.entity.User;
import com.es.plailing.entity.UserDemand;
import com.es.plailing.util.BaseDao;

/**
 * 
    * @ClassName: DemandDaoImpl
    * @Description: TODO(demandҳ��ײ��ѯ)
    * @author ��ɺɺ
    * @date 2018��12��21��
    *
 */

@Repository
public class UserDemandDaoImpl extends BaseDao<UserDemand,Integer>{
	/**
	 * 
	    * @Title: addUserDemand
	    * @Description: TODO(�����ݲ��뵽userDemand��)
	    * @param @param u
	    * @param @param text
	    * @param @throws Exception    ����
	    * @return void    ��������
	    * @throws
	 */
	public void addUserDemand(User u,String text,Demand demand) throws Exception {
		UserDemand userDemand=new UserDemand();
		userDemand.setDemandTime(new Date());
		userDemand.setUser(u);
		userDemand.setDemand(demand);
		u.getDemands().add(userDemand);
		demand.getUsers().add(userDemand);
		save(userDemand);
	}
}
