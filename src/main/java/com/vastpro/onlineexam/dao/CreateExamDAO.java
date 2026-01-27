package com.vastpro.onlineexam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import com.vastpro.onlineexam.db.DBConnection;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Class Name: CreateExamDAO
 *
 * Description:
 * This DAO class is responsible for inserting new exams into the database.
 *
 * It takes exam details from the request object and inserts them into
 * the 'exam' table. It also sets the generated exam ID in the request
 * attributes for further processing.
 */
public class CreateExamDAO {
	
    /**
     * Creates a new exam in the database.
     *
     * @param request the HttpServletRequest object containing exam details
     *                (exam_topic, exam_name, description, pass_min_correct,
     *                 total_marks, duration_minutes, add_question)
     *                and session attribute user_id for creator.
     * @return true if the exam is inserted successfully, false otherwise
     */
	public static boolean createExam(HttpServletRequest request) {
		String examTopic = request.getParameter("exam_topic");
		String examName = request.getParameter("exam_name");
		String description = request.getParameter("description");
		
		int pass_min_correct = Integer.parseInt(request.getParameter("pass_min_correct"));
		double total_marks = Double.parseDouble(request.getParameter("total_marks"));
		int duration_minutes =Integer.parseInt(request.getParameter("duration_minutes"));
//		int created_by = Integer.parseInt(request.getParameter("user_id"));
		int created_by = (Integer)request.getSession().getAttribute("user_id");
		Integer noOfQuestion=Integer.parseInt( request.getParameter("add_question"));
		request.getSession().setAttribute("questions", noOfQuestion);
		
		String sql = "insert into exam"
						+ " (exam_topic,exam_name,description,status,pass_min_correct,total_marks,duration_minutes,created_by,created_at)"
						+ "values(?,?,?,?,?,?,?,?,?)"
						+ " RETURNING exam_id";
		try (Connection conn = DBConnection.getConnection();
						PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, examTopic);
			pstmt.setString(2, examName);
			pstmt.setString(3, description);
			pstmt.setString(4, "ACTIVE");
			pstmt.setInt(5, pass_min_correct);
			pstmt.setDouble(6, total_marks);
			pstmt.setInt(7, duration_minutes);
			pstmt.setInt(8, created_by);
			pstmt.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
			 ResultSet rs = pstmt.executeQuery();
	            rs.next();
	            int examId= rs.getInt(1);
	            
	            request.setAttribute("examId", examId);
				System.out.println("Exam Rows Updated: Exam Id "+examId);
				System.out.println("createExamDao: created_by "+created_by);
				
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
