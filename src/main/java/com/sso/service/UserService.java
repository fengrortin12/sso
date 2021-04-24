package com.sso.service;

import com.sso.model.UserModel;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**接口*/
public interface UserService {
	/**根据ID获取实体*/
	public UserModel getById(String id);
	/**获取List信息*/
	public List<UserModel> getList(UserModel UserModel);
	/**根据条件查询获取实体(分页)*/
	public List<UserModel> getByPage(UserModel UserModel, Integer page, Integer rows);
	/**根据查询条件获取全部信息的条数
	 * select count(*) from Txl
	 * */
	public Integer getTotalNum(UserModel UserModel);
	/**根据查询条件获取全部信息的页数*/
	public Integer getTotalPage(UserModel UserModel, Integer num, Integer rows);
	/**根据ID删除实体1成功2异常*/
	public Integer delByID(String id);
	/**保存实体1成功2异常*/
	public Integer save(UserModel model);
	/**修改实体1成功2异常*/
	public Integer update(UserModel model);
	/**保存或者修改实体1成功2异常*/
	public Integer saveOrUpdate(UserModel model);

	/**登录*/
	public UserModel login(UserModel model, HttpServletRequest request);
}
