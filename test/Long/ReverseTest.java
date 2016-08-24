package Long;

public class ReverseTest {
	
	public static void main(String[] args) {
//		int i = Integer.reverse(123456789);
//		System.out.println(i);
		StringBuilder sb = new StringBuilder("你");
		sb.append("好");
		sb.append("中");
		sb.append("国");
		sb.reverse();
		System.out.println(sb);
	}

}
