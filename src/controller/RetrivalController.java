package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BooleanModel.BoolRetrivalModel;
import BooleanModel.Document;
import net.sf.json.JSONArray;

public class RetrivalController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*System.out.println("进入IndexController!");
		//D:\eclipse-workspace\BooleanRetrival\data_train
		resp.setContentType("text/text;charset=utf-8");
		String docDir = req.getParameter("filePath");
		//int num = Integer.parseInt(req.getParameter("num"));
		String[] terms = req.getParameterValues("terms");
		String[] operators = req.getParameterValues("operators");
		System.out.println(docDir);
		for (int i = 0; i < terms.length; i++) {
			System.out.println(terms[i]);
		}
		if(operators==null) {System.out.println("operator是null");}
		else {
			for (int i = 0; i < operators.length; i++) {
			System.out.println(operators[i]);
		}
		}
		
		File f = new File(docDir);
		File[] docs = f.listFiles();
		for (File file : docs) {
			System.out.println(file.getName());
		}
		TreeMap<String, String> results = new TreeMap<String, String>();
		results.put("姜艺", "姜艺是西南大学的学生，是苏雪的室友，\r\n" + "也是朱明月的室友，她们都是好朋友。");
		results.put("苏雪", "苏雪是个爱吃鱼的小姑娘，长得很漂亮，是姜艺的好朋友。\r\n" + "现在在成都浪潮上班。");
		results.put("新闻1", "原标题：视界丨大选后“巴铁”要“变心”？听听巴基斯坦新当选总理怎么说\r\n" + 
				"当地时间7月26日，中国的“巴铁兄弟”——巴基斯坦大选结果初步揭晓，前板球明星出身的政客伊姆兰·汗宣布获胜，有望成为巴基斯坦的下一任总理。他许诺当选后要扫除腐败，建立一个“新巴基斯坦”。\r\n" + 
				"英国广播公司网站报道称，65岁的“政坛黑马”伊姆兰·汗承诺改变巴基斯坦政党政治的现状，其竞选打出反腐败旗号，迎合民众，并承诺建立癌症医院，为穷人治病。\r\n" + 
				"英国《每日电讯报》报道介绍了伊姆兰·汗非同寻常的政治生涯。这名外形英俊的前板球队长带领巴基斯坦板球队赢得1992年的世界杯。英媒报道说，现在，他决心同巴基斯坦的“恶势力”斗争。\r\n" + 
				"报道还指出，伊姆兰·汗本人也被指得到军方的强有力支持。\r\n" + 
				"1992年，伊姆兰·汗发表板球世界杯获胜感言。\r\n" + 
				"然而，巴基斯坦大选刚落幕，就有人开始担忧“巴铁兄弟”对中国是否会变心。\r\n" + 
				"个别美国媒体别有用心地刊发文章，对中巴关系指手画脚，甚至毫无根据地臆测“巴基斯坦大选会否影响‘中巴经济走廊’”……\r\n" + 
				"对此，香港《南华早报》引用巴基斯坦驻香港总领事卡迪尔·梅蒙的话说：“不论谁赢得大选，巴基斯坦政府都会坚定对华政策的一贯性。”\r\n" + 
				"他还称赞道，“中巴经济走廊”在巴基斯坦很受欢迎，因为它为人民群众建设了一系列急需的基础设施工程。\r\n" + 
				"《南华早报》报道截图\r\n" + 
				"而在巴基斯坦国内，伊姆兰·汗在宣布胜选后就中巴关系的首次公开表态，更是获得了大批巴基斯坦民众“点赞”。\r\n" + 
				"26日下午，伊姆兰·汗在胜选演讲中明确表示：“我们将加强与中国的关系，他们通过投资‘中巴经济走廊’为我们提供了机会。我们也希望效仿中国发展模式，学习如何改善人民生活，使他们脱离贫困。”\r\n" + 
				"参考视频注意到，观看了这场胜选演讲后，巴基斯坦民众纷纷到社交网络上留言。一位网友欣喜地写道：“谈及邻国时，伊姆兰·汗的演讲一开始就提了中国。他向世界传递了很明显的信息：中国永远是巴基斯坦的第一伙伴。”\r\n" + 
				"还有巴网友更是激动地打出了“中巴友好”的标签，希望巴基斯坦同中国一直交好，加强友谊。\r\n" + 
				"谈及此次巴基斯坦大选，中国外交部发言人耿爽在7月26日的例行记者会上表示：“中巴友好得到两国人民发自内心的拥护和支持，无论大选结果如何，都不会影响中巴关系发展。中方愿同巴基斯坦新政府一道努力，推动两国全天候战略合作伙伴关系取得更大发展。”\r\n" + 
				"中国外交部发言人耿爽\r\n" + 
				"在巴基斯坦媒体看来，中巴两国间的友好关系深厚而牢固。今年4月，巴基斯坦总理阿巴西就在演讲中表示，巴基斯坦和中国是“铁杆兄弟”，两国间的友谊是“我们所处地区”战略稳定的基石。\r\n" + 
				"阿巴西还如数家珍般介绍称：“我们已经开始收获‘中巴经济走廊’铁路、公路和其他基础设施项目的红利。‘中巴经济走廊’投资及其带动效应已经创造了大量就业机会。我们国家电网发电能力增加了1万兆瓦，这改善了我们长期以来的能源短缺局面。”\r\n" + 
				"图为写有“中巴友谊万岁”的隧道入口。\r\n" + 
				"事实上，中巴两国的“情比金坚”让想要挑事的美国媒体也不得不承认：“分析人士普遍认为，无论谁上台，都不会大幅度调整巴基斯坦与中国的关系。”\r\n" + 
				"责任编辑：桂强");
		JSONArray jsonArray =JSONArray.fromObject(results);
		System.out.println(jsonArray);
		resp.getWriter().println(jsonArray);*/
		
		
		
		System.out.println("进入IndexController!");
		resp.setContentType("text/text;charset=utf-8");
		//String docDir = "D:\\eclipse-workspace\\BooleanRetrival\\dataset";
		String dataDir = this.getServletContext().getRealPath("/dataset");
		String[] terms = req.getParameterValues("terms");
		String[] operators = req.getParameterValues("operators");
		//ArrayList<String> nameResults = new ArrayList<String>();
		//ArrayList<String> contentResults = new ArrayList<String>();
		TreeMap<String, String> results = new TreeMap<String, String>();
		
		boolean isChinese = true;
		BoolRetrivalModel br = new BoolRetrivalModel();
		Document document = new Document();
	//	document.fetchDocuments(docDir, isChinese);//处理文件//
//		String initDir = this.getServletContext().getRealPath("/lib");
		document.fetchDocuments(dataDir, isChinese);//处理文件//
		TreeMap<Integer, ArrayList<String>>documents =document.getDocuments();
		HashMap<Integer, String> docID_Name = document.getDocID_Name();
		HashMap<Integer, String> docID_Content = document.getDocID_Contents();
		br.buildDocID_TFmap(documents);//建立词频map
		br.buildInvertedIndex(documents);//建立倒排索引
		TreeMap<String, TreeMap<Integer,Integer>> invertedIndex= br.getInvertedIndex();
		ArrayList<Integer>ResultIDs = br.boolRetrival(terms, operators);
		if(null==ResultIDs) {//没有结果
			resp.getWriter().println(0);
		}else {
			for (int i = 0; i < ResultIDs.size(); i++) {
				int id = ResultIDs.get(i);
				//nameResults.add(docID_Name.get(id));
				//contentResults.add(docID_Content.get(id));
				results.put(docID_Name.get(id), docID_Content.get(id));
			} 
		if(results.isEmpty()) {//没有结果
			resp.getWriter().println(0);
		}else {
			JSONArray jsonArray =JSONArray.fromObject(results);
			System.out.println("jsonArray是： "+jsonArray);
			resp.getWriter().println(jsonArray);
		}
		System.out.println("检索结果是："+results);	
			//document.writeDocuments();//写入文件
			//br.writeIndex();//倒排索引写入文件
			
			//JSONArray jsonArray = new JSONArray();
			//jsonArray.add(nameResults);
			//jsonArray.add(nameResults);
			
		}
		
		
		
		
		
		
		
		
		
		
		/*HashMap<String,Integer> hs = new HashMap<>();
		hs.put("a", 1);hs.put("b",2);
		//resp.getWriter().println(hs);
		JSONArray jsonArray = JSONArray.fromObject(hs);
		System.out.println(jsonArray);
		resp.getWriter().println(jsonArray);*/
		
		/*boolean isChinese = true;
		BoolRetrivalModel br = new BoolRetrivalModel();
		Document document = new Document();
		System.out.println("提取文档前");
		document.FetchDocuments("D:\\eclipse-workspace\\BooleanRetrival\\data_train", isChinese);//处理文件//
		TreeMap<Integer, ArrayList<String>>documents =document.getDocuments();
		HashMap<Integer, String> docID_Content = document.getDocID_Contents();
		document.writeDocuments();//写入文件
		br.buildInvertedIndex(documents);//建立倒排索引
		br.writeIndex();//倒排索引写入文件
		TreeMap<String, ArrayList<Integer>> invertedIndex= br.getInvertedIndex();
		
		String[] boolTerms = {"许月","东方","姜艺","室友"};
		String[] boolOperators = {"not","and","and"};
		String[] boolTerms = {"姜艺"};
		String[] boolOperators = {};
		System.out.println("boolOperators是不是null："+boolOperators.length);
		ArrayList<Integer>results = br.boolRetrival(boolTerms, boolOperators);
		
		Iterator<String> it = invertedIndex.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key+"--->"+invertedIndex.get(key));
			
		}
		Iterator<Integer> its = documents.keySet().iterator();
		while(its.hasNext()) {
			int key = its.next();
			System.out.println(key+"--->"+ documents.get(key));
		}
		System.out.println(results);*/
		
	}
}
