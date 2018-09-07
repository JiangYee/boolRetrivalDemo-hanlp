package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;

import BooleanModel.BoolRetrivalModel;
import BooleanModel.Document;

public class TestIndex {
	public static void main(String[] args) {
		 List<Term> termList =HanLP.segment("中国科学院计算技术研究所的宗成庆教授正在教授自然语言处理课程");
	     System.out.println(termList);
	     BoolRetrivalModel br = new BoolRetrivalModel();
		 Document document = new Document();
		 boolean isChinese = true;
	     String dataDir = "/Users/j_yee/eclipse-workspace/BR_hanlp/dataset";
		 document.fetchDocuments(dataDir, isChinese);//处理文件//
			TreeMap<Integer, ArrayList<String>>documents =document.getDocuments();
			br.buildDocID_TFmap(documents);//建立词频map
			br.buildInvertedIndex(documents);//建立倒排索引
			br.writeIndex();//倒排索引写入文件
			TreeMap<String, TreeMap<Integer,Integer>> invertedIndex= br.getInvertedIndex();
//			System.out.println("tf"+br.getDocID_TFmap());
//			System.out.println(invertedIndex);
			
			TreeMap<String, String> indexOut = new TreeMap<String,String>();
			Iterator<String> it = invertedIndex.keySet().iterator();
			String term = null;
			TreeMap<Integer,Integer> posting = null;
			while(it.hasNext()) {
				term = it.next();
				posting = invertedIndex.get(term);
				StringBuffer out = new StringBuffer();
//				out.append(term+"--->[");
				out.append("--->[");
				for (Integer docID : posting.keySet()) { 
					int frequency = posting.get(docID);
					out.append(docID+"("+frequency+") ");
					} 
					out.append(']');
					indexOut.put(term, out.toString());
//					System.out.println(out);
			}
			
			Iterator<String> its = indexOut.keySet().iterator();
			while(its.hasNext()) {
				String term1 = its.next();
				System.out.println(term1+indexOut.get(term1));
			}
			
	}
	
}
