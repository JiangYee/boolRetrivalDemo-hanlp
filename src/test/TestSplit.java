package test;

import BooleanModel.BoolRetrivalModel;
import BooleanModel.Document;

public class TestSplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean isChinese = true;
		Document document = new Document();
//		document.fetchDocuments("data_train", isChinese);//处理文件//
		String segments = document.getSegments().toString();
		String noPunSegments = document.getNoPunSegments().toString();
		System.out.println("segments=="+segments);
		System.out.println("noPunSegments=="+noPunSegments);
	}

}
