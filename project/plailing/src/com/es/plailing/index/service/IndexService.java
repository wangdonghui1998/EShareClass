package com.es.plailing.index.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.es.plailing.entity.Course;
import com.es.plailing.entity.CourseCatalog;
import com.es.plailing.entity.User;
/**
 * 
    * @ClassName: IndexService
    * @Description: TODO(indexҳ��service�ӿ���)
    * @author ������
    * @date 2018��12��8��
    *
 */
@Service
public interface IndexService {
	public List<Course> listCoursesByGrades();
	public List<Course> listHotCourses();

}
