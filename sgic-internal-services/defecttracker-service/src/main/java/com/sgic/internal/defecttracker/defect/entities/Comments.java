package com.sgic.internal.defecttracker.defect.entities;


	
	import java.io.Serializable;
	import java.util.Date;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
	import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

	
	@Entity
	@Table( name = "comments")
	public class Comments implements Serializable {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long commentId;
		private String comments;
		
		@Generated(GenerationTime.ALWAYS)
		@Temporal(javax.persistence.TemporalType.DATE)
		private Date commentedDate = new java.sql.Date(new java.util.Date().getTime());
	
		@ManyToOne
		@JoinColumn(name="defectId", nullable=false)
		private Defect defect;
		
		
		public Defect getDefect() {
			return defect;
		}
		public void setDefect(Defect defect) {
			this.defect = defect;
		}
		public Long getCommentId() {
			return commentId;
		}
		public void setCommentId(Long commentId) {
			this.commentId = commentId;
		}
		public String getComments() {
			return comments;
		}
		public void setComments(String comments) {
			this.comments = comments;
		}
		public Date getCommentedDate() {
			return commentedDate;
		}
		public void setCommentedDate(Date commentedDate) {
			this.commentedDate = commentedDate;
		}
		
		

	}


