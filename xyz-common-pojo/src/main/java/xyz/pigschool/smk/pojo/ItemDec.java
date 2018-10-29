package xyz.pigschool.smk.pojo;

import java.io.Serializable;

import xyz.pigschool.pojo.XyzItem;

/**
 * 商品详情信息
 * @author lyf
 */
public class ItemDec extends XyzItem implements Serializable{

	private String cname;
	
	
	public ItemDec() {}
	
	public ItemDec(XyzItem item) {
		this.setId(item.getId());
		this.setTitle(item.getTitle());
		this.setPrice(item.getPrice());
		this.setSellPoint(item.getSellPoint());
		this.setNum(item.getNum());
		this.setImage(item.getImage());
		this.setCid(item.getCid());
		this.setState(item.getState());
		this.setCreated(item.getCreated());
		this.setUpdated(item.getUpdated());
		this.setIsBargain(item.getIsBargain());
		this.setAssay(item.getAssay());
		this.setLocation(item.getLocation());
		this.setContactInfo(item.getContactInfo());
		this.setDealway(item.getDealway());
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
	public String[] getImages() {
		String image2 = this.getImage();
		if (image2 != null && !"".equals(image2)) {
			String[] strings = image2.split(",");
			return strings;
		}
		return null;
	}
	
}
