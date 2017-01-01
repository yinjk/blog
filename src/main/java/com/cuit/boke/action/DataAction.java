package com.cuit.boke.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cuit.boke.service.ArticleService;
import com.cuit.boke.service.ReviewService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("dataAction")
@ParentPackage("json-default")
@Scope(value="prototype")
@Namespace("/data")
public class DataAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private com.cuit.boke.dto.Result<Integer> result;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private ReviewService reviewService;
	
	//总文章数
	@Action(value="articleCount", results={
			@Result(type="json", params={"root","result"})
			})
	public String getArticleCount(){
		try {
			int count = articleService.allArticleViewCount();
			result = new com.cuit.boke.dto.Result<Integer>("ok", count, null);
		} catch (Exception e) {
			result = new com.cuit.boke.dto.Result<Integer>("error", -1, e.getMessage());
		}
		return SUCCESS;
	}
	//总浏览量
	@Action(value="allViews", results={
			@Result(type="json", params={"root","result"})
			})
	public String allArticleViews(){
		try {
			int count = articleService.articleCount();
			result = new com.cuit.boke.dto.Result<Integer>("ok", count, null);
		} catch (Exception e) {
			result = new com.cuit.boke.dto.Result<Integer>("error", -1, e.getMessage());
		}
		return SUCCESS;
	}
	
	//总评论数
	@Action(value="allReviews", results={
			@Result(type="json", params={"root","result"})
			})
	public String allReviews(){
		try {
			int count = reviewService.reviewsCount();
			result = new com.cuit.boke.dto.Result<Integer>("ok", count, null);
		} catch (Exception e) {
			result = new com.cuit.boke.dto.Result<Integer>("error", -1, e.getMessage());
		}
		return SUCCESS;
	}


	public com.cuit.boke.dto.Result<Integer> getResult() {
		return result;
	}


	public void setResult(com.cuit.boke.dto.Result<Integer> result) {
		this.result = result;
	}
}
