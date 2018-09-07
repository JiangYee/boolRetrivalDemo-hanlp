package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BooleanModel.Document;

public class RemovePunController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/text;charset=utf-8");
		String fileName = req.getParameter("fileName");
		boolean isChinese = true;
		Document document = new Document();
		//document.FetchDocuments("data_train", isChinese);//处理文件//
		//document.fetchDocuments("D:\\eclipse-workspace\\BooleanRetrival\\dataset", isChinese);
//		String initDir = this.getServletContext().getRealPath("/lib");
		String dataDir = this.getServletContext().getRealPath("/dataset");
		document.fetchDocuments(dataDir, isChinese);
		String noPunSegments = document.getNoPunSegments().get(fileName);
		System.out.println("noPunSegments=="+noPunSegments);
		resp.getWriter().println(noPunSegments);
/*		String noPunSegments = "许 月 现在 在 上海 的 流利 说 上班  她 来自 昆明  \r\n" +	"也 毕业 于 西南 大学  是 其他 三 位 的 室友";
		resp.getWriter().println(noPunSegments);*/
	}
}
