package com.es.plailing.comment.dao;
import org.springframework.stereotype.Repository;
import com.es.plailing.entity.CourseCatalog;
import com.es.plailing.util.BaseDao;
/**
 * 
    * @ClassName: VideoDetailDaoImpl
    * @Description: TODO(videodetail����Ŀ¼�Ĳ�ѯ)
    * @author ������
    * @date 2018��12��18��
    *
 */
@Repository
public class VideoDetailDaoImpl extends BaseDao<CourseCatalog,Integer>{
	public CourseCatalog getSingleCourse(int catalogId) throws Exception{
		return this.get(catalogId);
	}
}
