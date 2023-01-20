package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dto.BoardDTO;
import dto.PageDTO;
import service.BoardService;

//http://localhost:8090/myapp/list.do
//http://localhost:8090/myapp/list.do?currentPage=1

@Controller
public class BoardController {
	private BoardService service;
	private PageDTO pdto;
	private int currentPage;

	public BoardController() {

	}
	
	public void setService(BoardService service) {
		this.service = service;
	}
	
	@RequestMapping("/list.do")
	public ModelAndView listMethod(PageDTO pv, ModelAndView mav) {
		int totalRecord = service.countProcess();
		if (totalRecord >= 1) {
			if (pv.getCurrentPage() == 0)
				this.currentPage = 1;
			else
				this.currentPage = pv.getCurrentPage();

			this.pdto = new PageDTO(currentPage, totalRecord);
			List<BoardDTO> aList = service.listProcess(this.pdto);
			mav.addObject("aList", aList);
			mav.addObject("pv", this.pdto);
		}
		mav.setViewName("list");
		return mav;
	}//end listMethod()
	
	@RequestMapping("/view.do")
	public ModelAndView viewMethod(int currentPage, int no, ModelAndView mav) {
		mav.addObject("dto", service.contentProcess(no));
		mav.addObject("currentPage", currentPage);
		mav.setViewName("view");
		return mav;
	}
	
	@RequestMapping(value="/write.do", method= RequestMethod.GET)
	public ModelAndView writeMethod(BoardDTO dto, PageDTO pv, ModelAndView mav) {
		if(dto.getRef()!=0) {
			mav.addObject("currentPage", pv.getCurrentPage());
			mav.addObject("dto",dto);
		}
		mav.setViewName("write");
		return mav;
	}//end writeMethod()
	
	@RequestMapping(value="/write.do",method=RequestMethod.POST)
	public String writeProcessMethod(BoardDTO dto, PageDTO pv) {
		service.insertProcess(dto);
		if(dto.getRef()!=0) {
			return "redirect:/list.do?currentPage=" + pv.getCurrentPage();
		}else {
			return "redirect:/list.do";
		}
	}//end writeProcessMethod()

}
