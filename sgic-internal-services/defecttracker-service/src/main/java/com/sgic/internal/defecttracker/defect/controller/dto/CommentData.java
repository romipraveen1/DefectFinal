package com.sgic.internal.defecttracker.defect.controller.dto;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Temporal;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

public class CommentData {
	
	private Long commentId;
	private String comments;
    private String commentedDate;
   private String defectId;
   
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
public String getCommentedDate() {
	return commentedDate;
}
public void setCommentedDate(String commentedDate) {
	this.commentedDate = commentedDate;
}
public String getDefectId() {
	return defectId;
}
public void setDefectId(String defectId) {
	this.defectId = defectId;
}
   
   

}
