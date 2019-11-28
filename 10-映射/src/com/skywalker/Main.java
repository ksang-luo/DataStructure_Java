package com.skywalker;

import com.skywalker.file.FileInfo;
import com.skywalker.file.Files;
import com.skywalker.map.Map;
import com.skywalker.map.Map.Visitor;
import com.skywalker.map.TreeMap;
import com.skywalker.set.Set;
import com.skywalker.set.TreeSet;

public class Main {
	
	static void test1() {
		Map<String, Integer> map = new TreeMap<>();
		map.put("c", 2);
		map.put("a", 5);
		map.put("b", 6);
		map.put("a", 8);
		
		map.traversal(new Visitor<String, Integer>() {
			public boolean visit(String key, Integer value) {
				System.out.println(key + "_" + value);
				return false;
			}
		});
	}
	
	static void test2() {
		FileInfo fileInfo = Files.read("/Users/ksang/Desktop/数据结构与算法", 
				new String[]{"java"});
		
		System.out.println("文件数量：" + fileInfo.getFiles());
		System.out.println("代码行数：" + fileInfo.getLines());
		String[] words = fileInfo.words();
		System.out.println("单词数量：" + words.length);
		
		Map<String, Integer> map = new TreeMap<>();
		for (int i = 0; i < words.length; i++) {
			Integer count = map.get(words[i]);
			count = (count == null) ? 1 : (count + 1);
			map.put(words[i], count);
		}
		
		map.traversal(new Visitor<String, Integer>() {
			public boolean visit(String key, Integer value) {
				System.out.println(key + "_" + value);
				return false;
			}
		});
	}
	
	static void test3() {
		Set<String> set = new TreeSet<>();
		set.add("c");
		set.add("b");
		set.add("c");
		set.add("c");
		set.add("a");
		
		set.traversal(new Set.Visitor<String>() {
			public boolean visit(String element) {
				System.out.println(element);
				return false;
			}
		});
	}

	public static void main(String[] args) {
		test2();
		
		System.err.println("***********");
		
		test3();
	}

}
