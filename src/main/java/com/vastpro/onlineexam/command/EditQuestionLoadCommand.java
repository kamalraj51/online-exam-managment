package com.vastpro.onlineexam.command;

import java.util.List;

import com.vastpro.onlineexam.dao.StartExamDAO;
import com.vastpro.onlineexam.dto.ExamDTO;
import com.vastpro.onlineexam.dto.QuestionDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EditQuestionLoadCommand implements Command {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) {
	
		HttpSession session = request.getSession();

		List<QuestionDTO> editQuestionsData = (List<QuestionDTO>) session.getAttribute("editQuestionsData");
		if (editQuestionsData == null) {
			System.out.println("inside if");
			StartExamDAO dao = new StartExamDAO();
			System.out.println("StartExamDAO object created");
			int examId = Integer.parseInt(request.getParameter("examId"));

			session.setAttribute("examId", examId);
			System.out.println("StartExamDAO examId " + examId);
			editQuestionsData = dao.getQuestionsByExamId(request);
			System.out.println("editQuestionloadCommand editQuestionData" + editQuestionsData);
			ExamDTO editExamData = (ExamDTO) session.getAttribute("ExamObject");
			System.out.println("editQuestionloadCommand editExamData" + editExamData);
			session.setAttribute("editQuestionsData", editQuestionsData);
			System.out.println("end");
		}
		System.out.println("start");
		System.out.println("editQuestionloadCommand (question) " + editQuestionsData);
		System.out.println("q text" + editQuestionsData.get(0).getOptionText());
		System.out.println("end");
		return true;

	}
}