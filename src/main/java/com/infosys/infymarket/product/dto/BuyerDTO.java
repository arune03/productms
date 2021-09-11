package com.infosys.infymarket.product.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;

public class BuyerDTO {
	
	String buyerid;
	
	String name;
	
	String email;
	
	String phoneno;
	
	String password;
	Boolean isactive;
	Boolean isprivileged;
	Integer rewardpoints;

	public String getBuyerid() {
		return buyerid;
	}

	public void setBuyerid(String buyerid) {
		this.buyerid = buyerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}

	public Boolean getIsprivileged() {
		return isprivileged;
	}

	public void setIsprivileged(Boolean isprivileged) {
		this.isprivileged = isprivileged;
	}

	public Integer getRewardpoints() {
		return rewardpoints;
	}

	public void setRewardpoints(Integer rewardpoints) {
		this.rewardpoints = rewardpoints;
	}

	@Override
	public String toString() {
		return "BuyerDTO [buyerid=" + buyerid + ", name=" + name + ", email=" + email + ", phoneno=" + phoneno
				+ ", password=" + password + ", isactive=" + isactive + ", isprivileged=" + isprivileged
				+ ", rewardpoints=" + rewardpoints + "]";
	}

//	// Converts Entity into DTO
//	public static BuyerDTO valueOf(Buyer buyer) {
//		BuyerDTO buyerDTO = new BuyerDTO();
//		buyerDTO.setBuyerid(buyer.getBuyerid());
//		buyerDTO.setName(buyer.getName());
//		buyerDTO.setEmail(buyer.getEmail());
//		buyerDTO.setPhoneno(buyer.getPhoneno());
//		buyerDTO.setPassword(buyer.getPassword());
//		buyerDTO.setIsactive(buyer.getIsactive());
//		buyerDTO.setIsprivileged(buyer.getIsprivileged());
//		buyerDTO.setRewardpoints(buyer.getRewardpoints());
//		return buyerDTO;
//	}
//
//	public Buyer createBuyer() {
//		Buyer buyer = new Buyer();
//		buyer.setBuyerid(this.getBuyerid());
//		buyer.setName(this.getName());
//		buyer.setPhoneno(this.getPhoneno());
//		buyer.setEmail(this.getEmail());
//		buyer.setPassword(this.getPassword());
//		buyer.setIsprivileged(this.getIsprivileged());
//		buyer.setRewardpoints(this.getRewardpoints());
//		buyer.setIsactive(this.getIsactive());
//		return buyer;
//	}

}
