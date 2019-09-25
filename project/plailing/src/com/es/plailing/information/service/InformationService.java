package com.es.plailing.information.service;



import org.springframework.stereotype.Service;
import com.es.plailing.entity.Course;
import com.es.plailing.entity.Page;
import com.es.plailing.entity.User;
/**
 * 
    * @ClassName: InformationService
    * @Description: TODO(informationҳ��service�ӿ���)
    * @author ������
    * @date 2018��12��8��
    *
 */
@Service
public interface InformationService{
	public User getTheUser(int userId);
	public User getTheUserByEmail(String email);
	public Page<Course> listPersonCourses(int pageNum, int pageSize,User user);
	public boolean checkFollow(User user1,User user2);
	public void addFollow(User user1,User user2);
	public void deleteFollow(User user1,User user2);
}
