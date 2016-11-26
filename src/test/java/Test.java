import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Test {
	public void main() {
		List<Map<String, String>> menus = new ArrayList<Map<String,String>>();
			Map<String, String> map = new HashMap<String, String>(); // Map
	    map.put("name", "黄彪");
	    map.put("url", "home/welcome.jsp");
		    menus.add(map);
	}
}
