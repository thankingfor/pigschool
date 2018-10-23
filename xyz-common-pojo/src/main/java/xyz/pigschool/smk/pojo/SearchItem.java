package xyz.pigschool.smk.pojo;

import java.io.Serializable;

/**
 * 二手市场的所搜pojo
 * @author 李延富
 *
 */
public class SearchItem implements Serializable{
	/**
	 * <field name="smk_id" type="text_ik" indexed="true" stored="true"/>
	 * 这个可能不用，用solr自带的id
	 */
	private String id;
	/**
	 * <field name="smk_title" type="text_ik" indexed="true" stored="true"/>
	 */
	private String title;
	/**
	 * <field name="smk_sell_point" type="text_ik" indexed="true" stored="true"/>
	 */
	private String sellPoint;
	/**
	 * <field name="smk_price" type="long" indexed="true" stored="true"/>
	 */
	private long price;
	/**
	 * <field name="smk_image" type="string" indexed="false" stored="true"/>
	 */
	private String image;
	/**
	 * <field name="smk_num" type="long" indexed="false" stored="true"/>
	 */
	private long num;
	/**
	 * <field name="smk_cname" type="string" indexed="true" stored="true"/>
	 */
	private String cname;
	/**
	 * <field name="smk_location" type="text_ik" indexed="true" stored="true"/>
	 */
	private String location;
	/**
	 * <field name="smk_contact_info" type="text_ik" indexed="true" stored="true"/>
	 */
	private String contactInfo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSellPoint() {
		return sellPoint;
	}
	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
}
