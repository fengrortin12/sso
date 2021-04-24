package com.sso.service.impl;

import com.sso.dao.BaseDao;
import com.sso.model.SsoModel;
import com.sso.model.UserModel;
import com.sso.service.SsoModelService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**接口*/
@Service()
@Transactional
public class SsoModelServiceImpl implements SsoModelService {

	@Autowired
	private BaseDao<SsoModel> baseDao;

	/**根据ID获取实体*/
	public SsoModel getById(String id){
		return baseDao.get(SsoModel.class,id);
	}
	/**获取List信息*/
	public List<SsoModel> getList(SsoModel ssoModel){
		return baseDao.find(" from SsoModel where parent is null ");
	}
	/**根据条件查询获取实体(分页)*/
	public List<SsoModel> getByPage(SsoModel ssoModel, Integer page, Integer rows){
		Object[] param = null;
		return  baseDao.find(" from SsoModel " , param , page , rows );
	}
	/**根据查询条件获取全部信息的条数
	 * select count(*) from Txl
	 * */
	public Integer getTotalNum(SsoModel ssoModel){
		long i = baseDao.count(" from SsoModel ",new Object[]{});
		return (int)i ;
	}
	/**根据查询条件获取全部信息的页数*/
	public Integer getTotalPage(SsoModel ssoModel,Integer num, Integer rows){
		return null;
	}
	/**根据ID删除实体1成功2异常*/
	public Integer delByID(String id){
		try{
			baseDao.delete(getById(id));
			return 1;
		}catch (Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	/**保存实体1成功2异常*/
	public Integer save(SsoModel model){
		try{
			//webService保存的时候实体里面不能存在实体
			String ParentId = model.getParentId();
			if(StringUtils.isNotBlank(ParentId)){
				SsoModel parent = getById(ParentId);
				model.setParent(parent);
			}

			baseDao.save(model);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	/**修改实体1成功2异常*/
	public Integer update(SsoModel model){
		try{
			baseDao.update(model);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	/**保存或者修改实体1成功2异常*/
	public Integer saveOrUpdate(SsoModel model){
		try{
			baseDao.saveOrUpdate(model);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
			return 0;
		}
	}


}
