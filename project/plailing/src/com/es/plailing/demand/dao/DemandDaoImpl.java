package com.es.plailing.demand.dao;

import java.util.List;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.es.plailing.entity.Demand;
import com.es.plailing.entity.Page;
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
@Transactional(readOnly=false)
public class DemandDaoImpl extends BaseDao<Demand,Integer>{

	/**
	 * 
	    * @Title: getDemand
	    * @Description: TODO(������û�ж�Ӧ������)
	    * @param @param text
	    * @param @return
	    * @param @throws Exception    ����
	    * @return Demand    ��������
	    * @throws
	 */
	public Demand getDemand(String text) throws Exception {
		String hql="from Demand d where d.text=?";
		Object[] params= {text};
		return findOne(hql,params);
	}
	/**
	 * 
	    * @Title: addDeamand
	    * @Description: TODO(���һ������)
	    * @param @param text
	    * @param @throws Exception    ����
	    * @return void    ��������
	    * @throws
	 */
	public void addDeamand(String text,Demand demand) throws Exception {
		if(demand!=null) {
			int count=demand.getCount()+1;
			demand.setCount(count);
			int i=demand.getCourses().size()+1;
			demand.setProportion((double)i/count);
			update(demand);
		}else { 
			Demand demand1=new Demand();
			demand1.setCount(1);
			demand1.setProportion(1);
			demand1.setText(text);
			save(demand1);
		}
	}

	/**
	 * 
	    * @Title: listDemand
	    * @Description: TODO(�Ȱ��ձ����������򣬰������������У�������������)
	    * @param @return
	    * @param @throws Exception    ����
	    * @return List<Demand>    ��������
	    * @throws
	 */
	public Page<Demand> listDemand(int pageNum,int pageSize) throws Exception{
		String hqlCount="select count(*) from Demand d order by d.proportion,d.count desc,d.demandId desc";
		String hqlList="from Demand d  order by d.proportion,d.count desc,d.demandId desc";
		Object[] params= {};
		return findPage(pageNum,pageSize, hqlCount, hqlList, params);
	}
	/**
	 * 
	    * @Title: listDemand
	    * @Description: TODO(�ҵ��ﺬ��text������)
	    * @param @param text
	    * @param @return
	    * @param @throws Exception    ����
	    * @return List<Object[]>    ��������
	    * @throws
	 */
	public List<Object[]> listDemand(int pageNum,int pageSize,String text) throws Exception{
		String hql="select d.text from Demand d where d.text like ? order by d.proportion";
		Object[] params= {"%"+text+"%"};
		return findByProjection(pageNum, pageSize, hql, params);
	}

}
