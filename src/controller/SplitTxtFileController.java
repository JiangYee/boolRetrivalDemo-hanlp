package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;

import BooleanModel.Document;

public class SplitTxtFileController extends HttpServlet {
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
		StringBuffer splitResult = new StringBuffer();
		List<Term> termList =HanLP.segment(contents.toString());
		  for (int i = 0; i < termList.size(); i++) {
				String term = termList.get(i).toString();
				splitResult.append(term+" ");}
		System.out.println("splitResult=="+splitResult);
		resp.getWriter().println(splitResult);
	}
}
