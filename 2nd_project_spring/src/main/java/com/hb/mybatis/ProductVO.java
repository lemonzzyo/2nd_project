package com.hb.mybatis;

public class ProductVO {
	private String pid, pname, content, img, subimg, regdate, event, category, psize,cnt;
	private int price, saleprice, salecnt;
	private String[] sizearr, cntarr;
	
	

	public void setSizearr() {
		this.sizearr=psize.split(", ");
	}
	
	public String[] getSizearr() {
		return sizearr;
	}
	
	public void setCntArr() {
		this.sizearr=cnt.split(", ");
	}
	
	public String[] getCntarr() {
		return cntarr;
	}
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getSubimg() {
		return subimg;
	}
	public void setSubimg(String subimg) {
		this.subimg = subimg;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPsize() {
		return psize;
	}
	public void setPsize(String psize) {
		this.psize = psize;
		setSizearr();
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
		setCntArr();
	}
	public int getSalecnt() {
		return salecnt;
	}
	public void setSalecnt(int salecnt) {
		this.salecnt = salecnt;
	}
	
	
}
