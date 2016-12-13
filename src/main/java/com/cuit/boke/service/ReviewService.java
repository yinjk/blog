package com.cuit.boke.service;

import java.util.List;

import com.cuit.boke.entity.Review;

public interface ReviewService {
	
	
	/**
	 * 删除评论
	 * @param id 评论id
	 */
	public void deleteReview(int id);
	
	/**
	 * 展示文章评论
	 * @param articleId 文章id
	 * @return 所有评论
	 */
	public List<Review> showReview(int articleId);

}