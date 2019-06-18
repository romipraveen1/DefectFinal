package com.sgic.internal.defecttracker.defect.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.logging.log4j.Logger;
//import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.common.api.enums.RestApiResponseStatus;
import com.sgic.common.api.response.ApiResponse;
import com.sgic.internal.defecttracker.defect.controller.dto.CommentData;
import com.sgic.internal.defecttracker.defect.entities.Comments;
import com.sgic.internal.defecttracker.defect.entities.Defect;
import com.sgic.internal.defecttracker.defect.services.CommentService;
import com.sgic.internal.defecttracker.defect.services.DefectService;
import com.sgic.internal.defecttracker.defect.services.impl.CommentServiceImp;

@RestController
public class CommentController {
	
	private static final Logger LOG = LoggerFactory.getLogger(CommentServiceImp.class);
	
	
	
	@Autowired
	private CommentService commentService;
	
	
	
	@Autowired
	private DefectService defectService;

	  @PostMapping(value = "/comment")
	  public ResponseEntity<Object> createComments(@RequestBody CommentData commentData) {
		
		  LOG.info("starting creating comments"  );
		  
	    Comments comments =new Comments();
	    comments.setCommentId(commentData.getCommentId());
	    comments.setCommentedDate(commentData.getCommentedDate());
	    comments.setComments(commentData.getComments());
	    
	    Defect defect=defectService.getDefectById(commentData.getDefectId());
	    comments.setDefect(defect);
	    
	    commentService.createComments(comments);
	    LOG.info(" comments saved"  );
	    return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.OK), HttpStatus.OK);
	   
	  }
	  
	  @SuppressWarnings("null")
	@GetMapping(value = "/comments/{defectId}")
	  public ArrayList<String> getListComments(@PathVariable String defectId) {
		
		  LOG.info("starting creating comments"  );
	    LOG.info(" comments saved" );
	    List<Comments> comments=commentService.getCommentsById(defectId);
	    ArrayList<String> list=new ArrayList<String>();
	    Comments comment =new Comments();
	    list.addAll((Collection<? extends String>) comments.remove(3));
	  
//	    Defect defect = null;
//	    defect.setDefectId("1");
//	    defect.setComments("");
	    return list;
	   
	  }

}
