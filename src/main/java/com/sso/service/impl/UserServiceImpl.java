package com.sso.service.impl;

import com.sso.dao.BaseDao;
import com.sso.model.UserModel;
import com.sso.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**接口*/
@Service()
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private BaseDao<UserModel> baseDao;

	/**根据ID获取实体*/
	public UserModel getById(String id){
		return baseDao.get(UserModel.class,id);
	}
	/**获取List信息*/
	public List<UserModel> getList(UserModel UserModel){
		return baseDao.find(" from UserModel  ");
	}
	/**根据条件查询获取实体(分页)*/
	public List<UserModel> getByPage(UserModel UserModel, Integer page, Integer rows){
		Object[] param = null;
		return  baseDao.find(" from UserModel " , param , page , rows );
	}
	/**根据查询条件获取全部信息的条数
	 * select count(*) from Txl
	 * */
	public Integer getTotalNum(UserModel UserModel){
		long i = baseDao.count(" from UserModel ",new Object[]{});
		return (int)i ;
	}
	/**根据查询条件获取全部信息的页数*/
	public Integer getTotalPage(UserModel UserModel,Integer num, Integer rows){
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
	public Integer save(UserModel model){
		try{
			baseDao.save(model);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	/**修改实体1成功2异常*/
	public Integer update(UserModel model){
		try{
			baseDao.update(model);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	/**保存或者修改实体1成功2异常*/
	public Integer saveOrUpdate(UserModel model){
		try{
			baseDao.saveOrUpdate(model);
			return 1;
		}catch (Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	/**登录*/
	public UserModel login(UserModel model, HttpServletRequest request){
		String userName = model.getUserName();
		String password = model.getPassword();
		UserModel userModel = baseDao.get(" from UserModel where userName=? and password=?",new Object[]{userName,password});
		request.getSession().setAttribute("user",userModel);
		return  userModel;
	}
}
