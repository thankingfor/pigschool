package xyz.pigschool.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import xyz.pigschool.common.utils.XYZResult;
import xyz.pigschool.manager.pojo.ManagerContentVO;
import xyz.pigschool.manager.pojo.XyzManagerContent;
import xyz.pigschool.mapper.XyzManagerContentMapper;
import xyz.pigschool.service.ManagerContentService;
import xyz.pigschool.service.mapper.ManagerContentMapper;

@Service
public class ManagerContentServiceImpl implements ManagerContentService{

	private Logger log = LoggerFactory.getLogger(ManagerContentServiceImpl.class);
	
	@Autowired
	private XyzManagerContentMapper contentMapper;
	
	@Autowired
	private ManagerContentMapper managerContentMapper;
	/**
	 * 	添加content
	 * @param content
	 * @return
	 */
	public XYZResult insert(XyzManagerContent content) {
		//如果有置顶操作
		if(content.getIsTop() > 0 ) {
			content.setIsTop(getIstop());
		}
		contentMapper.insertSelective(content);
		return null;
	}

	/**
	 * 分页获取数据
	 * @param page 页数
	 * @param rows 行数
	 * @param param 查询条件
	 * @return
	 */
	public XYZResult getList(int page, int rows, String param) {
		PageHelper.startPage(page, rows);
		/*XyzManagerContentExample example = new XyzManagerContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andTitleLike("%"+param+"%");
		List<XyzManagerContent> list = contentMapper.selectByExample(example);*/
		List<ManagerContentVO> list = managerContentMapper.selectByParam("%"+param+"%");
		PageInfo<ManagerContentVO> pageInfo = new PageInfo<ManagerContentVO> (list,5);
		for (int num : pageInfo.getNavigatepageNums()) {
			log.debug("-------num="+num);
		}
		return XYZResult.ok(pageInfo);
	}

	/**
	 * 	置顶
	 * @param id 内容id
	 * @return
	 */
	@Transactional
	public XYZResult upTop(int id) {
		int max = getIstop();
		log.debug("max="+max+",id="+id);
		int rs = managerContentMapper.updateTopById(id, max+1);
		log.debug("max="+max+",rs="+rs);
		if(rs > 0) {
			return XYZResult.ok();
		}
		return XYZResult.build(201, "修改失败");
	}

	/**
	 * 	取消置顶
	 * @param id 内容id
	 * @return
	 */
	@Transactional
	public XYZResult outTop(int id) {
		if(managerContentMapper.updateTopById(id, 0) > 0) {
			return XYZResult.ok();
		}
		return XYZResult.build(201, "修改失败");
	}
	
	/**
	 * 	返回置顶的最大值
	 * @return
	 */
	private int getIstop() {
		int count = managerContentMapper.getIstop();
		return count;
	}

	/**
	 * 通过id查询
	 * @param id
	 * @return
	 */
	public XYZResult getById(int id) {
		ManagerContentVO contentVO = managerContentMapper.getById(id);
		if(contentVO != null) {
			return XYZResult.ok(contentVO);
		}
		return null;
	}

}
