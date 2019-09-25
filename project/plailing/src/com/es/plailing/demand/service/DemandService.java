package com.es.plailing.demand.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.es.plailing.entity.Demand;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
/**
 * 
    * @ClassName: DemandService
    * @Description: TODO(�ӿ�)
    * @author ��ɺɺ
    * @date 2018��12��21��
    *
 */
@Service
public interface DemandService {

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
	public Demand getDemand(String text); 
	/**
	 * 
	    * @Title: addDeamand
	    * @Description: TODO(���һ������)
	    * @param @param text
	    * @param @throws Exception    ����
	    * @return void    ��������
	    * @throws
	 */
	public boolean addDeamand(String text,Demand demand);
	/**
	 * 
	    * @Title: listDemand
	    * @Description: TODO(״̬Ϊ�㣬�������������У�������������)
	    * @param @return
	    * @param @throws Exception    ����
	    * @return List<Demand>    ��������
	    * @throws
	 */
	public Page<Demand> listDemand(int pageNum,int pageSize);
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
	public boolean addUserDemand(User u,String text,Demand demand);
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
	public List<Object[]> listDemand(int pageNum,int pageSize,String text);
}
