package com.cuit.boke.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "review")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Review {
	// 评论id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// 该评论对应的文章id
	@ManyToOne(targetEntity = Article.class)
	@JoinColumn(name = "article_id", nullable = false)
	private Integer articleId;

	// 该评论的内容
	@Column(nullable = false)
	private String content;

	// 该评论的作者名
	@Column(nullable = false)
	private String name;

	// 该评论作者的头像URL地址
	@Column(name = "portrait_url",nullable=false,columnDefinition="varchar(255) default '/picture/'")
	private String portraitURL;

	// 该评论生成时间
	@Column(name = "create_time", nullable = false)
	private Date cteateTime;

	// 该评论获得的赞的数目
	@Column(name = "praise_num",columnDefinition="int default 0",nullable=false)
	private int praiseNum;

	// 该评论获得的踩的数目
	@Column(name = "stamp_num",columnDefinition="int default 0",nullable=false)
	private int stampNum;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPortraitURL() {
		return portraitURL;
	}

	public void setPortraitURL(String portraitURL) {
		this.portraitURL = portraitURL;
	}

	public Date getCteateTime() {
		return cteateTime;
	}

	public void setCteateTime(Date cteateTime) {
		this.cteateTime = cteateTime;
	}

	public int getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(int praiseNum) {
		this.praiseNum = praiseNum;
	}

	public int getStampNum() {
		return stampNum;
	}

	public void setStampNum(int stampNum) {
		this.stampNum = stampNum;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", articleId=" + articleId + ", content=" + content + ", name=" + name
				+ ", portraitURL=" + portraitURL + ", cteateTime=" + cteateTime + ", praiseNum=" + praiseNum
				+ ", stampNum=" + stampNum + "]";
	}
	
}
