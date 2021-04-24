package com.sso.service;

import java.util.List;

import com.sso.model.SsoModel;

/**接口*/
public interface SsoModelService {
	/**根据ID获取实体*/
	public SsoModel getById(String id);
	/**获取List信息*/
	public List<SsoModel> getList(SsoModel ssoModel);
	/**根据条件查询获取实体(分页)*/
	public List<SsoModel> getByPage(SsoModel ssoModel,Integer page,Integer rows);
	/**根据查询条件获取全部信息的条数
	 * select count(*) from Txl
	 * */
	public Integer getTotalNum(SsoModel ssoModel);
	/**根据查询条件获取全部信息的页数*/
	public Integer getTotalPage(SsoModel ssoModel,Integer num,Integer rows);
	/**根据ID删除实体1成功2异常*/
	public Integer delByID(String id);
	/**保存实体1成功2异常*/
	public Integer save(SsoModel model);
	/**修改实体1成功2异常*/
	public Integer update(SsoModel model);
	/**保存或者修改实体1成功2异常*/
	public Integer saveOrUpdate(SsoModel model);
}
