package xyz.pigschool.manager.pojo;

import java.io.Serializable;
import java.util.Date;

public class ManagerContentVO implements Serializable{
	private int id;
	private String title;
	private String content;
	private String author;
	private Date pulish;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPulish() {
		return pulish;
	}
	public void setPulish(Date pulish) {
		this.pulish = pulish;
	}
}
