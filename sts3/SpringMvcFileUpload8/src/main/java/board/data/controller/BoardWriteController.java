package board.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.reboard.BoardDao;
import spring.mvc.reboard.BoardDto;

@Controller
public class BoardWriteController {

	@Autowired
	BoardDao dao;
	
	@GetMapping("board/writeform")
	public ModelAndView writeform(@RequestParam Map<String, String> map) {
		
		ModelAndView model=new ModelAndView();
		
		// 이 5개는 답글일 경우에만 넘어온다.(새 글일 경우 안넘어옴)
		String currentPage=map.get("currentPage");
		String num=map.get("num");
		String regroup=map.get("regroup");
		String restep=map.get("restep");
		String relevel=map.get("relevel");
		
		System.out.println(currentPage+","+num);
		
		//입력폼에 hidden으로 넣어줘야함.. 답글일 때 대비 
		model.addObject("currentPage", currentPage==null?"1":currentPage);
		model.addObject("num",num==null?"0":num);
		model.addObject("regroup",regroup==null?"0":regroup);
		model.addObject("restep",restep==null?"0":restep);
		model.addObject("relevel",relevel==null?"0":relevel);
		//0으로 넣어야 dao에서 새 글로 인식
		//폼이 답글, 새글 공용이므로
		
		model.setViewName("reboard/writeform");
		
		return model;
	}
	
	@PostMapping("board/insert")
	public ModelAndView insert(@ModelAttribute BoardDto dto,
			@RequestParam ArrayList<MultipartFile> uimage,
			HttpSession session) {
		
		ModelAndView model=new ModelAndView();
		
		//realpath(실제경로)
		String path=session.getServletContext().getRealPath("/WEB-INF/photo");
		System.out.println(path);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		String photo="";
		
		if(uimage.get(0).getOriginalFilename().equals("")) { //0번지 사진이 "" 이면
			photo="no";
		}else {
			for(MultipartFile f:uimage) {
				String fName=sdf.format(new Date())+"_"+f.getOriginalFilename();	
				photo=fName+",";
				
				try {
					f.transferTo(new File(path+"\\"+fName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//photo에서 마지막 컴마 제거
			photo=photo.substring(0, photo.length()-1);
		}
		//dto의 photo에 넣기
		dto.setPhoto(photo);
		
		//insert
		dao.insertReboard(dto);
		
		model.setViewName("redirect:list"); //content 일단 없으니까 목록으로 
		
		return model;
	}
}
