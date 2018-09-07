package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BooleanModel.BoolRetrivalModel;
import BooleanModel.Document;
import net.sf.json.JSONArray;

public class IndexController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/text;charset=utf-8");
		BoolRetrivalModel br = new BoolRetrivalModel();
		Document document = new Document();
		boolean isChinese = true;
		//String docDir = "D:\\eclipse-workspace\\BooleanRetrival\\dataset";
		//document.fetchDocuments(docDir, isChinese);//处理文件//
//		String initDir = this.getServletContext().getRealPath("/lib");
		String dataDir = this.getServletContext().getRealPath("/dataset");
		document.fetchDocuments(dataDir, isChinese);//处理文件//
		TreeMap<Integer, ArrayList<String>>documents =document.getDocuments();
		br.buildDocID_TFmap(documents);//建立词频mapS
		br.buildInvertedIndex(documents);//建立倒排索引
		//br.writeIndex();//倒排索引写入文件
		TreeMap<String, TreeMap<Integer,Integer>> invertedIndex= br.getInvertedIndex();
		TreeMap<String, String> indexOut = new TreeMap<String,String>();
		Iterator<String> it = invertedIndex.keySet().iterator();
		String term = null;
		TreeMap<Integer,Integer> posting = null;
		while(it.hasNext()) {
			term = it.next();
			posting = invertedIndex.get(term);
			StringBuffer out = new StringBuffer();
			for (Integer docID : posting.keySet()) { 
				int frequency = posting.get(docID);
				out.append(docID+"("+frequency+") ");
				} 
				indexOut.put(term, out.toString());
		}
		
		Iterator<String> its = indexOut.keySet().iterator();
		while(its.hasNext()) {
			String term1 = its.next();
			System.out.println(term1+indexOut.get(term1));
		}
		JSONArray jsonArray =JSONArray.fromObject(indexOut);
		System.out.println(jsonArray);
		resp.getWriter().println(jsonArray);
		
		
	}
}
