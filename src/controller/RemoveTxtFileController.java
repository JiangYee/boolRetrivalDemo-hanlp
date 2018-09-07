package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;


public class RemoveTxtFileController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/text;charset=utf-8");
		String contents = req.getParameter("fileContents");
		System.out.println(contents);
		StringBuffer removeResult = new StringBuffer();
		List<Term> termList =HanLP.segment(contents.toString());
		  for (int i = 0; i < termList.size(); i++) {
				String term0 = termList.get(i).toString();
				String term = term0.replaceAll("\\pP.*", " ");
				removeResult.append(term);}
		System.out.println("removeResult=="+removeResult);
		resp.getWriter().println(removeResult);
	}
}
