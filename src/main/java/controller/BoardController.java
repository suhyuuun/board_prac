package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
