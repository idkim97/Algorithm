package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 백준1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<String> arr = new ArrayList<String>();
		
		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);
		int res = 0;
		
		// 듣도 못한 사람 넣기
		for(int i=0;i<n;i++) {
			String name = br.readLine();
			map.put(name, 1);
		}
		
		// 보도 못한 사람 찾기
		for(int i=0;i<m;i++) {
			String name = br.readLine();
			if(map.getOrDefault(name, 0)== 1) {
				arr.add(name);
				res++;
			}
		}
		
		Collections.sort(arr);
		
		System.out.println(res);
		
		for(int i=0;i<res;i++) {
			System.out.println(arr.get(i));
		}
	}
}
