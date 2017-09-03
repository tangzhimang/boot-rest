package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import model.ThreeWord;
import service.ReadText;

@RestController
public class ThreeWordController {
	
	@RequestMapping("/ThreeWord")
		public ThreeWord threeWord() throws Exception {
			return new ThreeWord(0,"success",ReadText.getThreeWordString());
		}

}
