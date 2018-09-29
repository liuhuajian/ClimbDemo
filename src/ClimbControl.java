import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

public class ClimbControl {

	static final Log logger = LogFactory.getLog(ClimbControl.class);
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
        HttpClient client = new DefaultHttpClient();
        String url="http://search.jd.com/Search?keyword=Python&enc=utf-8&book=y&wq=Python&pvid=33xo9lni.p4a1qb";
        List<JdModel> bookdatas=URLFecter.URLParser(client, url);
        for (JdModel jd:bookdatas) {
            logger.info("bookID:"+jd.getBookID()+"\t"+"bookPrice:"+jd.getBookPrice()+"\t"+"bookName:"+jd.getBookName()+"\t"+"bookUrl:"+jd.getBookDetailUrl());
        }
        MYSQLControl.executeInsert(bookdatas);
	}

}
