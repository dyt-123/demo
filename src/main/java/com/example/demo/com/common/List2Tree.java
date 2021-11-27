package com.example.demo.com.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

public class List2Tree {
	public static String idKey = "id";
	public static String idName = "label";

	public static JSONArray listToTree(JSONArray arr, String id, String name, String pid, String child, Boolean  expand, String idKey1, String idName1) {
		JSONArray r = new JSONArray();
		JSONObject hash = new JSONObject();
		// 将数组转为Object的形式，key为数组中的id
		for (int i = 0; i < arr.size(); i++) {
			JSONObject json = (JSONObject) arr.get(i);
			json.put(StringUtils.hasText(idKey1)?idKey1:idKey, json.getString(id));
			json.put(StringUtils.hasText(idName1)?idName1:idName, json.getString(name));
			hash.put(json.getString(id), json);
		}
		// 遍历结果集
		for (int j = 0; j < arr.size(); j++) {
			// 单条记录
			JSONObject aVal = (JSONObject) arr.get(j);
			// 在hash中取出key为单条记录中pid的值
			JSONObject hashVP = (JSONObject) hash.get(aVal.get(pid).toString());
			// 如果记录的pid存在，则说明它有父节点，将她添加到孩子节点的集合中
			if (hashVP != null) {
				// 检查是否有child属性
				if (hashVP.get(child) != null) {
					JSONArray ch = (JSONArray) hashVP.get(child);
					ch.add(aVal);
					hashVP.put(child, ch);
				} else {
					JSONArray ch = new JSONArray();
					ch.add(aVal);
					hashVP.put(child, ch);
				}
			} else {
				if(expand!=null && expand){
					aVal.put("expanded", true);
				}
				r.add(aVal);
			}
		}
		return r;
	}
}