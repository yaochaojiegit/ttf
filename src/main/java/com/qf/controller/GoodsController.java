package com.qf.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.qf.utils.UpLoadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qf.pojo.Goods;
import com.qf.pojo.UINum2;
import com.qf.pojo.UiPageNum;
import com.qf.service.GoodsService;



/**
*@author:老姚
*@date 2018年1月12日
*备注：
*/
@Controller
public class GoodsController {

	@Autowired
	private GoodsService service;
	@RequestMapping("/AdminListGoodsServlet")
	@ResponseBody
	public UiPageNum r(UINum2 uiNum2){
		
		System.err.println(uiNum2);
		
		return service.selectByUI(uiNum2);
	}
	@RequestMapping("/AdminUpGoods")
	@ResponseBody
	public int r2(String check){
		if (service.restoreGoods(check)) {
			return 1;
		}
		return 0;
	}
	
	@RequestMapping("/AdminDownGoods")
	@ResponseBody
	public int r3(String check){
		if (service.deleteGoods(check)) {
			return 1;
		}
		return 0;
	}
	
	@RequestMapping("/GoodUpd")
	@ResponseBody
	public void r4(Integer chec,HttpSession session){
		session.setAttribute("gid", chec);
	}
	
	@RequestMapping("/AdminUpdetG")
	@ResponseBody
	public Goods r5(HttpSession session){
		Integer id=(Integer) session.getAttribute("gid");
		
		return service.selectById(id);
	}
	
	@RequestMapping(value="/AdGoodsUpd",method={RequestMethod.POST})
	@ResponseBody
	public int r6(Goods goods){
		System.err.println("goods="+goods);
		if (service.updateGoods(goods)) {
			return 1;
		}
		return 0;
	}
	
	@RequestMapping(value="/AdminGoodsAddServle",method={RequestMethod.POST})
	@ResponseBody
	public int r7(MultipartFile file,Goods goods,HttpServletRequest request){
				//保存文件
				String baseDir="D:/tmp";
				System.err.println(baseDir);
				if(file!=null){
					//1新的文件名
					String oldfilename = file.getOriginalFilename();
						if(oldfilename!=null&&!oldfilename.trim().equals("")){
						String newfilename=UpLoadUtils.getFileName(oldfilename);
						//2得到新的路径
						String filepath = UpLoadUtils.getDir(baseDir, newfilename);
						//3保存
						File file1=new File(filepath, newfilename);
						try {
							//4把数据保存到数据库中
							file.transferTo(file1);
							System.err.println("上传成功    "+file1.getAbsolutePath().substring(6));
							goods.setPicture("\\pic"+file1.getAbsolutePath().substring(6));
							Date date=new Date();
							goods.setPubdate(date);
							if(service.insertGoods(goods)){
								return 1;
							}
						} catch (IllegalStateException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
						
						
					}
				}else {
					System.err.println("上传失败");
				}
		return 0;
	}
	
	@RequestMapping("/uuuu")
	@ResponseBody
	public Goods r8(Integer id){
		return service.selectById(id);
	}
	
}
