package xyz.pigschool.secondMarket.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import xyz.pigschool.common.pojo.TreeNode;
import xyz.pigschool.common.utils.XYZResult;
import xyz.pigschool.content.service.ContentCatService;
import xyz.pigschool.content.service.ContentService;
import xyz.pigschool.pojo.XyzContent;

@Controller
public class ContentController {
	
	
	@Autowired
	private ContentCatService contentCatService;
	
	@Autowired
	private ContentService contentService;
	
	/**
	 * 	存到request的域中  存不为空的所有list
	 * @param request
	 */
	public void getAlllist(HttpServletRequest request,long cid) {
		List<TreeNode> list= (List<TreeNode>) contentCatService.getItemCatlist(cid).getData();
		for (TreeNode treeNode : list) {
			if(treeNode.getTags()[0].equals("父节点")) {
				getAlllist(request,treeNode.getId());
			}else if(treeNode.getTags()[0].equals("子节点")){
				XYZResult result = contentService.getContentListByCid(treeNode.getId());
				//如果存在内容
				if(result.getStatus() == 200) {
					List<XyzContent> listContent = (List<XyzContent>) result.getData();
					request.setAttribute("list"+treeNode.getId(), listContent);
				}
			}
		}
	}
	
	
}
