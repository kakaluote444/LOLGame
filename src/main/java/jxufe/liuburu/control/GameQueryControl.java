package jxufe.liuburu.control;

import java.io.UnsupportedEncodingException;

import jxufe.liuburu.util.LOLGameUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/game")
public class GameQueryControl {
	/**
	 * 生成战绩请求参数
	 * @param qquin	玩家唯一编号
	 * @param area_id 大区编号
	 * @param bt_num 类型分类参数
	 * @param bt_list 类型分类参数 (注意：为数组形式)
	 * @param champion_id 召唤师编号
	 * @param offset 数据偏离量
	 * @param limit 分页大小
	 * @param mvp_flag 是否为mvp数据
	 * @return
	 */
	@RequestMapping("/pageData")
	@ResponseBody
	public static JSONObject queryGameData(
			@RequestParam("qquin")String qquin,
			@RequestParam("area_id")Integer area_id,
			@RequestParam(value="bt_num",defaultValue="0")Integer bt_num,
			@RequestParam(value="bt_list",defaultValue="-1")Integer bt_list,
			@RequestParam(value="champion_id",defaultValue="0")Integer champion_id,
			@RequestParam("offset")Integer offset,
			@RequestParam(value="limit",defaultValue="8")Integer limit,	
			@RequestParam(value="mvp_flag",defaultValue="-1")Integer mvp_flag){
		JSONObject resultObject = null;
		try {
			resultObject =  LOLGameUtil.queryGameDataByPage(qquin, area_id, bt_num, bt_list, champion_id, offset, limit, mvp_flag);
		} catch (UnsupportedEncodingException e) {
			System.out.println("战绩查询异常");
			e.printStackTrace();
		}
		return resultObject;
	}
}
