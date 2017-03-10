package com.classnet.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListUtil {
	public static List listChange(List list ,String key)
	{
		List resultList = new ArrayList();
		for(int i=0;i<list.size();i++)
		{
			HashMap<String, String> map = new HashMap();
			if(list.get(i)!=null && !"".equals(list.get(i)))
			{
				String value= list.get(i).toString();
				map.put(key, value);
				resultList.add(map);
			}
		}
		return resultList;
	}
	
	public static void main(String []args)
	{
		System.out.println(13/5*5);
	}

}
