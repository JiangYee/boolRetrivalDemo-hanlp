package test;

import java.util.List;
import java.util.TreeMap;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;

import net.sf.json.JSONArray;

public class HanlpTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Term> termList = HanLP.segment("中国科学院计算技术研究所的宗成庆教授正在教授自然语言处理课程");
	        for (int i = 0; i < termList.size(); i++) {
				String term = termList.get(i).toString();
				String term0 = term.replaceAll("\\pP.*", "");
				System.out.println(term+"===="+term0);
			}
	        TreeMap<String, TreeMap<String,Integer>>tm = new TreeMap<String, TreeMap<String,Integer>>();
			TreeMap<String,Integer> tm0 = new TreeMap<String,Integer>();
			tm0.put("一",1);
			tm0.put("二",2);
			tm0.put("三",3);
			tm.put("a", tm0);
			tm.put("b", tm0);
			JSONArray jsonArray =JSONArray.fromObject(tm);
			System.out.println(jsonArray);
	}

}
